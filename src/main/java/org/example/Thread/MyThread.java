package org.example.Thread;

public class MyThread extends Thread{

//    Thread having method run
    @Override
    public void run(){
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread : "+Thread.currentThread().getId()+" Count "+i);
        }
    }

}
