//
//  DDPlayerControlView.h
//  DDPlayer
//
//  Created by 张德荣 on 16/5/31.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DDPlayerControlView : UIView
/** 当前播放时长lable */
@property (nonatomic, strong) UILabel *currentTimeLabel;
/** 视频总时长label */
@property (nonatomic, strong) UILabel *totalTimeLabel;


/** 重播按钮 */
@property (nonatomic, strong, readonly) UIButton                *repeatBtn;
/** 滑杆 */
@property (nonatomic, strong, readonly) UISlider *videoSlider;
/** 全屏按钮 */
@property (nonatomic, strong) UIButton *fullScreenBtn;

/** 重置ControlView */
- (void)resestControlView;
/** 切换分辨率时候调用此方法 */
- (void)resetControlViewForResolution;
/** 显示top bottom lockBtn */
- (void)showControlView;
/** 隐藏top bottom lockBtn */
- (void)hideControlView;

@end
