import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> arrayList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("3:1")){
            String[] data = input.split("\\s+");
            String command = data[0];
            int startIndex = Integer.parseInt(data[1]);
            int endIndex = Integer.parseInt(data[2]);

            if (startIndex < 0){
                startIndex = 0;
            }
            if (endIndex >= arrayList.size()){
                endIndex = arrayList.size() - 1;
            }

            if (command.equals("merge")){String newIndex = "";
                for (int i = startIndex; i <= endIndex; i++) {
                    newIndex += arrayList.get(i);
                    arrayList.remove(i);
                    i--;
                    endIndex--;
                }
                arrayList.add(startIndex, newIndex);
            }else if (command.equals("divide")){
                int index = Integer.parseInt(data[1]);
                int partitions = Integer.parseInt(data[2]);
                if (index >= 0 && index < arrayList.size()) {
                    int length = arrayList.get(index).length();
                    String sequence = arrayList.get(index);
                    int subsCount = 0;
                    arrayList.remove(index);

                    if (length % 2 == 0){
                        String word = "";
                        while (subsCount < partitions){
                            for (int i = 0; i < length; i++) {
                                word += sequence.charAt(i);
                                if (i % 2 != 0){
                                    arrayList.add(index + subsCount, word);
                                    subsCount++;
                                    word = "";
                                }
                            }
                        }
                    }else {
                        int charsPerString = length/partitions;
                        String word = "";
                        while (subsCount < partitions){
                            for (int i = 0; i < length; i++) {
                                word += sequence.charAt(i);

                                if((i + 1) % charsPerString == 0 && subsCount + 1 < partitions){
                                    arrayList.add(index + subsCount, word);
                                    subsCount++;
                                    word = "";
                                }else if(i % 2 == 0 && i + 1 == length) {
                                    arrayList.add(index + subsCount, word);
                                    subsCount++;
                                }
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(" ", arrayList));
    }
}
