import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    public boolean skip() default false;
}

class TestedClass {
    String gosho = "Gosho";

    public String someMethodThatReturnString() {
        return this.gosho;
    }
}

class TestExample {
    TestedClass mocked = new TestedClass();
    Assetions assertionLibrary = new Assetions();

    // should fail because we are returning Gosho from tested Class
    @Test
    void testA() {
        assertionLibrary.assertEqualStrings("NotGosho", mocked.someMethodThatReturnString());
    }

    // should pass because we are returning Gosho from tested Class
    @Test
    void testB() {
        assertionLibrary.assertEqualStrings("Gosho", mocked.someMethodThatReturnString());
    }

    // should be skipped
    @Test(skip = true)
    void testC() {

    }
}

class Assetions {
    public void assertEqualIntegers(int value, int methodResult) {
        if (value != methodResult) {
            throw new RuntimeException("Expected value is not equla to result");
        }
    }

    public void assertEqualStrings(String value, String methodResult) {
        if (value != methodResult) {
            throw new RuntimeException("Expected value is not equla to result");
        }
    }
}

class RunTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing...");
        int passed = 0;
        int failed = 0;
        int count = 0;
        int ignore = 0;

        Class<TestExample> tests = TestExample.class;

        // iterate over class methods
        for (Method method : tests.getDeclaredMethods())
            if(method.isAnnotationPresent(Test.class))
            {
                Annotation annotation = method.getAnnotation(Test.class);
                Test test = (Test)annotation;

                if (!test.skip())
                {
                    try {
                        method.invoke(tests.newInstance());
                        System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
                        passed++;
                    } catch (Throwable ex) {
                        System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
                        failed++;
                    }
                } else {
                    ignore++;
                }
            }
        System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);
    }
}