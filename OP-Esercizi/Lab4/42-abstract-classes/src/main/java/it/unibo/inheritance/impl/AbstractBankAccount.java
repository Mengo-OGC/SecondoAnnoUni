package it.unibo.inheritance.impl;

import it.unibo.inheritance.api.AccountHolder;
import it.unibo.inheritance.api.BankAccount;

public abstract class AbstractBankAccount implements BankAccount{
    protected static final double TRANSACTION_FEE = 0.1;
    protected static final double ATM_TRANSACTION_FEE = 1;
    protected static final double MANAGEMENT_FEE = 5;

    private final AccountHolder holder;
    private double balance;
    private int transactions;

    public AbstractBankAccount(
        final AccountHolder accountHolder, 
        final double balance
    ) {
        this.holder = accountHolder;
        this.balance = balance;
        this.transactions = 0;
    }

    public void chargeManagementFees(final int id) {
        /*
         * Riduce il bilancio del conto di un ammontare pari alle spese di gestione
         */
        final double feeAmount = computeFee();
        if (checkUser(id) && isWithDrawAllowed(feeAmount)) {
            setBalance(getBalance() - feeAmount);
            resetTransactions();
        }
    }

    protected void setBalance(final double balance) {
        this.balance = balance;
    }

    public void deposit(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto Nota: il deposito va a buon fine solo se l'id utente
         * corrisponde
         */
        this.transactionOp(id, amount);
    }

    public void depositFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto detraendo le spese (costante ATM_TRANSACTION_FEE) relative
         * all'uso dell'ATM (bancomat) Nota: il deposito va a buon fine solo se
         * l'id utente corrisponde
         */
        this.deposit(id, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    public AccountHolder getAccountHolder() {
        return holder;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde
         */
        if (isWithDrawAllowed(amount)) {
            this.transactionOp(id, -amount);
        }
    }

    public int getTransactionsCount() {
        return this.transactions;
    }

    public void withdrawFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount + le spese
         * (costante ATM_TRANSACTION_FEE) relative all'uso dell'ATM (bancomat)
         * al totale del conto. Note: - Il conto puo' andare in rosso (ammontare
         * negativo) - Il prelievo va a buon fine solo se l'id utente
         * corrisponde
         */
        this.withdraw(id, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    private boolean checkUser(final int id) {
        return this.getAccountHolder().getUserID() == id;
    }

    private void incrementTransactions() {
        this.transactions++;
    }

    private void resetTransactions() {
        this.transactions = 0;
    }

    private void transactionOp(final int id, final double amount) {
        if (checkUser(id)) {
            this.balance += amount;
            this.incrementTransactions();
        }
    }

    protected abstract boolean isWithDrawAllowed(double balance);
    protected abstract double computeFee();
}
