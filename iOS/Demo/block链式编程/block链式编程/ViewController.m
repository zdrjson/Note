//
//  ViewController.m
//  block链式编程
//
//  Created by 张德荣 on 16/6/3.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import "Person.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    Person *p = [Person new];
    Person *p1 = [Person new];
    p.run().sleep();
    
    p.a.b.run();

    
   NSLog(@"%@",[p go:^Person *(Person *p) {
         return p1;
    }]);
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
