//
//  BubbleSort.cpp
//  AlgorithmSandbox
//
//  Created by Peng Sun on 2017/9/21.
//  Copyright © 2017年 Peng Sun. All rights reserved.
//



void bubbleSort(int* arr, int len){
    int i,j,temp;
    for(i=0;i<len-1;i++){
        for(j=0;j<len-1-i;j++){
            if(arr[j+1]>arr[j]){
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

void runBubbleSort(){
    
    int arr[10] = {2,-4,6,34,8,9,77,-53,1,-7};
    int len = 10;
    bubbleSort(arr, len);
    
    for(int i=0;i<len;i++)
        printf("%d ",arr[i]);

}
