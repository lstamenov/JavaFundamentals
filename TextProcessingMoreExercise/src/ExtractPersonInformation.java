import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String name = "";
        int age = 0;

        for (int i = 0; i < n; i++) {
            String[] sentence = scanner.nextLine().split("\\s+");
            name = "";
            age = 0;

            for (String word : sentence) {
                if (word.charAt(0) == '@') {
                    name = getName(word);
                } else if (word.charAt(0) == '#') {
                    age = getAge(word);
                }
            }
            System.out.printf("%s is %d years old.%n", name, age);
        }
    }

    private static int getAge(String word) {
        String ageAsString = "";
        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) == '#' || word.charAt(i) == '*')){
                ageAsString += word.charAt(i);
            }
        }
        return Integer.parseInt(ageAsString);
    }

    private static String getName(String word) {
        String name = "";

        for (int i = 0; i < word.length(); i++) {
            if (!(word.charAt(i) == '@' || word.charAt(i) == '|')){
                name += word.charAt(i);
            }
        }
        return name;
    }
}
