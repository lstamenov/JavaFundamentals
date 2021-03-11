import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        isValid(password);
    }

    private static void isValid(String password) {
        if (password.length() < 6 || password.length() > 10){
            System.out.println("Password must be between 6 and 10 characters");
        } if (!isThereOnlyLettersAndDigits(password)){
            System.out.println("Password must consist only of letters and digits");
        } if (!isThereEnoughDigits(password)){
            System.out.println("Password must have at least 2 digits");
        }
        if (password.length() >= 6 || password.length() <= 10 && isThereEnoughDigits(password)
        && isThereOnlyLettersAndDigits(password)){
            System.out.println("Password is valid");
        }
    }

    private static boolean isThereEnoughDigits(String password) {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))){
                count++;
            }
        }
        return count >= 2;
    }

    private static boolean isThereOnlyLettersAndDigits(String password) {
        Pattern pattern = Pattern.compile("[A-Za-z]");

        for (int i = 0; i < password.length(); i++) {
            String str = "";
            str += password.charAt(i);
            Matcher matcher = pattern.matcher(str);
            if (!matcher.find()){
                if (!Character.isDigit(password.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}
