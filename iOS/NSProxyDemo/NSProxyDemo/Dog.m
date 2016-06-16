//
//  Dog.m
//  NSProxyDemo
//
//  Created by 张德荣 on 16/5/20.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "Dog.h"

@implementation Dog
- (NSString *)name {
    return @"Dog";
}
- (NSString *)type {
    return @"哺乳动物";
}
- (void)call {
    NSLog(@"狗在叫。。。");
}
- (void)run {
    NSLog(@"狗在跑...");
}
@end
