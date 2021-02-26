import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        if (word.equals(word.toUpperCase())){
            System.out.println("upper-case");
        }else if (word.equals(word.toLowerCase())){
            System.out.println("lower-case");
        }
    }
}
