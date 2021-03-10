import java.util.Scanner;

public class GreaterValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        switch (input){
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println(biggerInteger(a, b));
                break;
            case "char":
                char c = scanner.nextLine().charAt(0);
                char d = scanner.nextLine().charAt(0);
                System.out.println(biggerChar(c, d));
                break;
            case "string":
                String e = scanner.nextLine();
                String f = scanner.nextLine();
                System.out.println(biggerString(e, f));
        }
    }

    private static String biggerString(String e, String f) {
        if (e.compareTo(f) >= 0){
            return e;
        }else {
            return f;
        }
    }

    private static char biggerChar(char c, char d) {
        if (c > d){
            return c;
        }else {
            return d;
        }
    }

    private static int biggerInteger(int a, int b) {
        if (a > b){
            return a;
        }else {
            return b;
        }
    }
}
