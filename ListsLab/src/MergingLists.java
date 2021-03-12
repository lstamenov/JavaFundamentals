import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> list2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> mergedList = merge(list1, list2);

        for (int n : mergedList) {
            System.out.print(n + " ");
        }
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();

        while (list1.size() > 0 || list2.size() > 0){
            if (list1.size() > 0 && list2.size() > 0){
                merged.add(list1.get(0));
                merged.add(list2.get(0));
                list1.remove(0);
                list2.remove(0);
            }else if (list1.size() > 0){
                merged.add(list1.get(0));
                list1.remove(0);
            }else {
                merged.add(list2.get(0));
                list2.remove(0);
            }
        }
        return merged;
    }
}
