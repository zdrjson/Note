//
//  DDSpringLayerAnimation.m
//  DDGooeyMenu
//
//  Created by 张德荣 on 16/6/21.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "DDSpringLayerAnimation.h"

@implementation DDSpringLayerAnimation

+ (instancetype)sharedInstance
{
    static DDSpringLayerAnimation* instance = nil;

    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        instance = [DDSpringLayerAnimation new];
    });

    return instance;
}
#pragma mark -- Main Class Methodss
- (CAKeyframeAnimation *)createBasicAnima:(NSString *)keypath duration:(CFTimeInterval)duration fromValue:(id)fromValue toValue:(id)toValue {
    CAKeyframeAnimation *anim = [CAKeyframeAnimation animationWithKeyPath:keypath];
    anim.values = [self basicAnimationValues:fromValue toValue:toValue duration:duration];
    anim.duration = duration;
    anim.fillMode = kCAFillModeForwards;
    anim.removedOnCompletion = NO;
    return anim;
}
- (CAKeyframeAnimation *)createSpringAnim:(NSString *)keypath duration:(CFTimeInterval)duration usingSpringWithDamping:(CGFloat)damping initialSpringVelocity:(CGFloat)velocity fromValue:(id)fromValue toValue:(id)toValue
{
    CGFloat dampingFactor = 10.0;
    CGFloat velocityFactor = 10.0;
    NSMutableArray *values = [self springAnimationValues:fromValue toValue:toValue usingSpringWithDamping:damping *dampingFactor initialSpringVelocity:velocity * velocityFactor duration:duration];
    CAKeyframeAnimation *anim = [CAKeyframeAnimation animationWithKeyPath:keypath];
    anim.values = values;
    anim.duration = duration;
    anim.fillMode = kCAFillModeForwards;
    anim.removedOnCompletion = NO;
    
    return anim;
}
#pragma mark -- Helper Methods
- (NSMutableArray *)basicAnimationValues:(id)fromValue toValue:(id)toValue duration:(CGFloat)duration
{
    NSInteger numOfFrames = duration * 60;
    NSMutableArray *values = [NSMutableArray arrayWithCapacity:numOfFrames];
    for (NSInteger i = 0; i<numOfFrames; i++) {
        [values addObject:@(0.0)];
    }
    
    CGFloat diff = [toValue floatValue] - [fromValue floatValue];
    for (NSInteger frame = 0; frame<numOfFrames; frame++) {
        CGFloat x = (CGFloat)frame / (CGFloat)numOfFrames;
        CGFloat value = [fromValue floatValue] + diff * x;
        values[frame] = @(value);
    }
    return values;
}
- (NSMutableArray *)springAnimationValues:(id)fromValue toValue:(id)toValue usingSpringWithDamping:(CGFloat)
damping initialSpringVelocity:(CGFloat)velocity duration:(CGFloat)duration {
    //60个关键帧
    NSInteger numOfFrames = duration * 60;
    NSMutableArray *values = [NSMutableArray arrayWithCapacity:numOfFrames];
    for (NSInteger i = 0; i<numOfFrames; i++) {
        [values addObject:@(0.0)];
    }
    
    //差值
    CGFloat diff = [toValue floatValue] - [fromValue floatValue];
    for (NSInteger frame = 0; frame<numOfFrames; frame++) {
        CGFloat x = (CGFloat)frame / (CGFloat)numOfFrames;
        CGFloat value = [toValue floatValue] - diff *(pow(M_E, -damping * x) * cos(velocity *x));
        values[frame] = @(value);
    }
    return values;
}
@end
