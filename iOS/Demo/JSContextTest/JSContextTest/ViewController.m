//
//  ViewController.m
//  JSContextTest
//
//  Created by 张德荣 on 16/7/27.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import <JavaScriptCore/JavaScriptCore.h>
@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    JSContext *context = [[JSContext alloc] init];
    context[@"hello"] = ^(NSString *msg){
        NSLog(@"hello %@",msg);
    };
    [context evaluateScript:@"hello('word')"];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
