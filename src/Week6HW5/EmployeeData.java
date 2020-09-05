package Week6HW5;

public interface EmployeeData {
    String name = null;
    int id = 0;
    int workingHours = 0;
    EmployeeContract employeeContract = EmployeeContract.PERMANENT;
    double getSalary();
    void setId(int id);
}
