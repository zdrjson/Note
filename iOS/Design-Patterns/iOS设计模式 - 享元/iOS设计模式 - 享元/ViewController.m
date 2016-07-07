//
//  ViewController.m
//  iOS设计模式 - 享元
//
//  Created by 张德荣 on 16/7/7.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import "CoffeeShop.h"
@interface ViewController ()
@property (nonatomic, strong) CoffeeShop *coffeeShop;
@end
//享元模式使用共享物件，用来尽可能减少内存使用量以及分享资讯给尽可能多的相似物件；它适合用于只是因重复而导致使用无法令人接受的大量内存的大量物件。通常物件中的部分状态是可以分享。常见做法是把它们放在外部数据结构，当需要使用时再将它们传递给享元。
@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    //创建咖啡厅
    self.coffeeShop = [[CoffeeShop alloc] init];
    
    //相同类型的数据公用
    [self.coffeeShop takeOrder:@"Cappuccino" table:1];
    [self.coffeeShop takeOrder:@"Frappe" table:10];
    [self.coffeeShop takeOrder:@"Cappuccino" table:6];
    [self.coffeeShop takeOrder:@"Espresso" table:9];
    [self.coffeeShop takeOrder:@"Cappuccino" table:8];
    
    //开始服务
    [self.coffeeShop serve];
    
   
}

@end
