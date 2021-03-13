import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemonList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> pokemonRemovedList = new ArrayList<>();

        while (pokemonList.size() > 0){
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0 || index >= pokemonList.size()){

                int value = pokemonList.get(0);

                pokemonRemovedList.add(pokemonList.remove(0));
                pokemonList.add(0, pokemonList.get(pokemonList.size() - 1));

                for (int i = 0; i < pokemonList.size(); i++) {
                    if (pokemonList.get(i) <= value) {
                        pokemonList.set(i, pokemonList.get(i) + value);
                    } else {
                        pokemonList.set(i, pokemonList.get(i) - value);
                    }
                }
            }else {

                int value = pokemonList.remove(index);
                pokemonRemovedList.add(value);

                for (int i = 0; i < pokemonList.size(); i++) {
                    if (pokemonList.get(i) <= value) {
                        pokemonList.set(i, pokemonList.get(i) + value);
                    } else {
                        pokemonList.set(i, pokemonList.get(i) - value);
                        if (pokemonList.get(i) <= 0) {
                            pokemonList.remove(0);
                            pokemonList.set(i, pokemonList.get(pokemonList.size() - 1));
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int n : pokemonRemovedList) {
            sum += n;
        }
        System.out.println(sum);
    }
}
