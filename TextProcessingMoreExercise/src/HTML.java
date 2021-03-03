import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String article = scanner.nextLine();
        String content = scanner.nextLine();
        List<String> commentsList = new ArrayList<>();

        String comment = scanner.nextLine();
        while (!comment.equals("end of comments")){
            commentsList.add(comment);
            comment = scanner.nextLine();
        }
        System.out.println("<h1>");
        System.out.println("    " + article);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("    " + content);
        System.out.println("</article>");
        for (String comments : commentsList) {
            printComment(comments);
        }
    }
    static void printComment(String comment){
        System.out.println("<div>");
        System.out.println("    " + comment);
        System.out.println("</div>");
    }
}
