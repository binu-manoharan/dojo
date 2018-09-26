package staticfactory;

public class Foo {
    private int fooValue;
    
    private Foo(int fooValue) {
	this.fooValue = fooValue;
    }

    public static Foo of(int fooValue) {
	return new Foo(fooValue);
    }

    public int getFooValue() {
	return this.fooValue;
    }
}
