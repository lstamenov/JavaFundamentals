import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(getMiddleChar(input));
    }

    private static String getMiddleChar(String input) {
        String mid = "";
        if (input.length() % 2 == 0){
            mid += input.charAt((input.length()/2) - 1);
            mid += input.charAt((input.length()/2));
        }else {
            mid += input.charAt((input.length()/2));
        }
        return mid;
    }
}
