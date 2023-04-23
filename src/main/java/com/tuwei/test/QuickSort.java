package com.tuwei.test;

/**
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,6,1,9,2,8,7,4};
        quickSort(arr,0,8);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static int partion(int[] arr,int low,int high){
        int num = arr[low];
        while (low < high){
            while (low < high && arr[high] > num){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < num){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = num;
        return low;
    }

    private static void quickSort(int[] arr,int low, int high){
        if(low<high){
            int index = partion(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }
}
