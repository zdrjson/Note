//
//  GooeySlideMenu.m
//  GooeySlideMenuDemo
//
//  Created by 张德荣 on 16/6/22.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "GooeySlideMenu.h"

#define buttonSpace 30
#define menuBlankWidth 50

@interface GooeySlideMenu ()
{
    UIVisualEffectView *blurView;
    UIView *helperSideView;
    UIView *helperCenterView;
    UIWindow *keyWindow;
    BOOL triggered;
    CGFloat diff;
    UIColor *_menuColor;
    CGFloat menuButtonHeight;
}
@property (nonatomic, strong) CADisplayLink *displayLink;
@property (nonatomic, assign) NSInteger amimationCount;//动画数量

@end

@implementation GooeySlideMenu
- (instancetype)initWithTitles:(NSArray *)titles
{
    return [self initWithTitles:titles buttonHeight:40.0f MenuColor:[UIColor colorWithRed:0 green:0.722 blue:1 alpha:1] withBackBlurStyle:UIBlurEffectStyleDark];
}
- (instancetype)initWithTitles:(NSArray *)titles buttonHeight:(CGFloat)height MenuColor:(UIColor *)menuColor withBackBlurStyle:(UIBlurEffectStyle)style
{
    self = [super init];
    if (self) {
        keyWindow = [UIApplication sharedApplication].keyWindow;
        
        blurView = [[UIVisualEffectView alloc] initWithEffect:[UIBlurEffect effectWithStyle:style]];
        blurView.frame = keyWindow.frame;
        blurView.alpha = 0.0f;
        
        helperSideView = [[UIView alloc] initWithFrame:CGRectMake(-40, 0, 40, 40)];
        helperSideView.backgroundColor = [UIColor redColor];
        helperSideView.hidden = YES;
        [keyWindow addSubview:helperSideView];
        
        helperCenterView = [[UIView alloc] initWithFrame:CGRectMake(-40, CGRectGetHeight(keyWindow.frame)/ 2- 20, 40, 40)];
        helperCenterView.backgroundColor = [UIColor yellowColor];
        helperCenterView.hidden = YES;
        [keyWindow addSubview:helperCenterView];
        
        self.frame = CGRectMake(-keyWindow.frame.size.width/2 -menuBlankWidth, 0, keyWindow.frame.size.width/2 + menuBlankWidth, keyWindow.frame.size.height);
        self.backgroundColor = [UIColor clearColor];
        [keyWindow insertSubview:self belowSubview:helperCenterView];
        
        
        _menuColor = menuColor;
        menuButtonHeight = height;
        [self addButtons:titles];
        
    }
    return self;
}
- (void)addButtons:(NSArray *)titles
{
    
}


// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
    
}


@end
