//
//  DDPlayerControlView.h
//  DDPlayer
//
//  Created by 张德荣 on 16/5/31.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DDPlayerControlView : UIView
/** 开始播放按钮 */
@property (nonatomic, strong, readonly) UIButton *startBtn;
/** 当前播放时长lable */
@property (nonatomic, strong, readonly) UILabel *currentTimeLabel;
/** 视频总时长label */
@property (nonatomic, strong, readonly) UILabel *totalTimeLabel;
/** 缓冲进度条 */
@property (nonatomic, strong, readonly) UIProgressView *progressView;
/** 滑竿 */
@property (nonatomic, strong, readonly) UISlider *videoSlider;
/** 全屏按钮 */
@property (nonatomic, strong, readonly) UIButton *fullScreenBtn;
/** 锁定屏幕方向按钮 */
@property (nonatomic, strong, readonly) UIButton *lockBtn;
/** 快进快退label */
@property (nonatomic, strong,readonly) UILabel *horizontalLabel;
/** 系统菊花 */
@property (nonatomic, strong, readonly) UIActivityIndicatorView *activity;
/** 重播按钮 */
@property (nonatomic, strong, readonly) UIButton *backBtn;
/** bottomView */
@property (nonatomic, strong, readonly) UIImageView *bottomImageView;
/** topView */
@property (nonatomic, strong, readonly) UIImageView *topImageView;
















/** 重播按钮 */
@property (nonatomic, strong, readonly) UIButton                *repeatBtn;


/** 重置ControlView */
- (void)resestControlView;
/** 切换分辨率时候调用此方法 */
- (void)resetControlViewForResolution;
/** 显示top bottom lockBtn */
- (void)showControlView;
/** 隐藏top bottom lockBtn */
- (void)hideControlView;

@end
