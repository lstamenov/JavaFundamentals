import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        if (isZero(n1, n2, n3)){
            System.out.println("zero");
        }else {
            if ((getSign(n1) + getSign(n2) + getSign(n3)) % 2 == 0){
                System.out.println("positive");
            }else {
                System.out.println("negative");
            }
        }
    }

    private static boolean isZero(int n1, int n2, int n3) {
        return n1 == 0 || n2 == 0 || n3 == 0;
    }

    private static int getSign(int n1) {
        if (n1 < 0){
            return 1;
        }else {
            return 0;
        }
    }
}
