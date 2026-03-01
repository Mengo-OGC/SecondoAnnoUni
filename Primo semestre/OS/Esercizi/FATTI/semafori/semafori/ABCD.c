/*
Scrivi un programma che stampa in maniera indefinita 
la seguente stringa:
"ADCB"

Problema: devi farlo sincronizzando adeguatamente i 
seguenti 2 processi utilizzando solo 2 semafori:

Process P1 {
   while (true) {
	print("A");
    print("C");
   }
}

Process P2 {
   while (true) {
	print("D");
    print("B");
   }
}


////// Soluzione ////////////

semaphore sem1 = new semaphore(1);
semaphore sem2 = new semaphore(0);


Process P1 {
   while (true) {
    sem1.P();
	print("A");
    sem2.V();
    sem1.P();
    print("C");
    sem2.V();
   }
}

Process P2 {
   while (true) {
    sem2.P();
	print("D");
    sem1.V();
    sem2.P();
    print("B");
   }
}

*/
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <time.h>

sem_t sem1, sem2;

void* p1(void* arg) {
    while (1) {
	sem_wait(&sem1); //sem1.P();
	printf("A");
    sem_post(&sem2); //sem2.V();
    sem_wait(&sem1); //sem1.P();
    printf("C");
    sem_post(&sem2); //sem2.V();
    }
    return NULL;
}

void* p2(void* arg) {
    while (1) {
	sem_wait(&sem2); // sem2.P();
	printf("D");
	sem_post(&sem1); // sem1.V();
    sem_wait(&sem2); // sem2.P();
    printf("B\n");
    sem_post(&sem1); //per il loop
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

    // Array di thread e ID
    pthread_t processo1, processo2;
    
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

    pthread_join(processo1, NULL);
    pthread_join(processo2, NULL);    
    
    printf("\nTutti i filosofi hanno terminato. Arrivederci!\n");
    return 0;
}
