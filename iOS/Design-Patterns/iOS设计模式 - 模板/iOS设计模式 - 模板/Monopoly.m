//
//  Monopoly.m
//  iOS设计模式 - 模板
//
//  Created by 张德荣 on 16/8/9.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "Monopoly.h"

@interface Monopoly ()
@property (nonatomic, assign) int gamePlayerCount;
@end

@implementation Monopoly
- (void)makePlay {
    NSLog(@"Monopoly makePlaye");
}
- (int)playerCount {
    return self.gamePlayerCount;
}
- (void)initializeGame {
    NSLog(@"Monopoly initialize");
}
- (void)setPlayCount:(int)count {
    self.gamePlayerCount = count;
}
- (void)endOfGame {
    NSLog(@"Monopoly endOfGame");
}

- (void)setPlayerCount:(int)count {
	
}






@end
