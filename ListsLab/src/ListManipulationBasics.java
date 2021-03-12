import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list =  Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] inputData = input.split("\\s+");
            String command = inputData[0];
            switch (command){
                case "Add":
                    int number = Integer.parseInt(inputData[1]);
                    list.add(number);
                    break;
                case "Remove":
                    number = Integer.parseInt(inputData[1]);
                    list.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(inputData[1]);
                    list.remove(index);
                    break;
                case "Insert":
                    number = Integer.parseInt(inputData[1]);
                    index = Integer.parseInt(inputData[2]);
                    list.add(index, number);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
