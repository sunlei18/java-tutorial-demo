package com.tuwei.review.listnode;

public class ReverseList {

    public static void main(String[] args) {
        String str1 = "DEBIT";
        String str2 = zeroFormat(2,6);
        System.out.println(str1+str2);
    }

    public static String zeroFormat(Integer num, int len){
        int l=num.toString().length();

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<len-l;i++){
            sb.append("0");
        }
        sb.append(num);//前补
        return sb.toString();
    }
}
