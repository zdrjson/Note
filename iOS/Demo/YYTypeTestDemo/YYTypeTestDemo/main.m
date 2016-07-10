//
//  main.m
//  YYTypeTestDemo
//
//  Created by 张德荣 on 16/7/10.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>
typedef NS_ENUM(NSInteger, Test) {
    TestIvarMask                = 0xFF,//获取1到8位数值的掩码
    TestIvar1                   = 1,
    TestIvar2                   = 2,
    
    TestMethodMask              = 0xFF00,//获取9到17位数值的掩码
    TestMethod1                 = 1 << 8,//左移8位
    TestMethod2                 = 2 << 8,//左移8位
    TestMethod3                 = 3 << 8,//左移8位
    
    TestPropertyMask            = 0xFF0000,//获取18到24位数值的掩码
    TestProperty1               = 1 << 16,
    TestProperty2               = 2 << 16,
    TestProperty3               = 3 << 16,
};


typedef NS_OPTIONS(NSUInteger,iKYEncodingType){
    iKYEncodingTypeMask = 0xFF,
    iKYEncodingType1 = 1,
    iKYEncodingType2 = 2,
    iKYEncodingType3 = 3,
    
    iKYEncodingTypeQualifireMask = 0xFF00,
    iKYEncodingTypeQualifire1 = 1 << 8,
    iKYEncodingTypeQualifire2 = 1 << 9,
    iKYEncodingTypeQualifire3 = 1 << 10,
};
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        NSLog(@"TestIvarMask = %ld", TestIvarMask);
        NSLog(@"TestMethodMask = %ld", TestMethodMask);
        NSLog(@"TestPropertyMask = %ld", TestPropertyMask);
        
        NSLog(@"Ivar1 = %ld", TestIvar1);
        NSLog(@"Ivar2 = %ld", TestIvar2);
        
        NSLog(@"Method1 = %ld", TestMethod1);
        NSLog(@"Method2 = %ld", TestMethod2);
        NSLog(@"Method3 = %ld", TestMethod3);
        
        NSLog(@"Property1 = %ld", TestProperty1);
        NSLog(@"Property2 = %ld", TestProperty2);
        NSLog(@"Property3 = %ld", TestProperty3);
        
        Test type = TestIvar1;
        NSLog(@"type = %ld", type);
        
        type |= TestIvar2;
        NSLog(@"type = %ld", type);
        
        type |= TestMethod1;
        NSLog(@"type = %ld", type);
        
        NSLog(@"获取低8位: %ld", type & TestIvarMask);
        
        type |= TestProperty1;
        NSLog(@"获取低8位: %ld", type & TestIvarMask);
        NSLog(@"获取低16位: %ld", type & TestMethodMask);
        NSLog(@"type = %ld", type);
        
        NSLog(@"获取低24位: %ld", type & TestPropertyMask);
        
        
        NSLog(@"--------------------直接可以通过枚举值&对应的mask找到它对应的部分是哪个值,YYModel用了不同的Mask来取得不同的type的值------------------------------------------------------");
        
        
        NSLog(@"iKYEncodingType1 %d iKYEncodingTypeQualifire2 %d",(int)iKYEncodingType1,(int)iKYEncodingTypeQualifire2);
        iKYEncodingType test = (iKYEncodingType1|iKYEncodingTypeQualifire2);
        NSLog(@"%d",(int) test);
        NSLog(@"iKYEncodingTypeMask %d, iKYEncodingTypeQualifireMask %d",(int)(test&iKYEncodingTypeMask), (int)(test&iKYEncodingTypeQualifireMask));
        
    }
    return 0;
}
