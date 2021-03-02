import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (isValidUsername(username) && isValidLength(username)){
                System.out.println(username);
            }
        }
    }

    private static boolean isValidUsername(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (!(Character.isDigit(username.charAt(i)) ||
                    isLetter(username.charAt(i)) ||
                    username.charAt(i) == '-' || username.charAt(i) == '_')){
                return false;
            }
        }
        return true;
    }
    private static boolean isLetter(char charAt){
        return (charAt > 64 && charAt < 91) || (charAt > 96 && charAt < 123);
    }
    private static boolean isValidLength(String username){
        return username.length() > 2 && username.length() < 17;
    }
}

