//
//  DDBrightnessView.m
//  DDPlayer
//
//  Created by 张德荣 on 16/6/24.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "DDBrightnessView.h"
#import "DDPlayer.h"
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

- (instancetype)init
{
    self = [super init];
    if (self) {
        self.frame = CGRectMake(ScreenWidth * 0.5, ScreenHeight * 0.5, 155, 155);
        
        self.layer.cornerRadius = 10;
        self.layer.masksToBounds = YES;
        
        
        UIToolbar *toolbar = [[UIToolbar alloc] initWithFrame:self.bounds];
        toolbar.alpha = 0.97;
        [self addSubview:toolbar];
        
        
        
    }
    return self;
}

@end
