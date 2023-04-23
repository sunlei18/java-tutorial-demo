package com.tuwei.test;

public class SyncDemo {

    /**
     * 需要用volatile修饰，防止指令重排序
     * new一个对象正常的顺序应该是
     * 1.分配内存空间
     * 2.初始化对象
     * 3.对象指向内存空间
     * JVM底层会进行字节码优化，可能会出现先执行1-3-2
     * 如果按照这种方式进行执行，在多线程情况下，线程1执行1-3后，线程2获取instance对象，拿到的是没有初始化的对象
     */
    private static volatile SyncDemo instance;

    public SyncDemo getInstance(){
        if(instance == null){
            synchronized (SyncDemo.class){
                if(instance == null){
                    instance = new SyncDemo();
                }
            }
        }
        return instance;
    }
}
