package it.unibo.encapsulation.interfaces;

public class StrictBankAccount implements BankAccount {
    private final static double ATM_TRANSACTION_FEE = 5;
    private final static double PERCENTION = 0.1;

    private final int id;
    private double balance;
    private int transactions;

    public StrictBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
    }

    private void controlId(final int id) {
        if (id != this.id) {
            return;
        }
    }

    public void withdraw(final int id, final double amount) {
        controlId(id);
        if (amount > this.balance) {
            return;
        }
        this.balance = this.balance - amount;
        this.transactions++;
    }

    public void deposit(final int id, final double amount) {
        controlId(id); 
        this.balance = this.balance + amount;
        this.transactions++;
    }

    public void depositFromATM(final int id, final double amount) {
        deposit(id, amount);
        this.balance = this.balance - ATM_TRANSACTION_FEE - (PERCENTION * this.transactions);
    }

    public void withdrawFromATM(final int id, final double amount) {
        withdraw(id, amount);
        this.balance = this.balance - ATM_TRANSACTION_FEE - (PERCENTION * this.transactions);
    }
    
    /*
        * This method is used to charge the management fees on the account balance
        * (they are computed every few months). This method does not return the amount
        * computed, it directly collects the amount from the balance.
        */
    public void chargeManagementFees(final int id){

    }

    public double getBalance() {
        return this.balance;
    }

    public int getTransactionsCount() {
        return this.transactions;
    }
}
