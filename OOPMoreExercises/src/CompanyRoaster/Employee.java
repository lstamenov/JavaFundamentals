package CompanyRoaster;

public class Employee {
    String name;
    double salary;
    String position;
    Department department;
    String email = "n/a";
    int age = -1;

    Employee(String name, double salary, String position, Department department){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",getName(), getSalary(), getEmail(), getAge());
    }
}
