package it.unibo.composition;

public class Professor implements User {
    private static final String SEPARETOR_USERNAME = " ";

    private final int id;
    private final String name;
    private final String surname;
    private String password;
    private String[] courses;

    public Professor(
        final int id,
        final String name,
        final String surname,
        final String password,
        final String[] courses
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = courses;
    }

    public void replaceCource(final String newCource, final int idx) {
        this.courses[idx] = newCource;
    }

    public void replaceAllCources(String[] newCources) {
        for (int i = 0; i < this.courses.length; i++) {
            replaceCource(newCources[i], i);
        }
    }

    @Override
    public String toString() {
        String s = "Professor: " + getUsername() +
            ", Password: " + getPassword() + 
            ", Id: " + this.id + 
            ", Corsi: \n";
        for (String course: courses) {
            s = s + course + "\n";
        }
        return s;
    }

    @Override
    public String getUsername() {
        return this.name + SEPARETOR_USERNAME + this.surname;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getDescription() {
        return this.toString();
    }
}
