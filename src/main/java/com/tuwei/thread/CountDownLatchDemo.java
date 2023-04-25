package com.tuwei.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    //6个学生都离开教室了，班长才能锁门
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        try{
            for(int i=0;i<6;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("第"+Thread.currentThread().getName()+"个学生离开教室");
                        countDownLatch.countDown();
                    }
                },String.valueOf(i)).start();
            }
            countDownLatch.await();
            System.out.println("班长锁门走出教室");
        }catch (Exception e){

        }
    }

}
