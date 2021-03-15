package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Songs> songs = new ArrayList<>();
        
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] array = input.split("_");
            String type = array[0];
            String name = array[0];
            String time = array[0];
            
            Songs song = new Songs(type, name, time);
            songs.add(song);
        }
        String typeToShow = scanner.nextLine();

        for (Songs song : songs) {
            if (song.getType().equals(typeToShow)){
                System.out.println(song.getName());
            }
        }
    }
}
