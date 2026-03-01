# From application domain analysis to code

In this exercise, we will provide a description of the system (actually, of its *domain*) in natural language.
As an engineer, formalize this description by:

* Extract the entities, and map them to a hierarchy of interfaces. Usually, the entities that compose a domain (or problem) are nouns in natural language.
* Draw on paper the hierarchy of interfaces using the UML notation
* Enrich with methods representing the functionalities
* Take a design step: determine which entities must be concrete, and if some common concrete aspects can be summarized in abstract types
* Implement your solution in code

For the sake of simplicity, the problem description is provided in Italian:

### **Analisi del dominio**

Si desidera realizzare un *robot componibile*, ossia un robot al quale possono essere aggiunti o rimossi *componenti* arbitrari.

Un componente può essere acceso o spento.
Ogni componente può essere non connesso, oppure connesso ad un solo robot.
Il componente può compiere azioni sul robot.
Ciascun componente ha un proprio consumo di energia.

Il robot componibile espone una funzionalità che consente di mettere in moto e far funzionare tutti i componenti connessi, a patto ovviamente che siano accesi.
Quando tale funzionalità viene chiamata, il robot mette in esecuzione, per una sola volta, tutti i componenti ad esso connessi.
Quando il robot componibile fa uso di un componente, deve scalare dalla propria batteria il consumo di energia richiesto per l'azione.

Alcuni componenti sono in grado di supportare dei comandi, e prendono il nome di *componenti comandabili*.
Ciascun componente comandabile ha un proprio set di comandi supportati.
Il componente comandabile può ricevere un *comando*.
Alla ricezione del comando, se esso è fra quelli supportati, il componente comandabile modifica il proprio comportamento in maniera tale da eseguire il comando richiesto.

Si desidera testare l'infrastruttura creando un robot componibile ed assegnandogli i seguenti componenti:

* *Batteria atomica*. È un componente non comandabile, alimentato ad uranio-239, che ricarica istantaneamente il robot. In fase di test, per evitare il surriscaldamento, la batteria si attiva esclusivamente qualora la batteria del robot fosse al di sotto del 50% di carica.

* *Navigatore di confine*. È un componente non comandabile che, una volta avviato, fa sì che il robot raggiunga il bordo del `RobotEnvironment` e continui ad esplorarlo. Ossia, fa sì che il robot proceda in una direzione, fino ad arrivare al bordo, quindi ruoti di 90° e continui ad esplorare lungo il bordo, al raggiungimento di un nuovo bordo, si orienti in modo da poter proseguire l'esplorazione e prosegua.

* Due *braccia prensili*. Sono componenti comandabili, che supportano due comandi: *pick* e *drop*. Se è attivo il comando pick, e il braccio non ha oggetti in mano, allora viene preso un oggetto; se il braccio invece ha oggetti in mano, non viene effettuata alcuna azione. Se è attivo il comando drop, ed il braccio ha un oggetto in mano, allora l'oggetto viene lasciato; se il braccio invece non ha oggetti in mano, non viene eseguita alcuna azione.

https://mermaid.live/edit#pako:eNqVVmtv2jAU_SuR9yXTABGgQDNUCWg1VZq6qdW0F_tgEhOsYjuyHTrW8t9nx3k4r07jQxXfc3x8fXx93WcQsBABHwQHKMQ1hhGHZEMd9fvMBJaY0dG1s3jp9517tmUyDzYo_T4zjBt6xJxRgqg0pBUUKEUclqs0OAZfvAwGJb2K5FO_YrlfciI21MLzoFG4JXE1Ws8jVauzDGnNSMyoystILVcPilcEDacWNHLOUjKCgxWUEvHTa8QV4yHid_CIIygZb6ea5XVYxQikIdweUDOPNjDPh2fnqD5S5x3btoZHmmHpF24o9cJVMywEClRNjXHw2AqEnMW5XFfC2dqptmEuFrdU-biDAbq6cqxyqAJl_f3XtJZzrxJqRjdAK9P03tgX4dnE9S9C8pv71sG5Thb7Xo_Fh0S4pUQbqiI9Hbaws51A_VrZafTjTNrxG44VV8iaa6dSsgg7okqSvrNl7IAgrXHKVGuMZsJ2lnrul1hZ06p6zZ5oF_YR7WQXdo-jfSvIUbCHPEIKOzIcVg4ou8Qf0REdFB6yRJVrhZH7oNC6o5Vdlj3HPo-tpa9Mquv3kXWOfkfHTIlcQ3eQIEV7kBzTqASLpV2DWEf5JmBUJARl-3RNAjYBiwy7oSyJ9jnjX-dZdBNrt7oztJ-rbg1d56o8vpWIiDXkHKPQ7ar7Rh-zfQ7yayyUP8Xg56-S8k7ZBrlcHg7FlReuLtyyJs7Vm152LWslLD6pXZRj8YRlsG-N7XZ2EIs1oxQFUm-xDAcmaIdCLFqiy8BUYWuq9TfFtsZBFPHotE4LoVaD55pIa8-uiAVpS8xcVl-5xVUl-4HU89vuS_Vt7GDpF60TqZaAcvgDh9utugBtZab5LlR_7hKyRVxtQDeuFuHsSbOkTcR9vcuVj2H1WTC-x1kLye1_nymAHog4DoEveYJ6gCBOoB6CVGQD5B4RtAG--gwhf9yADdVzYkh_MEbyaVzfXODv4EGoURKHUKLsH7yCgqiye80SKoHvDYezVAT4z-A38Efj2cCbTKaTyWw-9CbexbQHTio8HYwm0_Hcm48nw-lofu6BP-mqw8H80ru8UMHxzBuNL4ZeD8BEsocTDcyC578cmUO7