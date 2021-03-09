package SnowWhite;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dwarf> dwarvesList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Once upon a time")){
            String[] dwarfData = input.split(" <:> ");

            String name = dwarfData[0];
            String hatColour = dwarfData[1];
            int physics = Integer.parseInt(dwarfData[2]);

            Dwarf dwarf = new Dwarf(name, hatColour, physics);


            if (contain(dwarf.getName(), dwarvesList)) {
                for (Dwarf d : dwarvesList) {
                    if (d.getName().equals(dwarf.getName())) {
                        if (d.getHatColour().equals(dwarf.getHatColour())) {
                            if (d.getPhysics() < dwarf.getPhysics()) {
                                d.setPhysics(physics);
                                break;
                            }
                        } else {
                            dwarvesList.add(dwarf);
                            break;
                        }
                    }
                }
            }else {
                dwarvesList.add(dwarf);
            }
            input = scanner.nextLine();
        }
        dwarvesList.stream()
                .sorted((Comparator.comparing(Dwarf::getPhysics).reversed().thenComparing(Dwarf::getHatColour)))
                .forEach(d -> System.out.println(d.toString()));
    }

    private static boolean contain(String name, List<Dwarf> dwarvesList) {
        for (Dwarf d : dwarvesList) {
            if (d.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
