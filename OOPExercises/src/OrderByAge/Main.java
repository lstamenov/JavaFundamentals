package OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] personData = input.split("\\s+");
            String name = personData[0];
            String id = personData[1];
            int age = Integer.parseInt(personData[2]);

            Person person = new Person(name, id, age);
            people.add(person);


            input = scanner.nextLine();
        }
        people.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(person -> System.out.println(person.toString()));
    }
}
