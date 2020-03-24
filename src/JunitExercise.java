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

    public int someSmartMethodThatReturnZero() {
        return 0;
    }
}

class TestExample {
    TestedClass mocked = new TestedClass();
    Assetions assertionLibrary = new Assetions();

    // should fail because we are returning Gosho from tested Class
    @Test
    void testA()
    {
        assertionLibrary.assertEquals("NotGosho", mocked.someMethodThatReturnString());
    }

    // should pass because we are returning Gosho from tested Class
    @Test
    void testB()
    {
        assertionLibrary.assertEquals("Gosho", mocked.someMethodThatReturnString());
    }

    // should be skipped
    @Test(skip = true)
    void testC()
    {

    }

    // should fail because we are expecting 1 to equal 0
    @Test
    void testSomeSmartMethodThatReturnZeroFail()
    {
        assertionLibrary.assertEquals(1, mocked.someSmartMethodThatReturnZero());
    }

    // should pass because we are expecting 0 to equal 0
    @Test
    void testSomeSmartMethodThatReturnZeroPass()
    {
        assertionLibrary.assertEquals(0, mocked.someSmartMethodThatReturnZero());
    }

    // should fail because passed falue is true
    @Test
    void testIfAssumeTrueFail()
    {
        assertionLibrary.assumeTrue(mocked.someMethodThatReturnString().contains("T"));
    }

    @Test
    void testIfAssumeTruePass()
    {
        assertionLibrary.assumeTrue(mocked.someMethodThatReturnString().contains("G"));
    }

    @Test
    void testIfFailFail()
    {
        assertionLibrary.assumeTrue(mocked.someMethodThatReturnString().contains("G"));
        assertionLibrary.fail("this will always fail");
    }
}

class Assetions {
    public void assertEquals(int value, int methodResult) {
        if (value != methodResult) {
            throw new RuntimeException("Expected value is not equal to result");
        }
    }

    public void assertEquals(String value, String methodResult) {
        if (value != methodResult) {
            throw new RuntimeException("Expected value is not equal to result");
        }
    }

    public void assumeTrue(boolean value) {
        if (!value) {
            throw new RuntimeException("Expected value is not equal to true");
        }
    }

    public void fail(String errorMessage)
    {
        throw new RuntimeException(errorMessage);
    }
}

class RunTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing...");
        int passed = 0;
        int failed = 0;
        int count = 0;
        int ignore = 0;

        TestExample testSuiteToRun = new TestExample();

        Class testSuiteToRunReflection = testSuiteToRun.getClass();

        // iterate over class methods
        for (Method method : testSuiteToRunReflection.getDeclaredMethods())
            if(method.isAnnotationPresent(Test.class))
            {
                Annotation annotation = method.getAnnotation(Test.class);
                Test test = (Test)annotation;

                if (!test.skip())
                {
                    try {
                        method.invoke(testSuiteToRunReflection.newInstance());
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