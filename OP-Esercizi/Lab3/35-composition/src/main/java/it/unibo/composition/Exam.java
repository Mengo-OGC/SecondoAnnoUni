package it.unibo.composition;

//import java.lang.reflect.Array;

public class Exam {
    private final int id;
    private final int maxStudents;
    private final String courseName;
    private int registeredStudents;
    private Professor professor;
    private ExamRoom room;
    private Student[] students;

    public Exam(
        final int id,
        final int maxStudents,
        final String courseName, 
        final Professor professor,
        final ExamRoom room
    ) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[maxStudents];
    }

    public int getId() {
        return this.id;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public int getRegisteredStudents() {
        return this.registeredStudents;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public ExamRoom getExamRoom(){
        return this.room;
    }

    public Student[] getStudents() {
        return students.clone();
    }

    public void registerStudent(Student s) {
        if (this.registeredStudents < this.maxStudents) {
            this.students[this.registeredStudents] = s;
            this.registeredStudents++;
        }
    }

    @Override
    public String toString() {
        return "Exam [ Id: " + this.id + 
               ", Corse name: " + this.courseName + 
               ", Porfessor: " + this.professor + 
               ", Max Students: " + this.maxStudents + 
               ", Registered Students: " + this.registeredStudents + 
               ", Exam Room: " + this.room + 
               ", " + students.toString() + "]";

    }
}
