package org.example.SynchronizationAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public BankAccount(double initialBal){
        this.balance = initialBal;
    }
    public void withdraw (double amount) {
        lock.lock();
        try {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal of " + amount + " successful. New balance: " + balance);
            } else {
                System.out.println("Withdrawal failed. Insufficient funds.");
            }
        }finally {
            lock.unlock();
        }
    }

//    or using synchronized keyword

//    public synchronized void withdraw (double amount) {
//
//            if (amount > 0 && amount <= balance) {
//                balance -= amount;
//                System.out.println("Withdrawal of " + amount + " successful. New balance: " + balance);
//            } else {
//                System.out.println("Withdrawal failed. Insufficient funds.");
//            }
//
//    }
    public void deposit (double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit of " + amount + " successful. New balance: " + balance);
            } else {
                System.out.println("Deposit failed. Invalid amount.");
            }
        }finally {
            lock.unlock();
        }
    }
    public double getBalance(){
        lock.lock();
        try {
            return balance;
        }finally {
            lock.unlock();
        }
    }
}
