//
//  ViewController.m
//  iOS设计模式 - 模板
//
//  Created by 张德荣 on 16/8/9.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"
#import "Monopoly.h"
#import "Chess.h"
#import "GameProtocol.h"
@interface ViewController ()

@end
//定义一个操作中的算法的骨架，而将步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义算法的某些特定步骤。
@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
    // chess game
    id <GameProtocol> chess = [[Chess alloc] init];
    chess.playerCount       = 2;
    [chess initializeGame];
    [chess makePlay];
    [chess endOfGame];
    
    
    // monopoly game
    id <GameProtocol> monopoly = [[Monopoly alloc] init];
    monopoly.playerCount       = 4;
    [monopoly initializeGame];
    [monopoly makePlay];
    [monopoly endOfGame];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
