import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayWithLambda {
    public static void main(String[] args) {
        final List numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);

        numbers.stream()
                .filter(p -> ((Integer) p % 2) == 0)
                .forEach(System.out::println);

        numbers.stream()
                .map(p -> {
                    int num = (Integer) p;
                    return num * num;
                })
                .map(p -> p.toString() + " ")
                .forEach(System.out::print);
        System.out.println();

        final List numbersAreEven = (List) numbers.stream()
                .map(p -> (Integer) p % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        numbersAreEven.stream()
                .map(val -> val + " ")
                .forEach(System.out::print);
    }
}
