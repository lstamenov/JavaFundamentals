
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> trainWagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] commands = input.split(" ");

            if (commands[0].equals("Add")){
                int pass = Integer.parseInt(commands[1]);
                if (Integer.parseInt(commands[1]) > capacity){
                    pass = capacity;
                }
                trainWagons.add(pass);
            }else {
                int passengersToFit = Integer.parseInt(commands[0]);
                for (int i = 0; i < trainWagons.size(); i++) {
                    if (trainWagons.get(i) + passengersToFit <= capacity){
                        passengersToFit += trainWagons.get(i);
                        trainWagons.set(i, passengersToFit);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int n : trainWagons) {
            System.out.print(n + " ");
        }
    }
}
