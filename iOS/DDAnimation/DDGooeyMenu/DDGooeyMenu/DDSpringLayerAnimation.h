//
//  DDSpringLayerAnimation.h
//  DDGooeyMenu
//
//  Created by 张德荣 on 16/6/21.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DDSpringLayerAnimation : NSObject

+ (instancetype)sharedInstance;
// Normal Anim -- 线性函数
- (CAKeyframeAnimation *)createBasicAnima:(NSString *)keypath duration:(CFTimeInterval)duration fromValue:(id)fromValue toValue:(id)toValue;
//Spring Anim -- 弹性函数
- (CAKeyframeAnimation *)createSpringAnim:(NSString *)keypath duration:(CFTimeInterval)duration usingSpringWithDamping:(CGFloat)damping initialSpringVelocity:(CGFloat)velocity fromValue:(id)fromValue
                                  toValue:(id)toValue;
//Curve Anim -- 二次平滑抛物线
- (CAKeyframeAnimation *)createCurveAnima:(NSString *)keypath duration:(CFTimeInterval)duration fromValue:(id)fromValue toValue:(id)toValue;

//Curve Anim -- 抛到一半的二次平滑抛物函数
- (CAKeyframeAnimation *)createHalfCurAnima:(NSString *)keypath duration:(CFTimeInterval)duration fromValue:(id)fromValue toValue:(id)toValue;

@end
