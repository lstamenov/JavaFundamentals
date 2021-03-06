import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] data = input.split(" : ");
            String course = data[0];
            String courseStudents = data[1];

            if (courses.containsKey(course)){
                List<String> newCourseStudents = courses.get(course);
                newCourseStudents.add(courseStudents);
                courses.put(course, newCourseStudents);
            }else {
                List<String> courseStudent = new ArrayList<>();
                courseStudent.add(courseStudents);
                courses.put(course, courseStudent);
            }

            input = scanner.nextLine();
        }
        courses.entrySet().stream().
                sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n",entry.getKey(), entry.getValue().size());
                    Collections.sort(entry.getValue());
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.println("-- " + entry.getValue().get(i));
                    }
                });
    }
}
