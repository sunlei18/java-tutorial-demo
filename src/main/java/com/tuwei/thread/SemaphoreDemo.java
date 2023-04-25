package com.tuwei.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3,false);

        for(int i=0;i<6;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println("第"+Thread.currentThread().getName()+"个获取资源");
                        TimeUnit.SECONDS.sleep(3);
                        System.out.println("第"+Thread.currentThread().getName()+"个释放");
                    }catch (Exception e){

                    }finally {
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
