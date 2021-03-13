import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            String action = data[2];

            if (action.equals("going!")){
                if (names.contains(name)){
                    System.out.println(name + " is already in the list!");
                }else {
                    names.add(name);
                }
            }else {
                if (names.contains(name)){
                    names.remove(name);
                }else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }
        for (String name : names) {
            System.out.println(name);
        }
    }
}
