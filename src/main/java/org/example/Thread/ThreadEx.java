package org.example.Thread;

public class ThreadEx {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

//        start the thread
        t1.start(); //it's having its own execution
        t2.start();//it's having its own execution

//        running simultaneously:- same time
//        not depend on any thread to others.

    }
}
