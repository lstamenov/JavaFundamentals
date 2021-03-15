package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleData = scanner.nextLine().split(",");
        Article article = new Article(articleData[0],articleData[1],articleData[2]);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandData = scanner.nextLine().split(": ");
            String command = commandData[0];
            String newValue = commandData[1];

            switch (command) {
                case "ChangeAuthor" -> article.setAuthor(newValue);
                case "Edit" -> article.setContent(newValue);
                case "Rename" -> article.setTitle(newValue);
            }
        }
        System.out.println(article.toString());
    }
}
