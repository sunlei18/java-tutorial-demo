package com.tuwei.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEcho {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8082);
        while (true){

            System.out.println("等待建立连接2");
            Socket socket = serverSocket.accept();
            System.out.println("连接建立");
            handler(socket);
            System.out.println("处理数据完成");

        }
    }

    private static void handler(Socket socket) throws IOException {

        byte[] bytes = new byte[1024];
        int read = socket.getInputStream().read(bytes);
        if(read != 0){
            System.out.println("收到消息"+new String(bytes,0,read));
        }
    }
}
