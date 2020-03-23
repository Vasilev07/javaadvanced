import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface Testannotation
{
    String Developer() default "Joro";
    String ExpiryDate();
}
// will be retained at a runtime

public class CustomAnnotationsExample {
    @Testannotation(Developer = "Joro2", ExpiryDate = "01-01-2020")
    public void fun1()
    {
        System.out.println("Test method 1");
    }

    @Testannotation(Developer = "Joro3", ExpiryDate = "02-01-2020")
    public void fun2()
    {
        System.out.println("Test method 3");
    }

    public static void main(String args[])
    {
        System.out.println("Hello");
    }
}
