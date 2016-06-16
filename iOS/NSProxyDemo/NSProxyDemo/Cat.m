//
//  Cat.m
//  NSProxyDemo
//
//  Created by 张德荣 on 16/5/20.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "Cat.h"

@implementation Cat
- (NSString *)name {
    return @"Cat";
}
- (NSString *)type {
    return @"铺路动物";
}
- (void)call {
    NSLog(@"猫在叫...");
}
- (void)run {
    NSLog(@"猫在跑...");
}
@end
