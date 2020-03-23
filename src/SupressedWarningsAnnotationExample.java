class DeprecatedTest
{
    @java.lang.Deprecated
    public void Display()
    {
        System.out.println("this method is Deprecated");
    }
}

public class SupressedWarningsAnnotationExample {
    public static void main(String args[])
    {
        DeprecatedTest d1 = new DeprecatedTest();
        d1.Display();
    }
}
