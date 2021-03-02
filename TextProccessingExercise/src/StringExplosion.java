import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder line  = new StringBuilder(scanner.nextLine());

        int count = 0;
        int power = 0;
        while (count < line.length()){
           if (line.charAt(count) == '>'){
               power += Integer.parseInt(String.valueOf(line.charAt(count + 1)));
               line.deleteCharAt(count + 1);
               power--;
           }else {
               if (power != 0){
                   for (int i = count; i < count + power; i++) {
                       line.deleteCharAt(i);
                       i--;
                       power--;
                   }
               }
           }
            count++;
        }
        System.out.println(line.toString());
    }
}
