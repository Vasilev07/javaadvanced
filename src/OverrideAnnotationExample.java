public class OverrideAnnotationExample {
    public void Display()
    {
        System.out.println("Base display");
    }

    public static void  main(String args[])
    {
        OverrideAnnotationExample t1 = new Derived();
        t1.Display();
    }
}

class Derived extends OverrideAnnotationExample {

    @Override
    public void Display()
    {
        System.out.println("Derived display()");
    }
}