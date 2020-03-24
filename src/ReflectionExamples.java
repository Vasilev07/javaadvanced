import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Example
{
    private String s;

    public void Test()
    {
        s = "geksForGeeks";
    }

    public void method1()
    {
        System.out.println("The string is " + s);
    }

    public void method2(int n)
    {
        System.out.println("The number is" + n);
    }

    private void method3()
    {
        System.out.println("Private method invoked");
    }
}

class Demo
{
    public static void main(String args[]) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        // creating object which will inspect runtime
        Example object = new Example();

        // Creating class object from the object using
        // getclass method
        Class cls = object.getClass();

        System.out.println("The name of the class is " + cls.getName());

        System.out.println("The public methods of class are : ");
        // Getting methods of the class through the object
        // of the class by using getMethods
        Method[] methods = cls.getMethods();

        for (Method method: methods)
            System.out.println(method.getName());

        // the way to execute method2 at runtime
        Method methodcall1 = cls.getDeclaredMethod("method2", int.class);
        methodcall1.invoke(object, 19);

        // modify private field
        Field field = cls.getDeclaredField("s");
        field.setAccessible(true);
        field.set(object, "JOROROOOO");

        Method methodcall2 = cls.getDeclaredMethod("method1");
        methodcall2.invoke(object);

        // invoke private method
        Method methodcall3 = cls.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(object);
    }
}