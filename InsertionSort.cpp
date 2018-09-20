//
//  main.cpp
//  AlgorithmSandbox
//
//  Created by Peng Sun on 2017/9/17.
//  Copyright © 2017年 Peng Sun. All rights reserved.
//

#include <iostream>

// Insertion sort
void insertSort(int* arr, int len){
    int i, j,temp;
    for (int i=1;i<len;i++){
        j = i-1;
        temp = arr[i];
        for(;j>=0 && arr[j]< temp;j--)
            arr[j+1] = arr[j];
        arr[j+1] = temp;
    }
}

void runInsertSort(){
    int input[8] = {4,1,6,12,45,3,10,-2};
    int len = 8;
    insertSort(input,len);
    insertSort(input,len);
    for(int i=0;i<len;i++)
        printf("%d  ",input[i]);
}
