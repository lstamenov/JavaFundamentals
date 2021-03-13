
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> arrayList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] commands = input.split(" ");
            String command = commands[0];
            if (command.equals("Delete")){
                int element = Integer.parseInt(commands[1]);
                for (int i = 0; i < arrayList.size() ; i++) {
                    if (arrayList.get(i) == element){
                        arrayList.remove(i);
                        i--;
                    }
                }
            }else {
                int number = Integer.parseInt(commands[1]);
                int index = Integer.parseInt(commands[2]);
                arrayList.add(index, number);
            }
            input = scanner.nextLine();
        }
        for (int n : arrayList) {
            System.out.print(n + " ");
        }
    }
}
