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
        [self addSubview:self.bottomImageView];
        
        [self.bottomImageView addSubview:self.startBtn];
        [self.bottomImageView addSubview:self.currentTimeLabel];
        [self.bottomImageView addSubview:self.progressView];
        [self.bottomImageView addSubview:self.videoSlider];
        [self.bottomImageView addSubview:self.fullScreenBtn];
        [self.bottomImageView addSubview:self.totalTimeLabel];
        
        [self.topImageView addSubview:self.downloadBtn];
        [self addSubview:self.lockBtn];
        [self addSubview:self.backBtn];
        [self addSubview:self.activity];
        [self addSubview:self.repeatBtn];
        [self addSubview:self.horizontalLabel];
        [self addSubview:self.playeBtn];
        
        [self.topImageView addSubview:self.resolutionBtn];
        
        //添加子控件的约束
        [self makeSubViewsConstraints];
        // 分辨率btn点击
        [self.resolutionBtn addTarget:self action:@selector(resolutionAction:) forControlEvents:UIControlEventTouchUpInside];
        UITapGestureRecognizer *sliderTap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(tapSliderAction:)];
        [self.videoSlider addGestureRecognizer:sliderTap];
        
        
    }
    return self;
}

- (void)makeSubViewsConstraints {
	
}
@end












