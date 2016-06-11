//
//  ViewController.m
//  Algorithm
//
//  Created by 张德荣 on 16/6/11.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    int array[] = {0, 1, 3, 4, 5, 6, 7, 8, 9, 10};
    int count = sizeof(array) / sizeof(array[0]);
    int target = 5;
    int start = 0, end = count - 1, mid =0;
    while (start <= end) {
        mid = (start + end) /2;
        if (array[mid] > target) {
            end = mid -1;
        } else if (array[mid] < target) {
            start = mid +1;
        } else {
            break;
        }
    }
    if (start <= end) {
        printf("[%d]: %d\n", mid, array[mid]);
    } else {
        printf("not found\n");
    }
   NSLog(@"%d",binarySearch1(array, 0, 9, 5));
}
//递归方法
int binarySearch1(int a[] , int low , int high , int findNum)
{
    int mid = ( low + high ) / 2;
    if (low > high)
        return -1;
    else
    {
        if (a[mid] > findNum)
            return binarySearch1(a, low, mid - 1, findNum);
        else if (a[mid] < findNum)
            return binarySearch1(a, mid + 1, high, findNum);
        else
            return mid;
    }
}
//非递归方法
int binarySearch2(int a[], int low, int high, int findNum) {
    while (low <= high) {
        int mid = (low + high) / 2; //此处一定要放在while里面
        if (a[mid] < findNum) {
            low = mid + 1;
        } else if (a[mid] > findNum){
            high = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}
@end
