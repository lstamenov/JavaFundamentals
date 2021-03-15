package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] studentData = scanner.nextLine().split("\\s+");
            String firstName = studentData[0];
            String lastName = studentData[1];
            double grade = Double.parseDouble(studentData[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
        students.stream()
                .sorted((e1, e2) -> Double.compare(e2.getGrade(), e1.getGrade()))
                .forEach(student -> System.out.println(student.toString()));
    }
}
