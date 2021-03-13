import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int bombIndex = numbers.indexOf(nums[0]);
        int power = nums[1];
        int bombNumber = nums[0];

        while (numbers.contains(bombNumber)){
            if (bombIndex + power >= numbers.size()){
                for (int i = bombIndex + 1; i < numbers.size(); i++) {
                    numbers.remove(i);
                    i--;
                }
            }else {
                int indexDelete = bombIndex + power;
                for (int i = bombIndex + 1; i <= indexDelete; i++) {
                    numbers.remove(i);
                    indexDelete--;
                    i--;
                }
            }
            if (bombIndex - power >= 0){
                int indexDelete = bombIndex - power;
                for (int i = bombIndex; i >= indexDelete ; i--) {
                    numbers.remove(i);
                }
            }else {
                for (int i = bombIndex; i >= 0 ; i--) {
                    numbers.remove(i);
                }
            }
        }
        System.out.println(getSum(numbers));
    }

    private static int getSum(List<Integer> numbers) {
        int sum = 0;
        for ( int n : numbers) {
            sum += n;
        }
        return sum;
    }
}
