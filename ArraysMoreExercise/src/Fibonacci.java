import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        if (n == 1 || n == 2){
            System.out.println("1");
        }else {
            int[] fibonacciArray = {1,1};
            for (int i = 2; i < n; i++) {
                int[] newArray = new int[fibonacciArray.length + 1];
                for (int j = 0; j < fibonacciArray.length; j++) {
                    newArray[j] = fibonacciArray[j];
                }
                newArray[newArray.length - 1] = fibonacciArray[fibonacciArray.length - 1] + fibonacciArray[fibonacciArray.length - 2];
                fibonacciArray = newArray;
            }
            System.out.println(fibonacciArray[fibonacciArray.length -1]);
        }
    }
}
