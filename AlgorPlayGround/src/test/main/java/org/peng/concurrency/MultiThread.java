package org.peng.concurrency;
import java.io.*;
import java.lang.Thread;
public class MultiThread extends Thread {
    public int x = 0;

    public void run(){
        System.out.println(++x);
    }
}


class R implements Runnable{
    private int x =0;
    public void run(){
        System.out.println(++x);
    }
}


