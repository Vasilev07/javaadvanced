import java.lang.annotation.*;

class A
{
    public void showMyDataFromLastYearDatabase()
    {
        System.out.println("IN A");
    }
}

class  B extends A
{
    @Deprecated
    public void show()
    {

    }

    @Override
    public void showMyDataFromLastYearDatabase()
    {
        System.out.println("IN B");
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone
{
    String os() default "Symbian";
    int version() default 1;
}

// override existing value
@SmartPhone(os="Android", version=6)
class NokiaASeries
{
    String model;
    int screenSize;

    public NokiaASeries(String model, int screenSize){
        this.model = model;
        this.screenSize = screenSize;
    }

}

public class Main {
    public static void main(String[] args)
    {
//        B obj = new B();
//        obj.showMyDataFromLastYearDatabase();
//        obj.show();
//
//        NokiaASeries phone = new NokiaASeries("Fire", 5);
//
//        Class c = phone.getClass();
//        Annotation an = c.getAnnotation(SmartPhone.class);
//        SmartPhone s = (SmartPhone)an;
//        System.out.println(s.os());

        OverrideAnnotationExample c = new OverrideAnnotationExample();
    }
}

