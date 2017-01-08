import java.util.ArrayList;
import java.util.List;

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
    }
}
