import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] dnaSequence = new int[n];

        String input = scanner.nextLine();

        int longestSequence = Integer.MIN_VALUE;
        int biggestSum = Integer.MIN_VALUE;
        int bestSampleIndex = Integer.MAX_VALUE;
        int[] winSequence = new int[dnaSequence.length];
        int leftMostIndex = Integer.MAX_VALUE;
        int indexSample = 0;
        while (!input.equals("Clone them!")){
            int leftIndex = -1;
            int counter = 0;
            indexSample++;
            dnaSequence = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < dnaSequence.length; i++) {
                for (int j = 1; j < dnaSequence.length; j++) {
                    if (dnaSequence[i] == dnaSequence[j] && dnaSequence[i] == 1){
                        counter++;
                        i++;
                        leftIndex = (j - counter) + 1;
                    }else {
                        i++;
                    }
                }
            }

            if (counter == longestSequence) {
                if (leftIndex == leftMostIndex) {
                    if (getSum(dnaSequence) > getSum(winSequence)){
                        biggestSum = getSum(dnaSequence);
                        bestSampleIndex = indexSample;
                        winSequence = dnaSequence;
                        leftMostIndex = leftIndex;
                    }
                }else if (leftIndex < leftMostIndex){
                    biggestSum = getSum(dnaSequence);
                    bestSampleIndex = indexSample;
                    winSequence = dnaSequence;
                    leftMostIndex = leftIndex;
                }
            }else if (counter > longestSequence){
                longestSequence = counter;
                biggestSum = getSum(dnaSequence);
                bestSampleIndex = indexSample;
                winSequence = dnaSequence;
                leftMostIndex = leftIndex;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",bestSampleIndex, biggestSum);
        for (int m : winSequence) {
            System.out.print(m + " ");
        }
    }
    static int getSum(int[] array){
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }
}
