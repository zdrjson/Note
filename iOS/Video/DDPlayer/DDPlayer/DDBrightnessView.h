//
//  DDBrightnessView.h
//  DDPlayer
//
//  Created by 张德荣 on 16/6/24.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DDBrightnessView : UIView
/** 调用单例记录播放状态是否锁定屏幕方向 */
@property (nonatomic, assign) BOOL isLockScreen;
/** cell上添加player时候，不允许横屏，只运行竖屏状态 */
@property (nonatomic, assign) BOOL isAllowLandscape;
+ (instancetype)sharedInstance;

@end
