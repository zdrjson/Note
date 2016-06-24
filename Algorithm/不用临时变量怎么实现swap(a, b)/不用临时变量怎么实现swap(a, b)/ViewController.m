//
//  ViewController.m
//  不用临时变量怎么实现swap(a, b)
//
//  Created by 张德荣 on 16/6/24.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    [self method1];
    
    [self method2];
    
}
- (void)method2
{
    NSInteger a = 19;
    NSInteger b = 99;
    
    //计算a,b两者之间的距离并保存到a
    a = labs(a - b);
    NSLog(@"%ldxxx",a);
    //a 、b两者之间的距离再减去b就是最初a的值，此时就交换给了b
    b = labs(b - a);
    //当前的a就是最初a b之间的距离,再加上b(也就是原来的a的值)，就是b的值
    //将赋值给a就完成了a与b的交换
    a = a + b;
    
    //这种方式也不需要借助临时变量，但是这种方式有很大的局限性，比如 a、b本是不溢出的，但是a+b后可能会溢出。
    NSLog(@"a = %ld, b = %ld", a, b);
    
    
}
- (void)method1 {
    NSInteger a = 19;
    NSInteger b = 99;
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    
    NSLog(@"a = %ld b = %ld",a,b);
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
