package com.tuwei.test;

public class QuickSort2 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,5,6,1,9,2,8,7,4};
        quickSort(0,arr.length-1,arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int left,int right,int[] arr){
        if(left<right){
            int index = partition(left,right,arr);
            quickSort(left,index-1,arr);
            quickSort(index+1,right,arr);
        }
    }

    private static int partition(int left, int right, int[] arr) {
        int num = arr[left];
        while (left<right){
            while (left<right && arr[right]>num){
                right--;
            }
            arr[left] = arr[right];
            while (left<right && num>arr[left]){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = num;
        return left;
    }

}
