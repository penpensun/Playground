package org.peng.algorithmplaygroundjava;



/**
 * This class
 * @author penpen926
 *
 */
public class InsertSort {
	static int inputArray[] = {6,12,44,50,120};
	public static void insertSort(int inputArray[]){
		int i,j,temp;
		for(i=1;i<inputArray.length;i++){
			j = i-1;
			temp = inputArray[j+1];
			for(;j>=0 && inputArray[j]>= temp;j--){
				inputArray[j+1] = inputArray[j];
			}
			
			inputArray[j+1] = temp;
		}
		
		for(i=0;i<inputArray.length;i++){
			System.out.print(inputArray[i]+"  ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		insertSort(inputArray);
	}
}

