package patterns.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        final SummerVisitor summerVisitor = new SummerVisitor();

        final Pepsi pepsi = new Pepsi(10d);
        final HotChocolate hotChocolate = new HotChocolate(20d);

        System.out.println("Pepsi's summer price is: " + pepsi.getPrice());
        System.out.println("Pepsi's summer price is: " + pepsi.accept(summerVisitor));
        System.out.println("Hot chocolate's summer price is: " + hotChocolate.getPrice());
        System.out.println("Hot chocolate's summer price is: " + hotChocolate.accept(summerVisitor));
    }
}
