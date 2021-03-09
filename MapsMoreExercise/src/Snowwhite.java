import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> dwarfs = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")){
            String[] dwarfData = input.split(" <:> ");
            String dwarfName = dwarfData[0];
            String dwarfHatColour = dwarfData[1];
            int dwarfPhysics = Integer.parseInt(dwarfData[2]);

            if (dwarfs.containsKey(dwarfName)){
                if (dwarfs.get(dwarfName).containsKey(dwarfHatColour)){
                    Map<String, Integer> dwarf = dwarfs.get(dwarfName);
                    if (dwarf.get(dwarfHatColour) < dwarfPhysics){
                        dwarf.put(dwarfHatColour, dwarfPhysics);
                        dwarfs.put(dwarfName, dwarf);
                    }
                }else {
                    Map<String, Integer> dwarf = new TreeMap<>();
                    dwarf.put(dwarfHatColour, dwarfPhysics);
                    dwarfs.put(dwarfName, dwarf);
                }
            }else {
                Map<String, Integer> dwarf = new TreeMap<>();
                dwarf.put(dwarfHatColour, dwarfPhysics);
                dwarfs.put(dwarfName, dwarf);
            }

            input = scanner.nextLine();
        }
        dwarfs.entrySet().stream()
                .sorted((e1, e2) -> {
                    Map.Entry<String, Integer> map1 = (Map.Entry<String, Integer>) e1.getValue().entrySet();
                    Map.Entry<String, Integer> map2 = (Map.Entry<String, Integer>) e2.getValue().entrySet();

                    int e1Sort = map1.getValue();
                    int e2Sort = map2.getValue();
                    return Integer.compare(e2Sort, e1Sort);
                }).forEach(e -> System.out.println());
    }
}
//try using second map