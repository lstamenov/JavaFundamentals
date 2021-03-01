import java.util.Scanner;

public class MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());

        for (int i = numTwo; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n",number,numTwo,number*numTwo);
            numTwo++;
        }
        if (numTwo>11){
            System.out.printf("%d X %d = %d%n",number,numTwo,number*numTwo);
        }
    }
}