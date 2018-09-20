package org.peng.concurrency;


public class MultiThreadTest {
    public static void main(String[] args) throws Exception{
        System.out.println("MultiThread class.");
        for (int i=0;i<10;i++){
            Thread t = new MultiThread();
            t.start();
        }
        Thread.sleep(1000);
        System.out.println("R class.");
        R r = new R();
        for (int i=0;i<10;i++){
            Thread t = new Thread(r);
            t.start();
        }
    }
}
