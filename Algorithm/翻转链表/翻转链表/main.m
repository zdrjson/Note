//
//  main.m
//  翻转链表
//
//  Created by 张德荣 on 16/6/21.
//  Copyright © 2016年 zdrjson. All rights reserved.
//

#import <Foundation/Foundation.h>

#include <stdio.h>
#include <stdlib.h>

typedef struct data {
    
    int data;
    struct data *nextPoint;
}CustomData;

typedef struct data1 {
    int data;
    struct data *nextPoint;
}CustomData1;

CustomData* createLink(int a[10], int n) {
    
    CustomData *head = NULL;
    CustomData *p = NULL;
    for (int i = 0; i < n; i++) {
        CustomData *temp= (CustomData *)malloc(sizeof(CustomData));
        temp -> data = a[i];
        temp->nextPoint = NULL;
        if (head == NULL) {
            head = temp;
            p = head;
        } else {
            p ->nextPoint = temp;
            p = temp;
        }
    }
    return head;
}

CustomData * reverseLink(CustomData *link) {
    
    CustomData *tempHead = link;
    CustomData *next = NULL;
    CustomData *pre = NULL;
    while (tempHead) {
        if (tempHead == link) {
            next = tempHead->nextPoint;
            tempHead ->nextPoint = NULL;
            pre = tempHead;
        } else {
            next = tempHead->nextPoint;
            tempHead -> nextPoint = pre;
            pre = tempHead;
        }
        tempHead = next;
        if (tempHead != NULL) {
            printf("%d\n",tempHead ->data);
        }
        
    }
    return pre;
}


CustomData * reverseLink1(CustomData *link) {
    CustomData *tempHead = link;
    CustomData *next = NULL;
    CustomData *pre = NULL;
    while (tempHead) {
        if (tempHead == link) {
            next = tempHead->nextPoint;
            tempHead->nextPoint = NULL;
            pre = tempHead;
        } else {
            next = tempHead->nextPoint;
            tempHead->nextPoint = pre;
            pre = tempHead;
        }
        tempHead = next;
    }
    return pre;
}


int main(int argc, const char * argv[]) {
    // insert code here...
    
    int a [10] = {1,2,3,4,5,6,7,8,9,10};
    CustomData *head = createLink(a, 10);
    head =  reverseLink(head);
    
    while (head) {
        printf("%d", head->data);
        head = head->nextPoint;
    }
    
    
    return 0;
}
