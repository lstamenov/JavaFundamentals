import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        System.out.println(getArea(height, width));
    }

    private static int getArea(int height, int width) {
        return height * width;
    }
}
