package com.tuwei.bio;

import java.util.HashMap;

public class Ten {

    public static void main(String[] args) {

        int[] arr = new int[]{4,5,9,6,2,7,3,8};

        int[] res = smallestK(arr,4);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }

    public HashMap<Character,Character> getStringMap(String str){
        HashMap<Character,Character> hm = new HashMap<>();
        String[] strArr = str.split("&");
        for(int i=0;i<strArr.length;i++){
            if(!strArr[i].contains("=")){
                continue;
            }
            hm.put(strArr[i].charAt(0),strArr[i].charAt(2));
        }
        return hm;
    }

    public static int[] smallestK(int[] arr,int k){
        if(k>arr.length){
            return null;
        }
        quickSort(arr,0,arr.length-1,k);
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = arr[i];
        }
        return res;
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

    private static void quickSort(int[] arr,int low, int high,int k){
        if(low<high){
            int index = partion(arr,low,high);

            if(k < index-low+1){
                quickSort(arr,low,index-1,k);
            }else if(k > index-low+1){
                quickSort(arr,index+1,high,k);
            }else{
                return;
            }
        }
    }
}
