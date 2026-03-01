package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student s1 = new Student(1, "luca", "bevilacqua", "1234", 2024);
        Student s2 = new Student(1, "luca", "targhini", "4321", 2020);
        Student s3 = new Student(1, "andrea", "mazzini", "666", 2030);
        // 2)Creare 2 docenti a piacere
        Professor p1 = new Professor(1, "giru", "viroli", "1111", new String[] {"Algebra", "filosofia"});
        Professor p2 = new Professor(2, "Antonio", "Paolini", "0000", new String[] {"Ginnastica", "Fisica"});
        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom er1 = new ExamRoom(100, "AL1", true, false);
        ExamRoom er2 = new ExamRoom(80, "AL2", true, true);
        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam e1 = new Exam(1, 10, "Fisolosia", p1, er1);
        Exam e2 = new Exam(2, 2, "Ginnastica", p2, er2);
        // 5) Iscrivere tutti e 3 gli studenti agli esami
        e1.registerStudent(s1);
        e1.registerStudent(s2);
        e1.registerStudent(s3);
        e2.registerStudent(s1);
        e2.registerStudent(s2);
        e2.registerStudent(s3);
        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(e1);
        System.out.println(e2);
    }
}
