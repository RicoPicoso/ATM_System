# **ATM**

## **Overview**
This project is a multithreaded simulation of a banking system implemented in Java. It demonstrates the use of threads, synchronization, and shared resources to simulate real-world banking operations such as deposits, withdrawals, and interest calculations.

---

## **Features**
1. **Deposit Transactions**
    - A thread deposits money into the account every second.
2. **Withdrawal Transactions**
    - Two threads withdraw money:
        - One withdraws 200 every 2 seconds.
        - Another withdraws 500 every 3 seconds.
    - Threads wait if there are insufficient funds.
3. **Interest Calculation**
    - A thread adds 2% interest to the account balance every 5 seconds.
4. **Thread Safety**
    - Synchronized methods ensure consistent operations on the shared bank account.
5. **Logging**
    - Detailed logs display transaction statuses and account balance updates.


## **How to Run the Project**
1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/banking-system-simulation.git
    ```
2. **Navigate to the program directory**
   ```bash
   cd ATM
   ``` 
3. **Compile the code**
     ```bash
   javac Main.java
   ```
4. **Run the program**
     ```bash
   java Main
   ```
   

