package com.tuwei.test;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    //所有线程都到达这个同步点时，屏障才打开，线程继续干活
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, new Runnable() {
            @Override
            public void run() {
                System.out.println("召唤神龙");
            }
        });

        for(int i=0;i<6;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("集齐第"+Thread.currentThread().getName()+"龙珠");
                    try{
                        cyclicBarrier.await();
                    }catch (Exception e){

                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
