import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] inputData = input.split("\\s+");
            String command = inputData[0];

            switch (command){
                case "Contains":
                    int number = Integer.parseInt(inputData[1]);
                    if (list.contains(number)){
                        System.out.println("Yes");
                    }else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (inputData[1].equals("even")){
                        for (int n : list) {
                            if (n % 2 == 0){
                                System.out.print(n + " ");
                            }
                        }
                    }else {
                        for ( int n : list) {
                            if (n % 2 != 0){
                                System.out.print(n + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (int n : list) {
                        sum += n;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = inputData[1];
                    number = Integer.parseInt(inputData[2]);

                    if (condition.equals(">=")){
                        for (int n : list) {
                            if (n >= number){
                                System.out.print(n + " ");
                            }
                        }
                    }else if (condition.equals("<=")){
                        for (int n : list) {
                            if (n <= number){
                                System.out.print(n + " ");
                            }
                        }
                    }else if (condition.equals(">")){
                        for (int n : list) {
                            if (n > number){
                                System.out.print(n + " ");
                            }
                        }
                    }else if (condition.equals("<")){
                        for (int n : list) {
                            if (n < number){
                                System.out.print(n + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
