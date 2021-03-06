import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> registerParking = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String command = data[0];
            String user = data[1];


            if (command.equals("register")) {
                String plate = data[2];
                if (!registerParking.containsKey(user)){
                    registerParking.put(user, plate);
                    System.out.printf("%s registered %s successfully%n",
                            user, plate);
                }else {
                    System.out.printf("ERROR: already registered with plate number %s%n",plate);
                }
            }else if (command.equals("unregister")){

                if (!registerParking.containsKey(user)){
                    System.out.printf("ERROR: user %s not found%n",user);
                }else {
                    registerParking.remove(user);
                    System.out.printf("%s unregistered successfully%n",user);
                }
            }
        }
        registerParking.entrySet().forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
    }
}
