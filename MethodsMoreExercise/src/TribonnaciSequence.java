import java.util.Scanner;

public class TribonnaciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printNumbers(n);
    }

    private static void printNumbers(int n) {
        if (n == 1){
            System.out.println("1");
        }else if (n == 2){
            System.out.println("1 1");
        }else if (n == 3){
            System.out.println("1 1 2");
        }else {
            int[] tribonacciArray = {1, 1, 2};
            for (int i = 3; i < n; i++) {
                int[] array = get(tribonacciArray);
                array[i] = tribonacciArray[i - 3] + tribonacciArray[i - 2] + tribonacciArray[i - 1];
                tribonacciArray = array;
            }
            for (int a : tribonacciArray) {
                System.out.print(a + " ");
            }
        }
    }

    private static int[] get(int[] tribonacciArray) {
        int[] array = new int[tribonacciArray.length + 1];
        for (int i = 0; i < tribonacciArray.length; i++) {
            array[i] = tribonacciArray[i];
        }
        return array;
    }
}
