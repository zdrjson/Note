//
//  JSProtocolObj.h
//  JSContextTest
//
//  Created by 张德荣 on 16/8/5.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>

@protocol JSExportTexst <NSObject>

- (NSInteger)add:(NSInteger)a b:(NSInteger)b;
@property (nonatomic, assign) NSInteger sum;
@end

@interface JSProtocolObj : NSObject <JSExportTexst>

@end
