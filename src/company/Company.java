package company;

import company.modules.Employee;

//Abstract Company, superclasses TechCompany and LeaseCompany. Both have employees, common employee functionality is here.

public abstract class Company {

    //Variables

    int maxNumberOfEmployees = 10;
    int currentNumberOfEmployees = 0;
    Employee[] employees = new Employee[10];

    //Getter for the full Employee list.
    public Employee[] getEmployeeList() {
        return this.employees;
    }

    //Add an employee to the list.
    public void addEmployee(Employee employee) {
        if (currentNumberOfEmployees < maxNumberOfEmployees) {
            employees[currentNumberOfEmployees] = employee;
            currentNumberOfEmployees++;
        } else {
            System.out.println("Meer werknemers mogelijk. Check het wetboek at artikel 315, lid x.");
        }
    }

    //Remove an employee from the list.
    public void removeEmployee(Employee employee) {
        for (int i = 0; i < currentNumberOfEmployees; i++) {
            if (employees[i] == employee) {
                employees[i] = employees[currentNumberOfEmployees - 1];
                employees[currentNumberOfEmployees - 1] = null;
                // update current number of contracts
                currentNumberOfEmployees--;
                // Exit function; we're done
                return;
            }
        }
        System.out.println("Contract not found");
    }


}
