package org.example.Thread;

public class RunnableEx {
    public static void main(String[] args) {
        MyRunnable runobj = new MyRunnable();

        Thread t1 = new Thread(runobj);
        Thread t2 = new Thread(runobj);

        t1.start();
        t2.start();
    }
}
