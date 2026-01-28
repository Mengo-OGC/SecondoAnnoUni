/*
Risolvere il seguente problema di programmazione concorrente:
Abbiamo due processi che scommettono iterativamente sul risultato del lancio di una moneta.
P_testa decide quanto puntare, scommette su testa
P_croce decide quanto puntare, scommette su croce
P_oracolo è il processo che decide in anticipo il numero di scommesse da fare, si occupa del lancio della moneta, assegna il punteggio al vincitore, toglie il punteggio al perdente.

// variabili condivise
int fine_scommesse = 0;
int puntata_p_testa, puntata_p_croce;  // quanto puntano i due giocatori
int punteggio_p_testa = 0, punteggio_p_croce = 0;  // credito dei giocatori
char vincitore;  // assume valore "c" se uscito croce, "t" se uscito testa

// semafori 
semaphore mutex = new semaphore(1);
semaphore puntata = new semaphore(0);
semaphore lancio_effettuato = new semaphore(0);

Process P_testa {
  int terminato = 0;
  while (terminato == 0) {
	// decide quanto puntare 
	mutex.P();
	puntata_p_testa = rand();
	mutex.V();
	// avviso che ho puntato		
	puntata.V();	

	// aspetta che l'oracolo pubblichi il risultato
	lancio_effettuato.P();

	// esulta o si lamenta
	mutex.P();
	if (vincitore == "t")
	   printf("Testa: evviva ho vinto!!\n");
	else
	   print("Testa: accipicchia ...\n");
        terminato = fine_scommesse;
	mutex.V();
  }
}

Process P_croce {
  int terminato = 0;
  while (terminato == 0) {
	// decide quanto puntare 
	mutex.P();
	puntata_p_croce = rand();
	mutex.V();
	// avviso che ho puntato		
	puntata.V();	

	// aspetta che l'oracolo pubblichi il risultato
	lancio_effettuato.P();

	// esulta o si lamenta
	mutex.P();
	if (vincitore == "c")
	   printf("Croce: evviva ho vinto!!\n");
	else
	   print("Croce: accipicchia ...\n");
        terminato = fine_scommesse;
	mutex.V();
  }
}

Process P_oracolo {
   // decide il numero di iterazioni
   int num_iterazioni = rand();
   int i;

   for i = 1:num_iterazioni {
	// aspetta che i due giocatori puntino
	puntata.P(); // quando supero la prima un processo ha puntato	
	puntata.P(); // adesso ha puntato anche il secondo	

	// lancia la moneta e assegna punteggi 
	mutex.P();	
	if (rand() < MAX_RAND/2) {
	   vincitore = "t";
	   punteggio_p_testa += puntata_p_testa;
	   punteggio_p_croce -= puntata_p_croce;
	} else {
	   vincitore = "c";
	   punteggio_p_testa -= puntata_p_testa;
	   punteggio_p_croce += puntata_p_croce;
	} 
	mutex.V();

	// pubblica il risultato => avviso gli altri processi 
	lancio_effettuato.V();
	lancio_effettuato.V();
   }
   mutex.P();
   fine_scommesse = 1;
   mutex.V();
}

*/

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <time.h>

// variabili condivise
int fine_scommesse = 0;
int puntata_p_testa, puntata_p_croce;  // quanto puntano i due giocatori
int punteggio_p_testa = 0, punteggio_p_croce = 0;  // credito dei giocatori
char vincitore;  // assume valore "c" se uscito croce, "t" se uscito testa

int MAX_PUNTATA = 10;

sem_t mutex, puntata, lancio_effettuato;


void* p_testa(void* arg) {
    int terminato = 0;
    while (terminato == 0) {
	// decide quanto puntare 
	sem_wait(&mutex); // mutex.P();
	puntata_p_testa = rand() % MAX_PUNTATA + 1;
	printf("TESTA: io punto %d\n", puntata_p_testa);
	fflush(stdout);
	sem_post(&mutex);// mutex.V();
	// avviso che ho puntato		
	sem_post(&puntata); // puntata.V();	

	// aspetta che l'oracolo pubblichi il risultato
	sem_wait(&lancio_effettuato); // lancio_effettuato.P();

	// esulta o si lamenta
	sem_wait(&mutex); // mutex.P();
	if (vincitore == 't') {
	   printf("Testa: evviva ho vinto!!\n");
	   fflush(stdout);
	} else {
	   printf("Testa: accipicchia ...\n");
	   fflush(stdout);
	}
        terminato = fine_scommesse;
	sem_post(&mutex); // mutex.V();
    }
    return NULL;
}

void* p_croce(void* arg) {
    int terminato = 0;
    while (terminato == 0) {
	// decide quanto puntare 
	sem_wait(&mutex); //mutex.P();
	puntata_p_croce = rand() % MAX_PUNTATA + 1;
	printf("CROCE: io punto %d\n", puntata_p_croce);
	fflush(stdout);
	sem_post(&mutex);// mutex.V();
	// avviso che ho puntato		
	sem_post(&puntata); // puntata.V();	

	// aspetta che l'oracolo pubblichi il risultato
	sem_wait(&lancio_effettuato); // lancio_effettuato.P();

	// esulta o si lamenta
	sem_wait(&mutex); //mutex.P();
	if (vincitore == 'c') {
	   printf("Croce: evviva ho vinto!!\n");
	   fflush(stdout);
	} else {
	   printf("Croce: accipicchia ...\n");
	   fflush(stdout);
	}
        terminato = fine_scommesse;
	sem_post(&mutex);// mutex.V();
    }
    return NULL;
}

void* p_oracolo(void* arg) {
   // decide il numero di iterazioni
   int num_iterazioni = rand() % 20;
   printf("ORACOLO: oggi si gioca per %d volte\n", num_iterazioni);
   fflush(stdout);
   int i;

   for (i=0; i<num_iterazioni; i++) {
	// aspetta che i due giocatori puntino
	sem_wait(&puntata); // puntata.P(); // quando supero la prima un processo ha puntato	
	sem_wait(&puntata); // puntata.P(); // adesso ha puntato anche il secondo	

	printf("ORACOLO: tutti hanno puntato, rien ne va plus\n");
	fflush(stdout);

	// lancia la moneta e assegna punteggi 
	sem_wait(&mutex); //mutex.P();
	if (rand() < RAND_MAX/2) {
	   vincitore = 't';
	   punteggio_p_testa += puntata_p_testa;
	   punteggio_p_croce -= puntata_p_croce;
	} else {
	   vincitore = 'c';
	   punteggio_p_testa -= puntata_p_testa;
	   punteggio_p_croce += puntata_p_croce;
	} 
	printf("ORACOLO: aggiornati punteggi - Testa %d - Croce %d\n", punteggio_p_testa,
	      punteggio_p_croce);
	fflush(stdout);
	// controllo preventivo per evitare che gli altri processi facciano 
	// una nuova iterazione quando invece dovrebbero terminare
	if (i==num_iterazioni-1)
	   fine_scommesse = 1;
	sem_post(&mutex); //mutex.P();

	// pubblica il risultato => avviso gli altri processi 
	sem_post(&lancio_effettuato); // lancio_effettuato.V();
	sem_post(&lancio_effettuato); // lancio_effettuato.V();
   }
   sem_wait(&mutex); //mutex.P();
   printf("***\nORACOLO: punteggi finali\n- Testa %d\n- Croce %d\n***\n", punteggio_p_testa,
	      punteggio_p_croce);
   fflush(stdout);
   sem_post(&mutex); //mutex.P();
   return NULL;
}


int main() {
    // **Aggiunto post lezione:** Imposta il seed del generatore di numeri
    // casuali utilizzando l'ora corrente del sistema, assicurando una
    // sequenza diversa ad ogni esecuzione.
    srand(time(NULL));


    // creo mutex inizializzato a 1
    if (sem_init(&mutex, 0, 1) != 0) {
        perror("Errore nell'inizializzazione dei semaforo");
        exit(1);
    }

    // creo puntata inizializzato a 0
    if (sem_init(&puntata, 0, 0) != 0) {
        perror("Errore nell'inizializzazione dei semaforo");
        exit(1);
    }

    // creo lancio_effettuato inizializzato a 0
    if (sem_init(&lancio_effettuato, 0, 0) != 0) {
        perror("Errore nell'inizializzazione dei semaforo");
        exit(1);
    }

    // Array di thread e ID
    pthread_t processo1, processo2, processo3;
    
    // Crea il thread per il processo 1
    if (pthread_create(&processo1, NULL, p_oracolo, NULL) != 0) {
        perror("Errore nella creazione del thread processo 1");
        exit(1);
    }
    
    // Crea il thread per il processo 2
    if (pthread_create(&processo2, NULL, p_testa, NULL) != 0) {
        perror("Errore nella creazione del thread processo 2");
        exit(1);
    }

    // Crea il thread per il processo 3
    if (pthread_create(&processo3, NULL, p_croce, NULL) != 0) {
        perror("Errore nella creazione del thread processo 3");
        exit(1);
    }


    pthread_join(processo1, NULL);
    pthread_join(processo2, NULL);
    pthread_join(processo3, NULL);
    
    

    return 0;
}
