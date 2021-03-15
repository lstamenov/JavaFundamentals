package Students2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Students> students = new ArrayList<>();
        String input = scanner.nextLine();
        while(!input.equals("end")){
            String[] studentData = input.split("\\s+");

            String firstName = studentData[0];
            String lastName = studentData[1];
            int age = Integer.parseInt(studentData[2]);
            String hometown = studentData[3];

            Students student = new Students(firstName, lastName, age, hometown);

            if (!isUnique(firstName, lastName, students)) {
                for (Students s : students) {
                    if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                        s.setAge(age);
                        s.setHometown(hometown);
                    }
                }
            }else {
                students.add(student);
            }
            input = scanner.nextLine();
        }
        String town = scanner.nextLine();

        students.stream()
                .filter(student -> student.getHometown().equals(town))
                .forEach(student -> System.out.println(student.toString()));
    }

    private static boolean isUnique(String firstName, String lastName, List<Students> students) {
        for (Students s : students) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                return false;
            }
        }
        return true;
    }
}
