import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfTickets = Arrays.stream(scanner.nextLine().split("[, ]+"))
                .collect(Collectors.toList());

        String regex = "[@$#]{6,10}";
        Pattern pattern = Pattern.compile(regex);

        for (String ticket : listOfTickets) {
            if (ticket.length() == 20){

                String firstPart = ticket.substring(0, 10);
                String secondPart = ticket.substring(10, 20);
                Matcher firstMatcher = pattern.matcher(firstPart);
                Matcher secondMatcher = pattern.matcher(secondPart);
                if (firstMatcher.find() && secondMatcher.find()){
                    int length = getLength(firstMatcher, secondMatcher);
                    if (length > 5 && length < 10){
                        if (getSym(firstMatcher.group()) == getSym(secondMatcher.group())) {
                            System.out.printf("ticket \"%s\" - %d%c%n", ticket, length,
                                    getSym(firstMatcher.group()));
                        }
                    }else if (length == 10){
                        System.out.printf("ticket \"%s\" - 10%c Jackpot!%n",ticket
                        ,getSym(firstMatcher.group()));
                    }else {
                        System.out.printf("ticket \"%s\" - no match",ticket);
                    }
                }else {
                    System.out.printf("ticket \"%s\" - no match",ticket);
                }
            }else {
                System.out.println("invalid ticket");
            }
        }
    }

    private static char getSym(String firstMatcher) {
        for (int i = 0; i < firstMatcher.length(); i++) {
            if (firstMatcher.charAt(i) == '@' ||
                    firstMatcher.charAt(i) == '$' ||
                    firstMatcher.charAt(i) == '#'){
                return firstMatcher.charAt(i);
            }
        }
        return '/';
    }

    private static int getLength(Matcher firstMatcher, Matcher secondMatcher) {
        if (firstMatcher.group().length() == secondMatcher.group().length()){
            return firstMatcher.group().length();
        }else if (firstMatcher.group().length() > secondMatcher.group().length()){
            return secondMatcher.group().length();
        }else {
            return firstMatcher.group().length();
        }
    }
}
