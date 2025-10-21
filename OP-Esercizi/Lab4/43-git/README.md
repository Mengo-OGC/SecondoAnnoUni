# Esercizio con Git, in locale

Per ogni passo,
si annoti in questo file il comando utilizzato ed il suo output,
per confrontarlo con le soluzioni.

### Si crei una nuova directory
mkdir 43git

### Si inizializzi un repository Git dentro la cartella suddetta.
git init 

### Si osservi lo stato del repository
ls -a
return: . .. .git

### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
ls 
return: Helloword.java

### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java 
git status
return: On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   HelloWorld.java

### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m "aggiunta HelloWorld.java"
return: [master (root-commit) 667247b] aggiunta HelloWorld.java
 1 file changed, 5 insertions(+)
 create mode 100644 HelloWorld.java

### Si compili il file Java e si verifichi lo stato del repository
git status
return: On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        HelloWorld.class

nothing added to commit but untracked files present (use "git add" to track)

### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
echo *.class .gitignore

### Si osservi lo stato del repository
git status
return: On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitignore

nothing added to commit but untracked files present (use "git add" to track)

### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git add .gitignore
git status .gitignore
return: On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitignore
git commit -m "aggiunta .gitignore"  
return: [master dd5824a] aggiunta .gitignore
 1 file changed, 1 insertion(+)
 create mode 100644 .gitignore

### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
echo * text=auto eol=lf >> .gitattributes

### Si osservi la storia del repository usando `git log --all --graph`
git log --all --graph

### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit
git status
return: On branch master
Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitattributes
        Mistake.java

nothing added to commit but untracked files present (use "git add" to track)
git add *
git add .gitattributes
git status
return: On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitattributes
        new file:   Mistake.java
git commit -m "aggiunta di Mistake.java ed .gitattributes
return: [master bedff99] aggiunta di Mistake.java ed .gitattributes
 2 files changed, 2 insertions(+)
 create mode 100644 .gitattributes
 create mode 100644 Mistake.java

### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica
mv Mistake.java ToDelete.java 
git add ToDelete.java

### Si elimini `ToDelete.java` e si registri la modifica in un commit
git commit -m "rinomina di Mis
take.java in ToDelete.java"
return: [master acd1a01] rinomina di Mistake.java in ToDelete.java
 1 file changed, 1 insertion(+)
 create mode 100644 ToDelete.java
 
### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`
acd1a01 (HEAD -> master) rinomina di Mistake.java in ToDelete.java
bedff99 aggiunta di Mistake.java ed .gitattributes
dd5824a aggiunta .gitignore
667247b aggiunta HelloWorld.java
return: il commit dove è stato creato "Mistake.java" è bedff99

### Si ripristini Mistake.java dal commit identificato al passo precedente
git checkout bedff99 -- Mistake.java
ls
return: HelloWorld.class  HelloWorld.java  Mistake.java  ToDelete.java

### Si rimuova il file ripristinato e si ripulisca lo stage
rm Mistake.java
ls
return: HelloWorld.class  HelloWorld.java  ToDelete.java
git status
return: On branch master
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    Mistake.java

no changes added to commit (use "git add" and/or "git commit -a")
git reset
return: Unstaged changes after reset:
D       Mistake.java

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
git checkout bedff99 
return: D       Mistake.java
Note: switching to 'bedff99'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

HEAD is now at bedff99 aggiunta di Mistake.java ed .gitattributes