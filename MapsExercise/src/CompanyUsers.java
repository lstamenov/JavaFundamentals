import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companyData = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] data = input.split(" -> ");
            String company = data[0];
            String userID = data[1];


            if (companyData.containsKey(company)){
                List<String> id = companyData.get(company);
                if (!id.contains(userID)) {
                    id = companyData.get(company);
                    id.add(userID);
                }
            }else {
                List<String> id = new ArrayList<>();
                id.add(userID);
                companyData.put(company, id);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String,List<String>> e: companyData.entrySet()) {
            System.out.println(e.getKey());
            for (String id : e.getValue()) {
                System.out.println("-- " + id);
            }
        }
    }
}
