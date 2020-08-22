package Week3HW2;

public class Employee {
    private String name;
    private String title;
    private int age;

    public void constructor(String name, int age, String title) {
        this.name = name;
        this.age = age;
        this.title = title;
    }

    public int getAge() {
        return age;
    }
}
