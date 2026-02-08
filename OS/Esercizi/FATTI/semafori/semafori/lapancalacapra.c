/*
Scrivi un programma che stampa in maniera indefinita 
la seguente stringa:
"Sopra la panca la capra campa, sotto la panca la capra crepa"

Problema: devi farlo sincronizzando adeguatamente i 
seguenti 3 processi:

Process P1 {
   while (true) {
	print("la panca ");
  }
}

Process P2 {
   while (true) {
	print("la capra ");
  }
}

Process P3 {
   while (true) {
	print("Sopra ");
	print("campa, sotto ");
	print("crepa");
  }
}

////// Soluzione ////////////

semaphore sem1 = new semaphore(0);
semaphore sem2 = new semaphore(0);
semaphore sem3 = new semaphore(1);


Process P1 {
   while (true) {
	sem1.P();
	print("la panca ");
	sem2.V();
  }
}

Process P2 {
   while (true) {
	sem2.P();
	print("la capra ");
	sem3.V();
  }
}

Process P3 {
   while (true) {
	sem3.P();
	print("Sopra ");
	sem1.V();
	sem3.P();
	print("campa, sotto ");
	sem1.V();
	sem3.P();
	print("crepa");
	sem3.V();
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
	sem_wait(&sem1); // sem1.P();
	printf("la panca ");
	sem_post(&sem2); // sem2.V();
    }
    return NULL;
}

void* p2(void* arg) {
    while (1) {
	sem_wait(&sem2); // sem2.P();
	printf("la capra ");
	sem_post(&sem3); // sem3.V();
    }
    return NULL;
}

void* p3(void* arg) {
    while (1) {
	sem_wait(&sem3); // sem3.P();
	printf("Sopra ");
	sem_post(&sem1); //sem1.V();
	sem_wait(&sem3); // sem3.P();
	printf("campa, sotto ");
	sem_post(&sem1); //sem1.V();
	sem_wait(&sem3); // sem3.P();
	printf("crepa\n");
	sem_post(&sem3); // sem3.V();
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
