package org.peng.algorithm.java.AlgorPlayGround.sorting;

public class InsertionSort {
	public static void insertionSort(int[] array) {
		int i,j,temp;
		for(i=1;i<array.length;i++) {
			j = i-1;
			temp = array[i];
			for(;j>=0 && array[j]>=temp;j--) 
				array[j+1] = array[j];
			array[j+1] = temp;
		}
	}
	
	public static void bubbleSort(int[] array) {
		int i,j,temp;
		for(i=0;i<array.length-1;i++)
			for(j=0;j<array.length-i-1;j++) {
				if(array[j+1] < array[j]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
	}
	
	
	public static void sortArray100(){
		int[] array = new int[100];
		for(int i=0;i<array.length;i++) {
			array[i] = (int)(Math.random()*1000);
		}
		
		bubbleSort(array);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+"  ");
		}
	
	}
	
	public static void main(String args[]) {
		sortArray100();
	}
}
