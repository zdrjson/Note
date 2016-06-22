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
@property (nonatomic, assign) NSInteger animationCount;//动画数量

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
- (void)trigger
{
    if (!triggered) {
        [keyWindow insertSubview:blurView belowSubview:self];
        [UIView animateWithDuration:0.3 animations:^{
            self.frame = self.bounds;
        }];
        
        [self beforeAnimation];
        [UIView animateWithDuration:0.7 delay:0.0f usingSpringWithDamping:0.6f initialSpringVelocity:0.9f options:UIViewAnimationOptionBeginFromCurrentState | UIViewAnimationOptionAllowUserInteraction animations:^{
            helperSideView.center = CGPointMake(keyWindow.center.x, helperSideView.frame.size.height/2);
        } completion:^(BOOL finished) {
            [self finishAnimation];
        }];
        
        [UIView animateWithDuration:0.3 animations:^{
            blurView.alpha = 1.0f;
        }];
        [self beforeAnimation];
        [UIView animateWithDuration:0.7 delay:0.0f usingSpringWithDamping:0.8f initialSpringVelocity:2.0f options:UIViewAnimationOptionBeginFromCurrentState | UIViewAnimationOptionAllowUserInteraction animations:^{
            helperSideView.center = keyWindow.center;
        } completion:^(BOOL finished) {
            if (finished) {
                UITapGestureRecognizer *tapGes = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(tapToUnrigger)];
                [blurView addGestureRecognizer:tapGes];
                [self finishAnimation];
            }
        }];
        [self animateButtions];
        
        triggered = YES;
    } else{
        
    }
}
- (void)animateButtions
{
    for (NSInteger i = 0; i<self.subviews.count; i++) {
        UIView *menuButton = self.subviews[i];
        menuButton.transform = CGAffineTransformMakeTranslation(-90, 0);
        [UIView animateWithDuration:0.7 delay:i*(0.3/self.subviews.count) usingSpringWithDamping:0.6f initialSpringVelocity:0.0f options:UIViewAnimationOptionBeginFromCurrentState | UIViewAnimationOptionAllowUserInteraction animations:^{
            menuButton.transform = CGAffineTransformIdentity;
        } completion:^(BOOL finished) {
            
        }];
    }
}
//动画之前调用
- (void)beforeAnimation
{
    if (self.displayLink == nil) {
        self.displayLink = [CADisplayLink displayLinkWithTarget:self selector:@selector(displayLinkAction:)];
        [self.displayLink addToRunLoop:[NSRunLoop mainRunLoop] forMode:NSDefaultRunLoopMode];
    }
    self.animationCount++;
}
//动画完成之后调用
- (void)finishAnimation
{
    self.animationCount--;
    if (self.animationCount == 0) {
        [self.displayLink invalidate];
        self.displayLink = nil;
    }
}
- (void)displayLinkAction:(CADisplayLink *)dis{
    CALayer *sideHelperPresentationLayer = (CALayer *)[helperSideView.layer presentationLayer];
    CALayer *centerHelperPresentationLayer = (CALayer *)[helperCenterView.layer presentationLayer];
    
    CGRect centerRect = [[centerHelperPresentationLayer valueForKeyPath:@"frame"] CGRectValue];
    CGRect sideRect = [[sideHelperPresentationLayer valueForKeyPath:@"frame"] CGRectValue];
    
    diff = sideRect.origin.x = centerRect.origin.x;
    
    [self setNeedsDisplay];
}
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
    UIBezierPath *path = [UIBezierPath bezierPath];
    [path moveToPoint:CGPointMake(0, 0)];
    [path addLineToPoint:CGPointMake(self.frame.size.width - menuBlankWidth, 0)];
    [path addQuadCurveToPoint:CGPointMake(self.frame.size.width - menuBlankWidth, self.frame.size.height) controlPoint:CGPointMake(keyWindow.frame.size.width/2+diff, keyWindow.frame.size.height/2)];
    [path addLineToPoint:CGPointMake(0, self.frame.size.height)];
    [path closePath];
    
    CGContextRef context = UIGraphicsGetCurrentContext();
    CGContextAddPath(context, path.CGPath);
    [_menuColor set];
    CGContextFillPath(context);
}


@end
