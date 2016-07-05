//
//  DDPlayerControlView.m
//  DDPlayer
//
//  Created by 张德荣 on 16/5/31.
//  Copyright © 2016年 JsonZhang. All rights reserved.
//

#import "DDPlayerControlView.h"
#import "DDPlayer.h"
@interface DDPlayerControlView ()
@property (nonatomic, strong) UIButton *startBtn;
@property (nonatomic, strong) UILabel *currentTimeLabel;
@property (nonatomic, strong) UILabel *totalTimeLabel;
@property (nonatomic, strong) UIProgressView *progresssView;
@property (nonatomic, strong) UISlider *videoSlider;
@property (nonatomic, strong) UIButton *fullScreenBtn;
@property (nonatomic, strong) UIButton *lockBtn;
@property (nonatomic, strong) UILabel *horizontalLabel;
@property (nonatomic, strong) UIActivityIndicatorView *activity;
@property (nonatomic, strong) UIButton *backBtn;
@property (nonatomic, strong) UIButton *repeatBtn;
@property (nonatomic, strong) UIImageView  *bottomImageView;
@property (nonatomic, strong) UIImageView *topImageView;
@property (nonatomic, strong) UIButton *downloadBtn;
@property (nonatomic, strong) UIButton *resolutionBtn;
@property (nonatomic, strong) UIView *resolutionView;
@property (nonatomic, strong) UIButton *playeBtn;






@end

@implementation DDPlayerControlView
- (instancetype)init
{
    self = [super init];
    if (self) {
        [self addSubview:self.topImageView];
        self 
    }
    return self;
}
@end
