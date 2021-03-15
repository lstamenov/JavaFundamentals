package Article2;

import OpinionPoll.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] articleData = scanner.nextLine().split(",");
            String title = articleData[0];
            String content = articleData[1];
            String author = articleData[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String criteria = scanner.nextLine();

        switch (criteria) {
            case "title" -> articles.stream()
                    .sorted((e1, e2) -> e1.getTitle().compareTo(e2.getTitle()))
                    .forEach(article -> System.out.println(article.toString()));
            case "content" -> articles.stream()
                    .sorted((e1, e2) -> e1.getContent().compareTo(e2.getContent()))
                    .forEach(article -> System.out.println(article.toString()));
            case "author" -> articles.stream()
                    .sorted((e1, e2) -> e1.getAuthor().compareTo(e2.getAuthor()))
                    .forEach(article -> System.out.println(article.toString()));
        }
    }
}
