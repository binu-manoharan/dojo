package staticfactory;

public class FooTest {
    public static void main(String args[]) {
	Foo foo = Foo.of(10);
	System.out.println("fooValue is: " + foo.getFooValue());
    }
}
