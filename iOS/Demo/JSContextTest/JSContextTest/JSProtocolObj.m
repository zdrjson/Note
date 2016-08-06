//
//  JSProtocolObj.m
//  JSContextTest
//
//  Created by 张德荣 on 16/8/5.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "JSProtocolObj.h"

@implementation JSProtocolObj
@synthesize sum = _sum;
- (NSInteger)add:(NSInteger)a b:(NSInteger)b{
    return a + b;
}
- (void)setSum:(NSInteger)sum {
    NSLog(@"--%@",@(sum));
    _sum = sum;
}
@end
