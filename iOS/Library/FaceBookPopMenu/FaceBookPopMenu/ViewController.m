//
//  ViewController.m
//  FaceBookPopMenu
//
//  Created by 张德荣 on 16/6/23.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import "FBPopMenu.h"
@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];

    [FBPopMenu showTitleArr:@[] selected:^(NSInteger selectIndex) {
        
    }];
}

@end
