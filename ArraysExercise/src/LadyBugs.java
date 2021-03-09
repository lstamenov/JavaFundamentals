import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] ladyBugs = new int[n];

        int[] bugsIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        for (int bugsIndex : bugsIndexes) {
            if (bugsIndex >= 0 && bugsIndex < ladyBugs.length) {
                ladyBugs[bugsIndex] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] data = input.split("\\s+");
            int index = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyLength = Integer.parseInt(data[2]);

            if (index >= 0 && index < ladyBugs.length) {
                if (ladyBugs[index] == 1) {
                    if (direction.equals("right")) {
                        ladyBugs[index] = 0;
                        if (index + flyLength < ladyBugs.length && index + flyLength >= 0) {
                            for (int i = index + flyLength; i < ladyBugs.length; i++) {
                                if (ladyBugs[i] == 0) {
                                    ladyBugs[i] = 1;
                                    break;
                                }
                            }
                        }
                    } else if (direction.equals("left")) {
                        ladyBugs[index] = 0;
                        if (index - flyLength >= 0 && index - flyLength < ladyBugs.length){
                            for (int i = index - flyLength; i >= 0; i--) {
                                if (ladyBugs[i] == 0){
                                    ladyBugs[i] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i : ladyBugs) {
            System.out.print(i + " ");
        }
    }
}
