package Students;

public class Student {
    String firstName;
    String lastName;
    int age;
    String hometown;

    Student(String firstName, String lastName, int age, String hometown){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hometown = hometown;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old."
                ,getFirstName(), getLastName(), getAge());
    }
}
