package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */
        AccountHolder a1 = new AccountHolder("Andrea", "Rossi", 1);
        /*
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */
        AccountHolder a2 = new AccountHolder("Alex", "Bianchi", 2);
        /*
         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */
        BankAccount b1 = new SimpleBankAccount(1, 0);
        BankAccount b2 = new StrictBankAccount(1, 0);
        /*
         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         */

        /*
         * 5) Depositare €10000 in entrambi i conti
         */
        b1.deposit(1, 10000);
        b2.deposit(2, 10000);
        /*
         * 6) Prelevare €15000$ da entrambi i conti
         */
        b1.withdraw(1,15000);
        b2.withdraw(2,15000);
        /*
         * 7) Stampare in stdout l'ammontare corrente
         */
        System.out.println(b1.getBalance());
        System.out.println(b2.getBalance());
        /*
         * 8) Qual è il risultato e perché?
         */
        /*
         * 9) Depositare nuovamente €10000 in entrambi i conti
         */
        b1.deposit(1, 10000);
        b2.deposit(2, 10000);
        /*
         * 10) Invocare il metodo computeManagementFees su entrambi i conti
         */
        b1.chargeManagementFees(1);
        b2.chargeManagementFees(2);
        /*
         * 11) Stampare a video l'ammontare corrente
         */
        System.out.println(b1.getBalance());
        System.out.println(b2.getBalance());
        /*
         * 12) Qual è il risultato e perché?
         */
    }
}
