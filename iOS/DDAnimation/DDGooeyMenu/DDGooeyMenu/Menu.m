//
//  Menu.m
//  DDGooeyMenu
//
//  Created by 张德荣 on 16/6/13.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "Menu.h"
#import "DDSpringLayerAnimation.h"

@interface Menu ()
@property (nonatomic, strong) NSMutableArray *animationQueue;

@end

@implementation Menu
- (instancetype)initWithFrame:(CGRect)frame
{
    CGRect real_frame = CGRectInset(frame, -30, -30);
    self = [super initWithFrame:real_frame];
    if (self) {
//        self.backgroundColor = [UIColor redColor];
        _animationQueue = [NSMutableArray arrayWithCapacity:3];
    }
    return self;
}
- (void)willMoveToSuperview:(UIView *)newSuperview {
    _menuLayer = [MenuLayer layer];
    _menuLayer.frame = self.bounds;
    _menuLayer.contentsScale = [UIScreen mainScreen].scale;
    [self.layer addSublayer:_menuLayer];
    [_menuLayer setNeedsDisplay];
}
- (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event {
    UITouch *touch = [touches anyObject];
    switch (touch.tapCount) {
        case 1:
            [self openAnimation];
            break;
            
        default:
            break;
    }
}
- (void)openAnimation
{
    CAKeyframeAnimation *openAnimation_1 = [[DDSpringLayerAnimation sharedInstance] createBasicAnima:@"xAxisPercent" duration:0.3 fromValue:@(0) toValue:@(1)];
    openAnimation_1.delegate = self;
    
    CAKeyframeAnimation *openAnimation_2 = [[DDSpringLayerAnimation sharedInstance] createBasicAnima:@"xAxisPercent" duration:0.3 fromValue:@(0) toValue:@(1)];
    openAnimation_2.delegate = self;
    
    CAKeyframeAnimation *openAnimation_3 = [[DDSpringLayerAnimation sharedInstance] createSpringAnim:@"xAxisPercent" duration:1.0 usingSpringWithDamping:0.5 initialSpringVelocity:3.0 fromValue:@(0) toValue:@(1)];
    
    openAnimation_3.delegate = self;
    
    [_animationQueue addObject:openAnimation_1];
    [_animationQueue addObject:openAnimation_2];
    [_animationQueue addObject:openAnimation_3];
    
    [self.menuLayer addAnimation:openAnimation_1 forKey:@"openAnimation_1"];
    self.userInteractionEnabled = NO;
//    _menuLayer
    
}
@end
