package com.tuwei.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印
 */
public class ThreadTest {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile Integer count = 0;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    lock.lock();
                    if(count>30) break;
                    if(count%3==0){
                        System.out.println(Thread.currentThread().getName());
                        count++;
                    }else{
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    condition.signalAll();
                    lock.unlock();
                }

            }
        },"Thread A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    lock.lock();
                    if(count>30) break;
                    if(count%3==1){
                        System.out.println(Thread.currentThread().getName());
                        count++;
                    }else{
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    condition.signalAll();
                    lock.unlock();
                }

            }
        },"Thread B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    lock.lock();
                    if(count>30) break;
                    if(count%3==2){
                        System.out.println(Thread.currentThread().getName());
                        count++;
                    }else{
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    condition.signalAll();
                    lock.unlock();
                }

            }
        },"Thread C").start();

    }

}
