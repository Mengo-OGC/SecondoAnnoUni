# Esercizio con Git, in locale

Per ogni passo,
si annoti in questo file il comando utilizzato ed il suo output,
per confrontarlo con le soluzioni.

### Si crei una nuova directory
mkdir Esercizio

### Si inizializzi un repository Git dentro la cartella suddetta.
git init
Initialized empty Git repository in C:/Users/leo05/Desktop/SecondoAnnoUni/OP-Esercizi/Lab5/54-branching/Esercizio/.git/

### Si osservi lo stato del repository
git status
On branch main

No commits yet

nothing to commit (create/copy files and use "git add" to track)

### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
git status
On branch main

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        HelloWorld.java

nothing added to commit but untracked files present (use "git add" to track)

### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java
warning: in the working copy of 'HelloWorld.java', LF will be replaced by CRLF the next time Git touches it

git status
On branch main

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   HelloWorld.java

### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m "add HelloWorld.java"

### Si compili il file Java e si verifichi lo stato del repository
>git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        HelloWorld.class


### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
ho creato il .gitignore specificando *.class

### Si osservi lo stato del repository
git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitignore

### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git add .
>git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitignore
        modified:   HelloWorld.java

### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
fatto...

### Si osservi la storia del repository usando `git log --all --graph`
git log --all --graph
* commit be921ae2ce9318b1614b14e31e071ebb8026f9eb (HEAD -> main)
  Author: Leonardo Mengozzi <leonardo.mengozzi2@studio.unibo.it>
  Date:   Mon Oct 27 11:05:11 2025 +0100

      add HelloWorld.java

### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`
ok...

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit
git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitignore
        modified:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitattributes

type nul > Mistake.java // equivalente  di touch in linux

git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitignore
        modified:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitattributes
        Mistake.java

git add .
git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitattributes
        new file:   .gitignore
        modified:   HelloWorld.java
        new file:   Mistake.java

git commit -m "adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java"
[main 72f60cf] adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java
 4 files changed, 9 insertions(+), 2 deletions(-)
 create mode 100644 .gitattributes
 create mode 100644 .gitignore
 create mode 100644 Mistake.java

git status
On branch main
nothing to commit, working tree clean

### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica
git reset Mistake.java

move Mistake.java ToDelete.java     // equivalente di mv
        1 file spostato/i.

git add ToDelete.java

it status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   ToDelete.java

Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    Mistake.java

git commit -m "rename Mistake.java in ToDelete.java"
[main b8e8dcf] rename Mistake.java in ToDelete.java
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 ToDelete.java

git add .

git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        deleted:    Mistake.java

git commit -m "correct rename of Mistake.java in ToDelete.java"
[main e167582] correct rename of Mistake.java in ToDelete.java
 1 file changed, 0 insertions(+), 0 deletions(-)
 delete mode 100644 Mistake.java

git status
On branch main
nothing to commit, working tree clean

### Si elimini `ToDelete.java` e si registri la modifica in un commit
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git reset ToDelete.java

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git status
On branch main
nothing to commit, working tree clean

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git commit -m "reset ToDelete.java"
On branch main
nothing to commit, working tree clean

### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git log --oneline
e167582 (HEAD -> main) correct rename of Mistake.java in ToDelete.java
b8e8dcf rename Mistake.java in ToDelete.java
72f60cf adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java
be921ae add HelloWorld.java

### Si ripristini Mistake.java dal commit identificato al passo precedente
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git checkout 72f60cf -- Mistake.java

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git status
On branch main
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   Mistake.java

### Si rimuova il file ripristinato e si ripulisca lo stage
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>del Mistake.java

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git reset

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git status
On branch main
nothing to commit, working tree clean

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git log --oneline
e167582 (HEAD -> main) correct rename of Mistake.java in ToDelete.java
b8e8dcf rename Mistake.java in ToDelete.java
72f60cf adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java
be921ae add HelloWorld.java

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git checkout 72f60cf
Note: switching to '72f60cf'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

HEAD is now at 72f60cf adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git config --global advice.detachedHead false

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git status
HEAD detached at 72f60cf
nothing to commit, working tree clean

### Si crei un nuovo branch di nome `experiment` e si agganci la `HEAD` al nuovo branch
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git checkout -b experiment
Switched to a new branch 'experiment'

### Si crei un file README.md con contenuto a piacere, e si faccia un commit che lo includa
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>echo ciao >> README.md

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git add .
warning: in the working copy of 'README.md', CRLF will be replaced by LF the next time Git touches it

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git commit -m "add README.md"
[experiment 2c9e488] add README.md
 1 file changed, 1 insertion(+)
 create mode 100644 README.md

### Si torni sul branch master e si elenchino i branch disponibili
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git checkout main
Switched to branch 'main'
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git log --all --graph --oneline
* 2c9e488 (experiment) add README.md
| * e167582 (HEAD -> main) correct rename of Mistake.java in ToDelete.java
| * b8e8dcf rename Mistake.java in ToDelete.java
|/
* 72f60cf adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java
* be921ae add HelloWorld.java

### Si unisca il branch experiment al branch master (si faccia un merge in cui experiment viene messo dentro master, e non viceversa)
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git status
On branch main
nothing to commit, working tree clean

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git merge experiment
Merge made by the 'ort' strategy.
 README.md | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 README.md

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git commit --no-edit
On branch main
nothing to commit, working tree clean

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git add .

C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git commit --no-edit
On branch main
nothing to commit, working tree clean

### Si osservi la storia del repository
C:\Users\leo05\Desktop\SecondoAnnoUni\OP-Esercizi\Lab5\54-branching\Esercizio>git log --all --graph --oneline
*   f8effaf (HEAD -> main) Merge branch 'experiment'
|\
| * 2c9e488 (experiment) add README.md
* | e167582 correct rename of Mistake.java in ToDelete.java
* | b8e8dcf rename Mistake.java in ToDelete.java
|/
* 72f60cf adds .gitattributes, .gitignore, Mistake.java and updated HelloWorld.java
* be921ae add HelloWorld.java
