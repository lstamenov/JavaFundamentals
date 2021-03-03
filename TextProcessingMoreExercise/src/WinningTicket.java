import java.util.Scanner;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOfTickets = scanner.nextLine().split("[\\s,]+");

        for (String ticket : arrayOfTickets) {
            if (ticket.length() != 20){
                System.out.println("invalid ticket");
            }else {
                int numberOfMatchesInARow = getNumberOfMatches(ticket);
                if (numberOfMatchesInARow > 5 && numberOfMatchesInARow < 10){
                    char sym = getSymbol(ticket);
                    System.out.printf("ticket \"%s\" - %d%c%n",ticket, numberOfMatchesInARow, sym);
                }else if (numberOfMatchesInARow > 9){
                    char sym = getSymbol(ticket);
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",ticket, numberOfMatchesInARow, sym);
                }else {
                    System.out.printf("ticket \"%s\" - no match",ticket);
                }
            }
        }
    }

    private static char getSymbol(String ticket) {
        for (int i = 0; i < ticket.length(); i++) {
            if (isMatch(ticket.charAt(i))){
                return ticket.charAt(i);
            }
        }
        return 'n';
    }

    private static int getNumberOfMatches(String ticket) {
        String firstHalf = "";
        String secondHalf = "";

        int counter = 0;

        while (counter < 10){
            firstHalf += ticket.charAt(counter);
            counter++;
        }
        while (counter < 20){
            secondHalf += ticket.charAt(counter);
            counter++;
        }
        int counterMatchesFirst = 1;
        for (int i = 0; i < firstHalf.length() - 1; i++) {
            if (isMatch(firstHalf.charAt(i)) && isMatch(firstHalf.charAt(i + 1))){
                counterMatchesFirst++;
            }
        }
        int counterMatchesSecond = 1;
        for (int i = 0; i < secondHalf.length() - 1; i++) {
            if (isMatch(secondHalf.charAt(i)) && isMatch(secondHalf.charAt(i + 1))){
                counterMatchesSecond++;
            }
        }
        if(counterMatchesFirst == counterMatchesSecond){
            return counterMatchesFirst;
        }else {
            return 0;
        }
    }

    private static boolean isMatch(char charAt) {
        return charAt == '@' || charAt == '#' || charAt == '$';
    }
}
