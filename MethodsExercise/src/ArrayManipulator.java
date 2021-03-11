import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayToBeManipulated = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();


        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(commands[1]);

                    if (index >= 0 && index < arrayToBeManipulated.length) {
                        exchange(arrayToBeManipulated, index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (commands[1].equals("even")) {
                        if (maxEven(arrayToBeManipulated) != Integer.MIN_VALUE) {
                            System.out.println(maxEven(arrayToBeManipulated));
                        } else {
                            System.out.println("No matches");
                        }
                    } else if (commands[1].equals("odd")) {
                        if (maxOdd(arrayToBeManipulated) != Integer.MIN_VALUE) {
                            System.out.println(maxOdd(arrayToBeManipulated));
                        } else {
                            System.out.println("No matches");
                        }
                    }
                    break;
                case "min":
                    if (commands[1].equals("even")) {
                        if (minEven(arrayToBeManipulated) != Integer.MIN_VALUE) {
                            System.out.println(minEven(arrayToBeManipulated));
                        } else {
                            System.out.println("No matches");
                        }
                    } else if (commands[1].equals("odd")) {
                        if (minOdd(arrayToBeManipulated) != Integer.MIN_VALUE) {
                            System.out.println(minOdd(arrayToBeManipulated));
                        } else {
                            System.out.println("No matches");
                        }
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(commands[1]);
                    if (count > arrayToBeManipulated.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (commands[2].equals("even")) {
                            printFirstEven(count, arrayToBeManipulated);
                        } else if (commands[2].equals("odd")) {
                            printFirstOdd(count, arrayToBeManipulated);
                        }
                    }
                    break;
                case "last":
                    count = Integer.parseInt(commands[1]);
                    if (count > arrayToBeManipulated.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (commands[2].equals("even")) {
                            printLastEven(count, arrayToBeManipulated);
                        } else if (commands[2].equals("odd")) {
                            printLastOdd(count, arrayToBeManipulated);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(Arrays.toString(arrayToBeManipulated));
    }

    private static void printLastOdd(int count, int[] arrayToBeManipulated) {
        List<Integer> odds = odds(arrayToBeManipulated);

        if (count > odds.size()) {
            count = odds.size();
        }
        int[] array = new int[count];

        int oddsCounter = odds.size() - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = odds.get(oddsCounter);
            oddsCounter--;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void printLastEven(int count, int[] arrayToBeManipulated) {
        List<Integer> evens = evens(arrayToBeManipulated);

        if (count > evens.size()) {
            count = evens.size();
        }
        int[] array = new int[count];

        int evensCounter = evens.size() - 1;
        for (int i = count - 1; i >= 0; i--) {
            array[i] = evens.get(evensCounter);
            evensCounter--;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void printFirstOdd(int count, int[] arrayToBeManipulated) {
        List<Integer> odds = odds(arrayToBeManipulated);
        if (count > odds.size()) {
            count = odds.size();
        }
        int[] arrayOfOdds = new int[count];

        for (int i = 0; i < count; i++) {
            arrayOfOdds[i] = odds.get(i);
        }

        System.out.println(Arrays.toString(arrayOfOdds));
    }

    private static void printFirstEven(int count, int[] arrayToBeManipulated) {
        List<Integer> evens = evens(arrayToBeManipulated);
        if (count > evens.size()) {
            count = evens.size();
        }
        int[] arrayOfEvens = new int[count];

        for (int i = 0; i < count; i++) {
            arrayOfEvens[i] = evens.get(i);
        }
        System.out.println(Arrays.toString(arrayOfEvens));
    }

    private static int minOdd(int[] arrayToBeManipulated) {
        int index = Integer.MIN_VALUE;
        int number = Integer.MIN_VALUE;
        int count = 0;

        List<Integer> odds = odds(arrayToBeManipulated);

        for (int n : odds) {
            for (int m : odds) {
                if (n <= m) {
                    count++;
                    if (count == odds.size()) {
                        number = n;
                    }
                } else {
                    count = 0;
                }
            }
        }
        for (int i = arrayToBeManipulated.length - 1; i >= 0; i--) {
            if (arrayToBeManipulated[i] == number) {
                index = i;
            }
        }
        return index;
    }

    private static int minEven(int[] arrayToBeManipulated) {
        int index = Integer.MIN_VALUE;
        int number = Integer.MIN_VALUE;
        int count = 0;

        List<Integer> evens = evens(arrayToBeManipulated);

        for (int n : evens) {
            for (int m : evens) {
                if (n <= m) {
                    count++;
                    if (count == evens.size()) {
                        number = n;
                    }
                } else {
                    count = 0;
                }
            }
        }

        for (int i = arrayToBeManipulated.length - 1; i >= 0; i--) {
            if (arrayToBeManipulated[i] == number) {
                index = i;
            }
        }
        return index;
    }

    private static List<Integer> evens(int[] arrayToBeManipulated) {
        List<Integer> evens = new ArrayList<>();

        for (int num : arrayToBeManipulated) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens;
    }

    private static int maxOdd(int[] arrayToBeManipulated) {
        int index = Integer.MIN_VALUE;
        int count = 0;
        int number = Integer.MIN_VALUE;
        List<Integer> odds = odds(arrayToBeManipulated);

        for (int n : odds) {
            for (int m : odds) {
                if (n >= m) {
                    count++;
                    if (count == odds.size()) {
                        number = n;
                    }
                } else {
                    count = 0;
                }
            }
        }

        for (int i = arrayToBeManipulated.length - 1; i >= 0; i--) {
            if (arrayToBeManipulated[i] == number) {
                index = i;
            }
        }
        return index;
    }

    private static List<Integer> odds(int[] array) {
        List<Integer> odds = new ArrayList<>();

        for (int n : array) {
            if (n % 2 != 0) {
                odds.add(n);
            }
        }
        return odds;
    }

    private static int maxEven(int[] arrayToBeManipulated) {
        int index = Integer.MIN_VALUE;
        int count = 0;
        int number = Integer.MIN_VALUE;

        List<Integer> even = evens(arrayToBeManipulated);
        for (int n : even) {
            for (int m : even) {
                if (n >= m) {
                    count++;
                    if (count == even.size()) {
                        number = n;
                    }
                } else {
                    count = 0;
                }
            }
        }
        for (int i = arrayToBeManipulated.length - 1; i >= 0; i--) {
            if (arrayToBeManipulated[i] == number) {
                index = i;
            }
        }
        return index;
    }

    private static void exchange(int[] arrayToBeManipulated, int index) {

        List<Integer> splitArray = new ArrayList<>();

        for (int i = 0 ; i <= index ; i++) {
            splitArray.add(arrayToBeManipulated[i]);
        }
        for (int i = index + 1; i < arrayToBeManipulated.length; i++) {
            splitArray.add((i - index) - 1 ,arrayToBeManipulated[i]);
        }
        for (int i = 0; i < arrayToBeManipulated.length; i++) {
            arrayToBeManipulated[i] = splitArray.get(i);
        }
    }
}
