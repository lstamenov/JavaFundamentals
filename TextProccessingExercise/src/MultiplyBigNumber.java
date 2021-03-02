import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfDigits = new ArrayList<>();
        String numbers = scanner.nextLine();
        int count = 0;
        int remainValue = 0;
        while (numbers.length() > count){
            listOfDigits.add(Integer.parseInt(String.valueOf(numbers.charAt(count))));
            count++;
        }
        int multiplier = Integer.parseInt(scanner.nextLine());
        count = numbers.length() - 1;
        while (count >= 0){

            int nPositionNumber = listOfDigits.get(count);

            nPositionNumber *= multiplier;
            nPositionNumber += remainValue;

            if (nPositionNumber > 9){
                listOfDigits.set(count, nPositionNumber % 10);
                remainValue = nPositionNumber / 10;
                if (count == 0) {
                    listOfDigits.add(0, remainValue);
                }
            }else {
                listOfDigits.set(count, nPositionNumber);
                remainValue = 0;
            }
            count--;
        }
        for (int n : listOfDigits) {
            System.out.print(n);
        }
    }
}
