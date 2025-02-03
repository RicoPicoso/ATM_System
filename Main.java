class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }


    public synchronized void deposit(double amount, String threadName) {
        balance += amount;
        System.out.println(threadName + " deposited " + amount + ". Current balance: " + balance);
        notifyAll();
    }

    public synchronized void withdraw(double amount, String threadName) {
        System.out.println(threadName + " is trying to withdraw " + amount);

        while (balance < amount) {
            System.out.println(threadName + " waiting to withdraw " + amount + " due to insufficient funds.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }

        balance -= amount;
        System.out.println(threadName + " successfully withdrew " + amount + ". Current balance: " + balance);
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;

    public WithdrawalThread(BankAccount account, double amount, String threadName) {
        super(threadName);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            while (true) {
                account.withdraw(amount, getName());
                Thread.sleep(amount != 200 ? 3000 : 2000);
            }
        } catch (InterruptedException e) {
            System.out.println(getName());
        }
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private double amount;

    public DepositThread(BankAccount account, double amount, String threadName) {
        super(threadName);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            while (true) {
                account.deposit(amount, getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(getName());
        }
    }
}


public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1);

        Thread Thread1 = new DepositThread(account, 300, "Thread-1");
        Thread Thread2 = new WithdrawalThread(account, 200, "Thread-2");
        Thread Thread3 = new WithdrawalThread(account, 500, "Thread-3");


        Thread1.start();
        Thread2.start();
        Thread3.start();

    }
}

