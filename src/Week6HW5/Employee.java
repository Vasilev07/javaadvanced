package Week6HW5;

public class Employee implements EmployeeData {
    private String name;
    private int id;
    private int workingHours;
    private double additionalPersonalPayment;
    private EmployeeContract employeeContract;
    private double salary = 0;
    public Employee(String name, int workingHours, double additionalPersonalPayment, EmployeeContract employeeContract) {
        this.name = name;
        this.additionalPersonalPayment = additionalPersonalPayment;
        this.workingHours = workingHours;
        this.employeeContract = employeeContract;
    }

    public double getAdditionalPersonalPayment() {
        return additionalPersonalPayment;
    }

    public void increaseAdditionalPersonalPayment(int percent) {
        this.additionalPersonalPayment += (additionalPersonalPayment * percent) / 100;
    }

    public EmployeeContract getEmployeeContract() {
        return employeeContract;
    }

    public double getSalary() {
        if (salary == 0) {
            this.setSalary();
        }

        return this.salary;
    }

    public void setSalary() {
        this.salary = workingHours * getMinimalHourPayment();
    }

    public void increaseSalary(int percent) {
        this.salary += (this.salary * percent) / 100;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", workingHours=" + workingHours +
                ", additionalPersonalPayment=" + additionalPersonalPayment +
                ", employeeContract=" + employeeContract +
                '}';
    }

    private double getMinimalHourPayment() {
        if (employeeContract == EmployeeContract.PERMANENT) {
            return 25;
        } else if (employeeContract == EmployeeContract.PARTTIME) {
            return 15;
        } else {
            return 5;
        }
    }
}
