import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayWithLambda {
    public static void main(String[] args) {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);

        numbers.stream()
                .filter(p -> (p % 2) == 0)
                .forEach(System.out::println);

        numbers.stream()
                .map(p -> {
                    int num = p;
                    return num * num;
                })
                .map(p -> p.toString() + " ")
                .forEach(System.out::print);
        System.out.println();

        final List<Boolean> numbersAreEven = numbers.stream()
                .map(p -> p % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        numbersAreEven.stream()
                .map(val -> val + " ")
                .forEach(System.out::print);
    }
}
