import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int counter = 0;
        while (firstDeck.size() > 0 && secondDeck.size() > 0){
            if (counter >= firstDeck.size() || counter >= secondDeck.size()){
                counter = 0;
            }
            if (firstDeck.get(counter) > secondDeck.get(counter)){
                int card = firstDeck.remove(counter);
                firstDeck.add(card);
                firstDeck.add(secondDeck.remove(counter));
            }else if (firstDeck.get(counter) < secondDeck.get(counter)){
                int card = secondDeck.remove(counter);
                secondDeck.add(card);
                secondDeck.add(firstDeck.remove(counter));
            }else {
                firstDeck.remove(counter);
                secondDeck.remove(counter);
            }
            counter++;
        }
        int sum = 0;
        if (firstDeck.size() > 0){
            for (int n : firstDeck) {
                sum += n;
            }
            System.out.printf("First player wins! Sum: %d",sum);
        }else {
            for (int n : secondDeck) {
                sum += n;
            }
            System.out.printf("Second player wins! Sum: %d",sum);
        }
    }
}
