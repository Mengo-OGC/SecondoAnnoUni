package it.unibo.arrays;

class MyCircularArray {

    int[] array;

    MyCircularArray() {
        this(10);
    }

    MyCircularArray(int size) {
        this.array = new int[size];
    }

    private int round;

    void add(final int elem) {
        array[round] = elem;
        round = ++round % array.length;
    }

    void reset() {
        for(int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    void printArray() {
        System.out.print("[");
        for (int i = 0; i < this.array.length - 1; i++) {
            System.out.print(this.array[i] + ",");
        }
        System.out.println(this.array[this.array.length - 1] + "]");
    }

    public static void main(final String[] args) {

        // 1) Creare un array circolare di dieci elementi
        MyCircularArray i = new MyCircularArray();

        // 2) Aggiungere gli elementi da 1 a 10 e stampare il contenuto
        // dell'array circolare
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
        i.add(7);
        i.add(8);
        i.add(9);
        i.add(10);
        i.printArray();
        // 3) Aggiungere gli elementi da 11 a 15 e stampare il contenuto
        // dell'array circolare
        i.add(11);
        i.add(12);
        i.add(13);
        i.add(14);
        i.add(15);
        i.printArray();
        // 4) Invocare il metodo reset
        i.reset();
        // 5) Stampare il contenuto dell'array circolare
        i.printArray();
        // 6) Aggiungere altri elementi a piacere e stampare il contenuto
        // dell'array circolare
        i.add(1);
        i.printArray();
    }
}
