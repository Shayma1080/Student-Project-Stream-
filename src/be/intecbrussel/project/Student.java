package be.intecbrussel.project;

public class Student extends Person{
    private static int incrementId;
    static int id=1;

    public Student() {
        getIncrementId();
    }

    public Student(String name, String lastName) {
        super(name, lastName);
    }

    public static int getIncrementId() {
        return  id +=incrementId;
    }

    public static int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{}";
    }
}
