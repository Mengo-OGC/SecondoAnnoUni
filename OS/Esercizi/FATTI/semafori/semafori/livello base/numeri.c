/*
Scrivi un programma che stampa in maniera indefinita 
la seguente stringa:
"123456789"

Problema: devi farlo sincronizzando adeguatamente i 
seguenti 3 processi:

Process P1 {
   while (true) {
	print("789");
   }
}

Process P2 {
   while (true) {
	print("456");
   }
}

Process P3 {
    while (true) {
        print("123");
    }
}

////// Soluzione ////////////

semaphore sem1 = new semaphore(1);
semaphore sem2 = new semaphore(0);
semaphore sem3 = new semaphore(0);
semaphore sem4 = new semaphore(0);


Process P1 {
   while (true) {
    sem3.P();
	print("789");
   }
}

Process P2 {
   while (true) {
    sem2.P();
	print("456");
    sem3.V();
   }
}

Process P3 {
    while (true) {
        sem1.P();
        print("123");
        sem2.V();
    }
}

*/
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <time.h>

sem_t sem1, sem2, sem3;

void* p1(void* arg) {
    while (1) {
	sem_wait(&sem3); //sem3.P();
	printf("789\n");
    sem_post(&sem1); //per il loop
    }
    return NULL;
}

void* p2(void* arg) {
    while (1) {
	sem_wait(&sem2); // sem2.P();
	printf("456");
	sem_post(&sem3); // sem3.V();
    }
    return NULL;
}

void* p3(void* arg) {
    while (1) {
	sem_wait(&sem1); // sem1.P();
	printf("123");
	sem_post(&sem2); // sem2.V();
    }
    return NULL;
}


int main() {

    // creo sem1 inizializzato a 1
    if (sem_init(&sem1, 0, 1) != 0) {
        perror("Errore nell'inizializzazione dei semaforo");
        exit(1);
    }

    // creo sem2 inizializzato a 0
    if (sem_init(&sem2, 0, 0) != 0) {
        perror("Errore nell'inizializzazione dei semaforo");
        exit(1);
    }

    // creo sem3 inizializzato a 0
    if (sem_init(&sem3, 0, 0) != 0) {
        perror("Errore nell'inizializzazione dei semaforo");
        exit(1);
    }

    // Array di thread e ID
    pthread_t processo1, processo2, processo3;
    
    // Crea il thread per il processo 1
    if (pthread_create(&processo1, NULL, p1, NULL) != 0) {
        perror("Errore nella creazione del thread processo 1");
        exit(1);
    }
    
    // Crea il thread per il processo 2
    if (pthread_create(&processo2, NULL, p2, NULL) != 0) {
        perror("Errore nella creazione del thread processo 2");
        exit(1);
    }

    // Crea il thread per il processo 3
    if (pthread_create(&processo3, NULL, p3, NULL) != 0) {
        perror("Errore nella creazione del thread processo 3");
        exit(1);
    }


    pthread_join(processo1, NULL);
    pthread_join(processo2, NULL);
    pthread_join(processo3, NULL);
    
    
    printf("\nTutti i filosofi hanno terminato. Arrivederci!\n");
    return 0;
}
