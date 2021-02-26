import java.util.Scanner;

public class CnturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int centuries = Integer.parseInt(scanner.nextLine());

        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = 60 * hours;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",centuries, years, days, hours, minutes);
    }
}
