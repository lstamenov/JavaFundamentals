package Students;

public class Student {
    String firstName;
    String lastName;
    double grade;

    Student(String firstName, String lastName, double grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f",getFirstName(), getLastName(), getGrade());
    }
}
