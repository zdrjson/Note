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

@end
