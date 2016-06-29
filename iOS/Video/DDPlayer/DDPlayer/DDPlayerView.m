//
//  DDPlayerView.m
//  DDPlayer
//
//  Created by 张德荣 on 16/5/25.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "DDPlayerView.h"
#import <AVFoundation/AVFoundation.h>
#import <MediaPlayer/MediaPlayer.h>
#import "DDPlayer.h"
#import "DDPlayerControlView.h"
#import "DDBrightnessView.h"


static const CGFloat DDPlayerAnimationTimeInterval = 7.0f;
static const CGFloat DDPlayerControlBarAutoFadeOutTimeInterval = 0.5f;


typedef NS_ENUM(NSUInteger, PanDirection) {
    PanDirectionHorizontalMoved,   //横向移动
    PanDirectionVerticalMoved      //纵向移动
};

typedef NS_ENUM(NSUInteger, DDPlayerState) {
    DDPlayerStateFailed,     //播放失败
    DDPlayerStateBuffering,  //缓冲中
    DDPlayerStatePlaying,    //播放中
    DDPlayerStateStopped,    //停止播放
    DDPlayerStatePause       //暂停播放
};


@interface DDPlayerView () <UIGestureRecognizerDelegate>
/** 播放属性 */
@property (nonatomic, strong) AVPlayer *player;
/** 播放属性 */
@property (nonatomic, strong) AVPlayerItem *playerItem;
/** playerLayer */
@property (nonatomic, strong) AVPlayerLayer *playerLayer;
/** 滑杠 */
@property (nonatomic, strong) UISlider *volumViewSlider;
/** 计时器 */
@property (nonatomic, strong) NSTimer *timer;
/** 控制层View */
@property (nonatomic, strong) DDPlayerControlView *controlView;
/** 用来保存快进的总时长 */
@property (nonatomic, assign) CGFloat subTime;
/** 定义一个实例变量，保存枚举值 */
@property (nonatomic, assign) PanDirection panDirection;
/** 播放器的几种状态 */
@property (nonatomic, assign) DDPlayerState state;
/** 是否为全屏 */
@property (nonatomic, assign) BOOL isFullScreen;
/** 是否锁定屏幕方向 */
@property (nonatomic, assign) BOOL isLocked;
/** 是否在调节音量 */
@property (nonatomic, assign) BOOL isVolume;
/** 是否显示controlView */
@property (nonatomic, assign) BOOL isMaskShowing;
/** 是否被用户暂停 */
@property (nonatomic, assign) BOOL isPauseByUser;
/** 是否播放本地文件 */
@property (nonatomic, assign) BOOL isLocalVideo;
/** slider上次的值 */
@property (nonatomic, assign) CGFloat sliderLastValue;
/** 是否再次设置URL播放视频 */
@property (nonatomic, assign) BOOL repeatToPlay;
/** 播放完了 */
@property (nonatomic, assign) BOOL playDidEnd;
/** 进入后台 */
@property (nonatomic, assign) BOOL didEnterBackground;

#pragma mark -UITableVieCell PlayerView
/** palyer加到tableView */
@property (nonatomic, strong) UITableView *tableView;
/** player所在cell的indexPath */
@property (nonatomic, strong) NSIndexPath *indexPath;
/** cell上imageView的tag */
@property (nonatomic, assign) NSInteger cellImageViewTag;
/** ViewController总页面是否消失 */
@property (nonatomic, assign) BOOL viewDisappear;
/** 是否在cell上播放video */
@property (nonatomic, assign) BOOL isCellVideo;
/** 是否缩小视频在底部 */
@property (nonatomic, assign) BOOL isBottomVideo;
/** 是否切换分辨率 */
@property (nonatomic, assign) BOOL isChangeResolution;
@end

@implementation DDPlayerView
#pragma mark - lift Cycle
+ (instancetype)sharePlayerView{
    static DDPlayerView *playerView = nil;
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        playerView = [[DDPlayerView alloc] init];
    });
    return playerView;
}
/**
 带初始化调用次方法
 */
- (instancetype)init
{
    self = [super init];
    if (self) {
        [self initializeThePlayer];
    }
    return self;
}
/**
 storyboard 、xib加载playerVie会调用次方法
 */
- (void)awakeFromNib{
    [self initializeThePlayer];
}

/**
 初始化player
 */
- (void)initializeThePlayer {
    //每次播放视频都解锁屏幕锁定
    [self unlockTheScreen];
}
- (void)dealloc{
    self.playerItem = nil;
    self.tableView = nil;
    //移除通知
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}
/**
 重置player
 */
- (void)resetPlayer{
    
    //改为为播放完
    self.playDidEnd = NO;
    self.playerItem = nil;
    self.didEnterBackground = NO;
    //视频跳转秒数置0
    self.seekTime = 0;
    [[NSNotificationCenter defaultCenter] removeObserver:self];
    //关闭定时器
    [self.timer invalidate];
    //暂停
    [self pause];
    //移除原来的layer
    [self.playerLayer removeFromSuperlayer];
    //替换PlayerItem为nil
    [self.player replaceCurrentItemWithPlayerItem:nil];
    //把player置为nil
    self.player = nil;
    if (self.isChangeResolution) {
//        [self.controlView resetControlViewForResolution];  
        self.isChangeResolution = NO;
    } else { //重置控制层View
//        [self.controlView resetControlView];
        
    }
    // 非重播时，移除当前playerView
    if (!self.repeatToPlay) {
        [self removeFromSuperview];
    }
    //底部播放video改为NO
    self.isBottomVideo = NO;
    // cell上播放视频 && 不是重播时
    if (self.isCellVideo && !self.repeatToPlay) {
        //vicontroller中页面消失
        self.viewDisappear = YES;
        self.isCellVideo = NO;
        self.tableView = nil;
        self.indexPath = nil;
        
    }
}
- (void)resetControlViewForResolution
{
    
}
/**
 设置Player相关参数
 */
- (void)configDDPlayer{
    //初始化playerItem
    self.playerItem = [AVPlayerItem playerItemWithURL:self.videoURL];
    
    //每次都重新创建Player，替换replaceCurrentItemWithPlayerItem:,改方法阻塞线程
    self.player = [AVPlayer playerWithPlayerItem:self.playerItem];
    
    //初始化playerLayer
    self.playerLayer = [AVPlayerLayer playerLayerWithPlayer:self.player];
    
    //此处为默认视频填充模式
    self.playerLayer.videoGravity = AVLayerVideoGravityResizeAspect;
    //添加playerLayer到self.layer
    [self.layer insertSublayer:self.playerLayer atIndex:0];
    
    //初始化显示controlView为YES
    self.isMaskShowing = YES;
    // 延迟隐藏controlView
    [self autoFadeOutControlBar];
    
    //计时器
    [self createTimer];
    
    //添加手势
    [self createGesture];
    
    //获取系统音量
    [self configureVolume];
    
    // 本地文件不设置DDPlayerStateBuffering状态
    if ([self.videoURL.scheme isEqualToString:@"file"]) {
        self.state = DDPlayerStatePlaying;
        self.isLocalVideo = YES;
//        self.controlView.hasDownload
    } else {
        self.state = DDPlayerStateBuffering;
        self.isLocalVideo = NO;
    }
    //开始播放
    [self play];
//    self.controlView
    
}
- (void)unlockTheScreen {
	
}
- (void)resetControlView
{
}
#pragma mark - ShowOrHideControlView
- (void)autoFadeOutControlBar {
	if (!self.isMaskShowing)  return ;
    [NSObject cancelPreviousPerformRequestsWithTarget:self selector:@selector(hideControlView) object:nil];
    [self performSelector:@selector(hideControlView) withObject:nil afterDelay:DDPlayerControlBarAutoFadeOutTimeInterval];
}
/**
 创建timer
 */
- (void)createTimer {
    
    self.timer = [NSTimer scheduledTimerWithTimeInterval:1.0 target:self selector:@selector(playerTimerAction) userInfo:nil repeats:YES];
    [[NSRunLoop currentRunLoop] addTimer:self.timer forMode:NSRunLoopCommonModes];
}
/**
 创建手势
 */
- (void)createGesture {
	//单击
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(tapActinon:)];
    //双击(播放/暂停)
    UITapGestureRecognizer *doubleTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(doubleTapAction:)];
    doubleTap.numberOfTapsRequired = 2;
    [self addGestureRecognizer:doubleTap];
    
    [tap requireGestureRecognizerToFail:doubleTap];
    
}
#pragma mark - Action
- (void)tapActinon:(UITapGestureRecognizer *)gesture
{
    if (gesture.state == UIGestureRecognizerStateRecognized) {
        if (self.isBottomVideo && !self.isFullScreen) {
            [self fullScreenAction:self.controlView.fullScreenBtn];
            return;
        }
        self.isMaskShowing ?([self hideControlView]):([self animateShow]);
    }
}
/**
 隐藏控制层
 */
- (void)hideControlView
{
    if (!self.isMaskShowing) {
        return;
    }
    [UIView animateWithDuration:DDPlayerControlBarAutoFadeOutTimeInterval animations:^{
        [self.controlView hideControlView];
        if (self.isFullScreen) { //全屏状态
            self.controlView.backBtn.alpha = 0;
            [[UIApplication sharedApplication] setStatusBarHidden:YES withAnimation:UIStatusBarAnimationFade];
        } else if (self.isBottomVideo && !self.isFullScreen) { //视频在底部bottom小屏，并且不是全屏状态
            self.controlView.backBtn.alpha  = 1;
        } else {
            self.controlView.backBtn.alpha = 0;
        }
    } completion:^(BOOL finished) {
        self.isMaskShowing = NO;
    }];
}
/**
 显示控制层
 */
- (void)animateShow
{
    if (self.isMaskShowing) {
        return;
    }
    
    [UIView animateWithDuration:DDPlayerControlBarAutoFadeOutTimeInterval animations:^{
        self.controlView.backBtn.alpha = 1;
        if (self.isBottomVideo && !self.isFullScreen) {
            [self.controlView hideControlView]; //视频在底部bottom小屏，并且不是全屏状态
        } else if (self.playDidEnd){
            [self.controlView hideControlView]; //播放完了
        } else {
            [self.controlView showControlView];
        }
        [[UIApplication sharedApplication] setStatusBarHidden:NO withAnimation:UIStatusBarAnimationFade];
    } completion:^(BOOL finished) {
        self.isMaskShowing = YES;
        [self autoFadeOutControlBar];
    }];
}
//设置横屏的约束
- (void)setorientationLandscape
{
    if (self.isCellVideo) {
        //横屏时候移除tableVIe的观察着
        [self.tableView removeObserver:self forKeyPath:kDDPlayerViewContentOffSet];
        
        [[UIApplication sharedApplication] setStatusBarStyle:UIStatusBarStyleLightContent animated:YES];
        // 亮度view加到window最上层
        DDBrightnessView *brightnessView = [DDBrightnessView sharedInstance];
        [[UIApplication sharedApplication].keyWindow insertSubview:self belowSubview:brightnessView];
        [self mas_remakeConstraints:^(MASConstraintMaker *make) {
            (void)make.edges;
        }];
    }
}
/**
 设置竖屏的约束
 */
- (void)setOrientationPortrait
{
    if (self.isCellVideo) {
        [[UIApplication sharedApplication] setStatusBarStyle:UIStatusBarStyleDefault animated:YES];
        [self removeFromSuperview];
        UITableViewCell *cell = [self.tableView cellForRowAtIndexPath:self.indexPath];
        NSArray *visableCells = self.tableView.visibleCells;
        self.isBottomVideo = NO;
        if (![visableCells containsObject:cell]) {
            [self updatePlayerViewToBottom];
        } else {
            //根据tag取到对应的cellImageView
            UIImageView *cellImageView = [cell viewWithTag:self.cellImageViewTag];
            [self addPlayerToCellImageView:cellImageView];
        }
    }
}
/**
 缩小到底部，显示小视频
 */
- (void)updatePlayerViewToBottom
{
    if (self.isBottomVideo)  return ;
    self.isBottomVideo = YES;
    if (self.playDidEnd) { //如果播放完了,滑动到小屏bottom位置时，直接resetPlayer
        self.repeatToPlay = NO;
        self.playDidEnd = NO;
        [self resetPlayer];
        return;
    }
    [[UIApplication sharedApplication].keyWindow addSubview:self];
    //解决4s, 屏幕宽高比不是16：9的问题
    if (iPhone4s) {
        [self mas_remakeConstraints:^(MASConstraintMaker *make) {
            CGFloat width = ScreenWidth * 0.5 - 20;
            make.width.mas_equalTo(-10);
            make.trailing.mas_equalTo(-10);
            make.bottom.mas_equalTo(-self.tableView.contentInset.bottom - 10);
            make.height.mas_equalTo(width*320/480).priority(750);
        }];
    } else {
        [self mas_remakeConstraints:^(MASConstraintMaker *make) {
            CGFloat width = ScreenWidth*0.5-20;
            make.width.mas_equalTo(width);
            make.trailing.mas_equalTo(-10);
            make.bottom.mas_equalTo(-self.tableView.contentInset.bottom-10);
            make.height.equalTo(self.mas_width).multipliedBy(9.0/16.0).priority(750);
        }];
    }
    //不显示控制层
    [self.controlView hideControlView];
}
/**
 强制屏幕旋转
 
 @param orientation 屏幕方向
 */
- (void)interfaceOrientation:(UIInterfaceOrientation)orientation
{
    //arc下
    if ([[UIDevice currentDevice] respondsToSelector:@selector(setOrientation:)]) {
        SEL selector = NSSelectorFromString(@"setOrientation:");
        NSInvocation *invocation = [NSInvocation invocationWithMethodSignature:[UIDevice instanceMethodSignatureForSelector:selector]];
        [invocation setSelector:selector];
        [invocation setTarget:[UIDevice currentDevice]];
        int val = orientation;
        //从而开始是因为 0 1 两个参数已经被seletor和target占用
        [invocation setArgument:&val atIndex:2];
        [invocation invoke];
    }
    
    if (orientation == UIInterfaceOrientationLandscapeRight || orientation == UIInterfaceOrientationLandscapeLeft) {
        //设置横屏
        [self setorientationLandscape];
    } else if (orientation == UIInterfaceOrientationPortrait) {
        //设置竖屏
        [self setOrientationPortrait];
    }
}
/**
 全屏按钮事件
 
 @param sender 全屏Button
 */
- (void)fullScreenAction:(UIButton *)sender
{
    if (self.isLocked) {
        [self unlockTheScreen];
        return;
    }
    if (self.isCellVideo && sender.selected == YES) {
        [self interfaceOrientation:UIInterfaceOrientationPortrait];
        return;
    }
    
    UIDeviceOrientation orientation = [UIDevice currentDevice].orientation;
    UIInterfaceOrientation interfaceOrientation = (UIInterfaceOrientation)orientation;
    
    switch (interfaceOrientation) {
        
        case UIInterfaceOrientationPortrait: {
            DDPlayerShard.isAllowLandscape = YES;
            [self interfaceOrientation:UIInterfaceOrientationLandscapeRight];
            break;
        }
        case UIInterfaceOrientationPortraitUpsideDown: {
            DDPlayerShard.isAllowLandscape = NO;
            [self interfaceOrientation:UIInterfaceOrientationLandscapeRight];
            break;
        }
        case UIInterfaceOrientationLandscapeLeft: {
            if (self.isBottomVideo || !self.isFullScreen) {
                DDPlayerShard.isAllowLandscape = YES;
                [self interfaceOrientation:UIInterfaceOrientationLandscapeRight];
            } else {
                DDPlayerShard.isAllowLandscape = NO;
                [self interfaceOrientation:UIInterfaceOrientationPortrait];
            }
            break;
        }
        case UIInterfaceOrientationLandscapeRight: {
            if (self.isBottomVideo || !self.isFullScreen) {
                DDPlayerShard.isAllowLandscape = YES;
                [self interfaceOrientation:UIInterfaceOrientationLandscapeRight];
            } else {
                DDPlayerShard.isAllowLandscape = NO;
                [self interfaceOrientation:UIInterfaceOrientationPortrait];
            }
            break;
        }
        case UIInterfaceOrientationUnknown: {
            
//            break;
        }
        default:{
            if (self.isBottomVideo || !self.isFullScreen) {
                DDPlayerShard.isAllowLandscape = YES;
                [self interfaceOrientation:UIInterfaceOrientationLandscapeRight];
            } else {
                DDPlayerShard.isAllowLandscape = NO;
                [self interfaceOrientation:UIInterfaceOrientationPortrait];
            }
        }
            break;
    }
}
/**
 获取系统音量
 */
- (void)configureVolume{
    MPVolumeView *volumeView = [[MPVolumeView alloc] init];
    _volumViewSlider = nil;
    for (UIView *view in volumeView.subviews) {
        if ([[view.class description] isEqualToString:@"MPVolumeSlider"]) {
            _volumViewSlider = (UISlider *)view;
            break;
        }
    }
    
    // 使用这个category的应用不会随着手机静音键打开而静音，可在手机静音下播放声音
    NSError *setCategoryError = nil;
    BOOL success = [[AVAudioSession sharedInstance] setCategory:AVAudioSessionCategoryPlayback error:&setCategoryError];
    if (!success) {
        /** handle the error in setCategoryError */
    }
    
    //监听耳机插入和拔掉通知
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(audioRouteChangeListenerCallback:) name:AVAudioSessionRouteChangeNotification object:nil];
}
/**
 耳机插入、拔出事件
 */
- (void)audioRouteChangeListenerCallback:(NSNotification *)notificaiton
{
    NSDictionary *interuptionDic = notificaiton.userInfo;
    NSInteger routeChangeReason = [[interuptionDic valueForKey:AVAudioSessionRouteChangeReasonKey] integerValue];
    switch (routeChangeReason) {
        case AVAudioSessionRouteChangeReasonNewDeviceAvailable:
            //耳机插入
            break;
        case AVAudioSessionRouteChangeReasonOldDeviceUnavailable:
        {
            // 耳机拔掉
            // 拔掉耳机继续播放
            [self play];
        }
            case AVAudioSessionRouteChangeReasonCategoryChange:
        {
            NSLog(@"AVAudioSessionRouteChangeReasonCategoryChange");
        }
        default:
            break;
    }
}
/**
 从xx秒开始播放视频跳转
 
 @param dragedSeconds     视频跳转的秒数
 */
- (void)seekToTime:(NSInteger)dragedSeconds completionHandler:(void (^)(BOOL finished))completionHandler {
    if (self.player.currentItem.status == AVPlayerItemStatusReadyToPlay) {
        // seekTime:completionHandler:不能精确定位
        // 如果需要精确定位，可以使用seekToTime:toleranceBefore:toleranceAfter:completionHandler:
        // 转换成CMTime才能给player来控制播放进度
        CMTime dragedCMTime = CMTimeMake(dragedSeconds, 1);
        [self.player seekToTime:dragedCMTime toleranceBefore:kCMTimeZero toleranceAfter:kCMTimeZero completionHandler:^(BOOL finished) {
            // 视频跳转回调
            if (completionHandler) {
                completionHandler(finished);
            }
            //如果点击了暂停按钮
            if (self.isPauseByUser) {
                return;
            }
            [self player];
            self.seekTime = 0;
            if (!self.playerItem.isPlaybackLikelyToKeepUp && !self.isLocalVideo) {
                self.state = DDPlayerStateBuffering;
            }
        }];
    }
}
- (void)setPlayerItem:(AVPlayerItem *)playerItem {
    if (_playerItem == playerItem) {
        return;
    }
    if (_playerItem) {
        [[NSNotificationCenter defaultCenter] removeObserver:self name:AVPlayerItemDidPlayToEndTimeNotification object:_playerItem];
        [_playerItem removeObserver:self forKeyPath:@"status"];
        [_playerItem removeObserver:self forKeyPath:@"loadedTimeRanges"];
        [_playerItem removeObserver:self forKeyPath:@"playbackBufferEmpty"];
        [_playerItem removeObserver:self forKeyPath:@"playbackLikelyToKeepUp"];
    }
    _playerItem = playerItem;
    if (playerItem) {
        [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(moviePlayDidEnd:) name:AVPlayerItemDidPlayToEndTimeNotification object:playerItem];
        [playerItem addObserver:self forKeyPath:@"loadTimeRanges" options:NSKeyValueObservingOptionNew context:nil];
        //缓冲区空了，需要等待数据
        [playerItem addObserver:self forKeyPath:@"playbackBufferEmpty" options:NSKeyValueObservingOptionNew context:nil];
        //缓冲区有足够数据 可以播放了
        [playerItem addObserver:self forKeyPath:@"playbackLikeToKeepUp" options:NSKeyValueObservingOptionNew context:nil];
    }
}

#pragma mark - NSNotification Action
- (void)moviePlayDidEnd:(NSNotification *)notification {
    self.state = DDPlayerStateStopped;
    if (self.isBottomVideo && !self.isFullScreen) { //播放完了，如果是在小屏模式 && 在bottom位置，直接关闭播放器
        self.repeatToPlay = NO;
        self.playDidEnd = NO;
        [self resetPlayer];
    } else {
        self.controlView.backgroundColor = RGBA(0, 0, 0, .6);
        self.playDidEnd = YES;
        self.controlView.repeatBtn.hidden = NO;
        //初始化显示controlView为YES
        self.isMaskShowing = NO;
        [self animateShow];
    }
}

#pragma mark - KVO
- (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSString *,id> *)change context:(void *)context {
    if (object == self.player.currentItem) {
        if ([keyPath isEqualToString:@"status"]) {
            if (self.player.currentItem.status == AVPlayerItemStatusReadyToPlay) {
                self.state = DDPlayerStatePlaying;
                // 加载完成后，再添加平移手势
                // 添加平移手势，用来控制音量，亮度、快进快退
                UIPanGestureRecognizer *pan = [[UIPanGestureRecognizer alloc] initWithTarget:self action:@selector(panDirection:)];
                pan.delegate = self;
                [self addGestureRecognizer:pan];
                
                //跳到xx秒播放视频
                if (self.seekTime) {
                    [self seekToTime:self.seekTime completionHandler:nil];
                }
                
            } else if (self.player.currentItem.status == AVPlayerItemStatusFailed) {
                self.state = DDPlayerStateFailed;
//                self.controlView.
            }
        }
        else if ([keyPath isEqualToString:@"loadedTimeRanges"]) {
          //计算缓冲进度
            NSTimeInterval timeInterval = [self availableDuration];
        }
    } 
}
#pragma mark - 缓冲较差时候
/**
 缓冲较差时候回调这里
 */
- (void)bufferingSomeSecond
{
    self.state = DDPlayerStateBuffering;
    //playbackBufferEmpty会反复进入，因此在bufferingOneSecond延时播放执行完之前再调用bufferingSomeSecond都忽略
    
    __block BOOL isBuffering = NO;
    if (isBuffering) {
        return;
    }
    isBuffering = YES;
    
    // 需要先暂停一小会之后再播放，否则网络状况不好的时候时间在走，声音播放不出来
    [self pause];
    dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)(1.0 * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
        //如何此时用户已经暂停了，则不需要开启播放了
        if (self.isPauseByUser) {
            isBuffering = NO;
            return ;
        }
        
        [self play];
        // 如果执行了play 还是没有播放则说明还没有缓存好，则再次缓存一段时间
        isBuffering = NO;
        if (!self.playerItem.isPlaybackLikelyToKeepUp) {
            [self bufferingSomeSecond];
        }
    });
}

#pragma mark - 计时器事件
/**
 计时器事件
 */
- (void)playerTimerAction {
    if (_playerItem.duration.timescale != 0) {
        self.controlView.videoSlider.value = CMTimeGetSeconds([_playerItem currentTime])/
        (_playerItem.duration.value / _playerItem.duration.timescale);//当前进度
        
        //当前时长进度progress
        NSInteger proMin = (NSInteger)CMTimeGetSeconds([_player currentTime]) / 60;//当前秒
        NSInteger proSec = (NSInteger)CMTimeGetSeconds([_player currentTime]) % 60;//当前分钟
        
        //duration 总时长
        NSInteger durMin = (NSInteger)_playerItem.duration.value / _playerItem.duration.timescale / 60; //总秒
        NSInteger durSec = (NSInteger)_playerItem.duration.value / _playerItem.duration.timescale % 60; //总分钟
        
        self.controlView.currentTimeLabel.text = [NSString stringWithFormat:@"%02zd:%02zd",proMin, proSec];
        self.controlView.totalTimeLabel.text = [NSString stringWithFormat:@"%02zd:%02zd",durMin, durSec];
    }
}
/**
 计算缓冲进度
 @return 缓冲进度
 */
- (NSTimeInterval )availableDuration {
    NSArray *loadedTimeRanges = [[_player currentItem] loadedTimeRanges];
    CMTimeRange timeRange = [loadedTimeRanges.firstObject CMTimeRangeValue];  //获取缓冲区域
    float startSeconds = CMTimeGetSeconds(timeRange.start);
    float durationSeconds = CMTimeGetSeconds(timeRange.duration);
    NSTimeInterval result= startSeconds + durationSeconds; // 计算缓冲总进度
    return result;
}
@end
