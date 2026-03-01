package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;

public class RestrictedBankAccount extends AbstractBankAccount{

    public RestrictedBankAccount(AccountHolder accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    protected boolean isWithDrawAllowed(double balance) {
        return this.getBalance() > balance;
    }

    @Override
    protected double computeFee() {
        return MANAGEMENT_FEE + getTransactionsCount() * TRANSACTION_FEE;
    }

}
