//
//  DDWeakProxy.h
//  NSProxyDemo
//
//  Created by 张德荣 on 16/5/19.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import <Foundation/Foundation.h>
NS_ASSUME_NONNULL_BEGIN
/**
 A proxy used to hold a weak object.
 It can be used to avoid retain cycles. such as the target in NSTimer or CADisplayLink.
 */
@interface DDWeakProxy : NSProxy
/**
 The proxy taget.
 */
@property (nullable, nonatomic, weak, readonly) id target;
/**
 Creates a new weak proxy for target.
 
 @param target Target object.
 
 @return A new proxy objec.
 */
- (instancetype)initWithTarget:(id)target;
/**
 Create a new weak proxy for target.
 
 @param target Target object.
 
 @return A new proxy object.
 */
+ (instancetype)proxyWithTarget:(id)target;
@end
NS_ASSUME_NONNULL_END