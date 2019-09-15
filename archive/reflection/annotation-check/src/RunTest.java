import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        final Class<MyTest> myTestClass = MyTest.class;

        if (myTestClass.isAnnotationPresent(TestClass.class)) {
            final Method[] methods = myTestClass.getMethods();

            for (Method method : methods) {
                final boolean isTestMethod = method.isAnnotationPresent(Test.class);

                if (isTestMethod) {
                    final Test testAnnotation = method.getAnnotation(Test.class);

                    if (testAnnotation.enabled()) {
                        method.invoke(myTestClass.newInstance());
                    }
                }
            }
        }
    }
}