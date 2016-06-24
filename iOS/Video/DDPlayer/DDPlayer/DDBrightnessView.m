//
//  DDBrightnessView.m
//  DDPlayer
//
//  Created by 张德荣 on 16/6/24.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "DDBrightnessView.h"

@implementation DDBrightnessView

+ (instancetype)sharedInstance
{
    static DDBrightnessView* instance = nil;

    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        instance = [DDBrightnessView new];
       
    });

    return instance;
}

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/

@end
