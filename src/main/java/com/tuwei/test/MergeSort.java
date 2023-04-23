package com.tuwei.test;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,6,1,9,2,8,7,4};
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            sort(arr,left,mid,right);
        }
    }

    public static void sort(int[] arr,int left,int mid,int right){
        int[] tmp = new int[arr.length];
        int i = left;
        int j = mid+1;
        int index = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                tmp[index++] = arr[i++];
            }else{
                tmp[index++] = arr[j++];
            }
        }
        //将左边剩余元素填进tmp
        while (i<=mid){
            tmp[index++] = arr[i++];
        }
        //将右边剩余元素填进tmp
        while (j<=right){
            tmp[index++] = arr[j++];
        }
        //将tmp数组的元素全部拷贝进arr数组
        index = 0;
        while (left<=right){
            arr[left++] = tmp[index++];
        }
    }
}
