import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsInformation = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            List<Double> grades;
            if (studentsInformation.containsKey(name)){
                grades = studentsInformation.get(name);
            }else {
                grades = new ArrayList<>();
            }
            grades.add(grade);
            studentsInformation.put(name, grades);
        }
        Map<String, Double> averageGrades = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> e : studentsInformation.entrySet()) {
            double average = e.getValue().stream().mapToDouble((x) -> x).average().getAsDouble();
            if (average >= 4.50){
                averageGrades.put(e.getKey(), average);
            }
        }
        averageGrades.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey(), e.getValue()));
    }
}
