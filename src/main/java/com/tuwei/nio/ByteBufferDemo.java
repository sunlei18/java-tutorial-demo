package com.tuwei.nio;

import java.nio.ByteBuffer;

public class ByteBufferDemo {

    public static void main(String[] args) {

        heapAccerss();
        directAccerss();

    }

    public static void heapAccerss(){
        long startTime = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        for (int i=0;i<100000;i++){
            for(int j=0;j<200;j++){
                buffer.putInt(j);
            }
            buffer.flip();
            for(int j=0;j<200;j++){
                buffer.getInt(j);
            }
            buffer.clear();
        }
        System.out.println("cost time:"+(System.currentTimeMillis()-startTime));
    }

    public static void directAccerss(){
        long startTime = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1000);
        for (int i=0;i<100000;i++){
            for(int j=0;j<200;j++){
                buffer.putInt(j);
            }
            buffer.flip();
            for(int j=0;j<200;j++){
                buffer.getInt(j);
            }
            buffer.clear();
        }
        System.out.println("cost time:"+(System.currentTimeMillis()-startTime));
    }
}
