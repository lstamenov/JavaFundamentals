package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = scanner.nextLine();
        while(!input.equals("end")){
            String[] studentData = input.split("\\s+");

            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String hometown = studentData[3];

            Student student = new Student(firstName, lastName, age, hometown);
            students.add(student);

            input = scanner.nextLine();
        }
        String town = scanner.nextLine();

        for (Student s : students) {
            if (s.getHometown().equals(town)){
                System.out.println(s.toString());
            }
        }
    }
}
