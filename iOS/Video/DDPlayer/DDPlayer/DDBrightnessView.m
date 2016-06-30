//
//  DDBrightnessView.m
//  DDPlayer
//
//  Created by 张德荣 on 16/6/24.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "DDBrightnessView.h"
#import "DDPlayer.h"

@interface DDBrightnessView ()
@property (nonatomic, strong) UIImageView *backImage;
@property (nonatomic, strong) UILabel *title;
@property (nonatomic, strong) UIView *longView;
@property (nonatomic, strong) NSMutableArray *tipArray;
@property (nonatomic, assign) BOOL orientationDidChange;
@property (nonatomic, strong) NSTimer *timer;
@end

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
        
        self.title = ({
            UILabel *label = [[UILabel alloc] init];
            label.font = [UIFont boldSystemFontOfSize:16];
            [UIColor colorWithRed:0.25f green:0.22f blue:0.21f alpha:1.00f];
            
            label.textAlignment = NSTextAlignmentCenter;
            label.text = @"高度";
            [self addSubview:label];
            label;
        });
        
        self.longView = ({
            UIView *view = [[UIView alloc] init];
            view.backgroundColor = [UIColor colorWithRed:0.25f green:0.22f blue:0.21f alpha:1.00f];
            [self addSubview:view];
            view;
        });

        [self createTips];

        
    }
    return self;
}
// 创建Tips
- (void)createTips {
    self.tipArray = [NSMutableArray arrayWithCapacity:16];
    
    CGFloat tipW = (self.longView.bounds.size.width - 17) / 16;
    CGFloat tipH = 5;
    CGFloat tipY = 1;
    
    for (int i = 0; i<16; i++) {
        CGFloat tipX = i * (tipW + 1) + 1;
        UIImageView *imageView = [[UIImageView alloc] init];
        imageView.backgroundColor = [UIColor whiteColor];
        imageView.frame = CGRectMake(tipX, tipY, tipW, tipH);
        [self.longView addSubview:imageView];
        [self.tipArray addObject:imageView];
    }
    [self updateLongView:[UIScreen mainScreen].brightness];
}
- (void)updateLongView:(CGFloat)sound
{
    CGFloat stage = 1 /15.0;
    NSInteger level = sound / stage;
    
    
    for (int i = 0; i<self.tipArray.count; i++) {
        UIImageView *img = self.tipArray[i];
        if (i <= level) {
            img.hidden = NO;
        } else {
            img.hidden = YES;
        }
    }
}
- (void)willMoveToSuperview:(UIView *)newSuperview
{
    [self setNeedsLayout];
}
- (void)layoutSubviews {
    [super layoutSubviews];
    
    if (self.orientationDidChange) {
        [UIView animateWithDuration:0.25 animations:^{
            if ([UIDevice currentDevice].orientation == UIDeviceOrientationPortrait || [UIDevice currentDevice].orientation == UIDeviceOrientationFaceUp) {
                self.center = CGPointMake(ScreenWidth * 0.5, (ScreenHeight - 10) * 0.5);
            } else {
                self.center = CGPointMake(ScreenWidth * 0.5, ScreenHeight * 0.5);
            }
        } completion:^(BOOL finished) {
            self.orientationDidChange = NO;
        }];
    } else {
        if ([UIDevice currentDevice].orientation == UIDeviceOrientationPortrait) {
            self.center = CGPointMake(ScreenWidth * 0.5, (ScreenHeight - 10) * 0.5);
        } else {
            self.center = CGPointMake(ScreenWidth * 0.5, ScreenHeight * 0.5);
        }
    }
    self.backImage.center = CGPointMake(155 * 0.5, 155 * 0.5);
}
- (void)dealloc
{
    [[UIScreen mainScreen] removeObserver:self forKeyPath:@"brightness"];
    [[NSNotificationCenter defaultCenter] removeObserver:self];
}
@end
