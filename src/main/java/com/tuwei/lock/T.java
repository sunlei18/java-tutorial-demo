package com.tuwei.lock;

import java.util.ArrayList;

public class T {

    public static void main(String[] args) {
        System.out.println(isPermutation("acb","abc"));
    }

    public static boolean isPermutation(String str1,String str2){
        ArrayList<String> arr = getFullPermutation(str2);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).equals(str1)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getFullPermutation(String s) {
        if (null == s || "".equals(s)){
            return null;
        }
        ArrayList<String> array = null;
        if (s.length() == 1){
            array = new ArrayList<String>();
            array.add(s);
        } else {
            //递归调用
            array = getFullPermutation(s.substring(1), s.charAt(0));
        }
        return array;
    }

    public static ArrayList<String> getFullPermutation(String s, char c) {
        ArrayList<String> reArray = new ArrayList<String>();
        ArrayList<String> array = getFullPermutation(s);
        for (String str : array){
            reArray.addAll(getStr(str, c));
        }
        array = null;
        return reArray;
    }

    public static ArrayList<String> getStr(String s, char c) {
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i <= s.length(); i++) {
            array.add(new StringBuffer().append(s.substring(0, i)).append(c).append(s.substring(i)).toString());
        }
        return array;
    }

}
