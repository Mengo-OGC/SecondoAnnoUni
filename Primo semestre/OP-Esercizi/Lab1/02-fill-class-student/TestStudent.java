class TestStudent {

    public static void main(String[] args) {
        Student alex = new Student();
        alex.build("alex", "Balducci", 1015, 2019);    
        alex.printStudentInfo();
        Student angel = new Student();
        angel.build("angel", "Bianchi", 1016, 2018);
        angel.printStudentInfo();
        Student andrea = new Student();
        andrea.build("andrea", "Bracci", 1017, 2017);
        andrea.printStudentInfo();
    }
}
