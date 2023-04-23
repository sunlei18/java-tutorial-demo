package com.tuwei.test;

import java.util.*;

public class Testt {

    public static void main(String[] args) {


        int[] nums = new int[]{1,1,2};
        removeDuplicates(nums);
        Character tmp = null;
        String s = "";
        System.out.println();

    }

    public static int lengthOfLongestSubString(String str){

        int max = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){
            int count = i;
            while (count<str.length() && !hm.containsKey(str.charAt(count))){
                hm.put(str.charAt(count++),1);
                max = Math.max(max,count-i);
            }
            hm.clear();
        }
        return max;
    }

    public static int removeDuplicates(int[] nums) {

        int count = 0;
        int res = 0;
        for(int i=0;i<nums.length-1;i++){
            int slow = nums[i];
            count = i;
            int fast = nums[count+1];
            while(fast == slow){
                if(count == nums.length){
                    res = i;
                    break;
                }
                count++;
                fast = nums[count];
            }
            nums[i+1] = fast;
        }
        return res;
    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]),i};
            }
            hm.put(nums[i],i);
        }
        return new int[0];
    }




    public String longestCommonPrefix(String[] strs) {

        String str = "";
        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(strs[j].length()<i && strs[j].charAt(i)!=ch){
                    return str;
                }

            }
            str = str + ch;
        }
        return str;
    }

    public static int lengthOfLongestSubstring2(String s) {

        int max = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int count = i;
            while(count<s.length() && !hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(count++),1);
                max = Math.max(count-i,max);
            }
            hm.clear();
        }
        return max;
    }

    public static String longestPalindrome(String s) {

        int rk = 0;
        int max = 0;
        String res = "";

        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder();
            rk = i;
            while(rk<s.length()){
                sb.append(s.charAt(rk));
                if(isRevserStr(sb.toString())){
                    if(max < rk-i+1){
                        max =  rk-i+1;
                        res = sb.toString();
                    }
                }
                rk++;
            }
        }
        return res;
    }

    public static boolean isRevserStr(String str){
        if(str.length()==0 || str.length()==1){
            return true;
        }
        String str1 = str.substring(0,str.length()/2);
        StringBuilder sb = new StringBuilder();

        for(int i=str.length()-1;i>(str.length()-1)/2;i--){
            sb.append(str.charAt(i));
        }
        if(sb.toString().equals(str1)){
            return true;
        }
        return false;
    }

    public int lengthOfLongestSubstring(String s) {

        int length = s.length();
        int rk = -1;
        int max = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<length;i++){
            while(rk<length && !hm.containsKey(s.charAt(rk))){
                hm.put(s.charAt(rk),rk);
                rk++;
                max = Math.max(max,rk-i+1);
            }
        }
        return max;
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     * @return
     */
    public static int findSubStr(String str){

        int length = str.length();
        int rk = 0;
        int max = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<length;i++){
            rk = i;
            while(rk<length && !hm.containsKey(str.charAt(rk))){
                hm.put(str.charAt(rk),rk);
                max = Math.max(max,rk-i+1);
                rk++;
            }
            hm.clear();
        }
        return max;
    }

    public static boolean isCf(String str){
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                return false;
            }else{
                hm.put(str.charAt(i),1);
            }
        }
        return true;
    }

}
