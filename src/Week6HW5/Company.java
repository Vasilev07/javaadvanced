package Week6HW5;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<Employee>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire(Employee employee) {
        int employeeIndex = employees.indexOf(employee);

        employees.remove(employeeIndex);
    }

    public double allSalaries() {
        double allSalaries = 0;
        for (Employee el : employees) {
            allSalaries += el.getSalary();
        }

        return allSalaries;
    }

    public double avgSalary() {
        double allSalaries = allSalaries();

        return allSalaries / employees.size();
    }

    private double avgSalary(EmployeeContract employeeContract) {
        double allSalaries = 0;
        int currentEmployeeSize = 0;
        for (Employee el: employees) {
            if (el.getEmployeeContract() == employeeContract)
            allSalaries += el.getSalary();
            currentEmployeeSize++;
        }

        return allSalaries / currentEmployeeSize;
    }

    public void increaseEmployeeSalary(Employee employee, int percent) {
        int employeeIndex = employees.indexOf(employee);

        Employee foundEmployee = employees.get(employeeIndex);

        foundEmployee.increaseSalary(percent);
    }

    public double avgSalaryPerContractType(EmployeeContract employeeContract) {
        return avgSalary(employeeContract);
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}
