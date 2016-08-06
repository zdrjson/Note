//
//  ViewController.m
//  JSContextTest
//
//  Created by 张德荣 on 16/7/27.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import <JavaScriptCore/JavaScriptCore.h>
#import "JSProtocolObj.h"
@interface ViewController () <JSExportTexst>
@property (nonatomic, strong) JSProtocolObj *obj;
@property (nonatomic, strong) JSContext *context;


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
    
    
    NSString *js = @"function add(a,b) {return a+b}";
    [context evaluateScript:js];
    
    
    JSValue *n = [context[@"add"] callWithArguments:@[@2, @3]];
    
    NSLog(@"---%@",@([n toInt32]));
    
    context[@"add"] = ^(NSInteger a, NSInteger b) {
        NSLog(@"---%@",@(a + b));
    };
    
    [context evaluateScript:@"add(2,3)"];
    
}

- (void)testJSExport {
    JSContext *context = [[JSContext alloc] init];
    context.exceptionHandler = ^(JSContext *context, JSValue *exception) {
        [JSContext currentContext].exception = exception;
        NSLog(@"exception:%@",exception);
    };
    //将obj添加到context中
//    context[@"OCObj"] = se
    
}

@end
