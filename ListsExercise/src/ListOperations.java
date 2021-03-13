import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command){
                case "Add":
                    int number = Integer.parseInt(commands[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(commands[1]);
                    int index = Integer.parseInt(commands[2]);
                    if (index >= 0 && index < numbers.size()){
                        numbers.add(index, number);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < numbers.size()){
                        numbers.remove(index);
                    }else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count  = Integer.parseInt(commands[2]);

                    if (commands[1].equals("left")){
                        for (int i = 0; i < count; i++) {
                            int oldNum = numbers.get(0);
                            for (int j = 0; j < numbers.size() - 1; j++) {
                                numbers.set(j, numbers.get(j + 1));
                            }
                            numbers.set(numbers.size() - 1, oldNum);
                        }
                    }else {
                        for (int i = 0; i < count; i++) {
                            int oldNum = numbers.get(numbers.size() - 1);
                            for (int j = numbers.size() - 1; j > 0 ; j--) {
                                numbers.set(j, numbers.get(j - 1));
                            }
                            numbers.set(0, oldNum);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
