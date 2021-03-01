import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String country = sc.nextLine();
        switch (country){
            case "Spain","Argentina","Mexico":
                System.out.println("Spanish");
                break;
            case "USA","England":
                System.out.println("English");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
