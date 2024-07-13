package org.example.SynchronizationAndLocks;

public class BankAccApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(10000.0);

//        create thread
        Thread withdraw = new Thread(()->{account.withdraw(3000);});
        Thread deposit = new Thread(()->{account.deposit(2000);});
        Thread getBal = new Thread(()->{double bal = account.getBalance();
            System.out.println("current balance is : "+bal);
        });

//        start thread
        withdraw.start();
        getBal.start();
        deposit.start();

    }
}
