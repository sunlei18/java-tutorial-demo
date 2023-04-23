package com.tuwei.review;

/**
 * 机器人走方格
 * 动态规划，或者递归
 */

public class Robot {

    /**
     * 动态规划实现
     * @param x
     * @param y
     * @return
     */
    public int countWays1(int x,int y){
        int[][] dp = new int[x+1][y+1];
        for(int i=1;i<x+1;i++){
            dp[x][i] = 1;
        }
        for(int j=0;j<y+1;j++){
            dp[1][y] = 1;
        }
        for(int i=2;i<x+1;i++){
            for(int j=2;j<y+1;j++){
                dp[x][y] = dp[x][1]+dp[1][y];
            }
        }
        return dp[x][y];
    }

    /**
     * 递归实现，同爬楼梯
     * @param x
     * @param y
     * @return
     */
    public int countWays2(int x,int y){

        if(x==1 || y==1){
            return 1;
        }
        return countWays2(x,y-1) + countWays2(x-1,y);
    }
}
