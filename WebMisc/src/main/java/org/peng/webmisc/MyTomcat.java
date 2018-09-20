package org.peng.webmisc;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class MyTomcat{
    public static void main(String [] args) throws Exception{
        ServerSocket s = new ServerSocket(10086);

        while(true){
            Socket client = s.accept();
            System.out.println("Waiting for connection on 9999...");
            OutputStream os = client.getOutputStream();
            String welcome = "Welcome to socket.\n";
            os.write(welcome.getBytes());
            os.close();
        }

    }
}