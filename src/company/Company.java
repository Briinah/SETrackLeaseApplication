package company;

import company.modules.Employee;

//Abstract Company, superclasses TechCompany and LeaseCompany. Both have employees, common employee functionality is here.

public abstract class Company {

    //Variables
    private int maxNumberOfEmployees = 10, currentNumberOfEmployees = 0;
    private Employee[] employees = new Employee[10];

    //Getter for the full Employee list.
    public Employee[] getEmployeeList() {
        // Make sure that we only return an array with length |employees|
        // In other words, shorten the array not to contain NULL.
        Employee[] returnList = new Employee[currentNumberOfEmployees];
        for (int i = 0; i < currentNumberOfEmployees; i++) {
            returnList[i] = employees[i];
        }
        return returnList;
    }

    //Add an employee to the list.
    public void addEmployee(Employee employee) {
        //Add employee if there is space
        if (currentNumberOfEmployees < maxNumberOfEmployees) {
            employees[currentNumberOfEmployees] = employee;
            //Update current number of employees
            currentNumberOfEmployees++;
        } else {
            System.out.println("Meer werknemers mogelijk. Check het wetboek at artikel 315, lid x.");
        }
    }

    //Remove an employee from the list.
    public void removeEmployee(Employee employee) {
        //Go through employee list
        for (int i = 0; i < currentNumberOfEmployees; i++) {
            //Remove employee if it exists, and shorten array.
            if (employees[i] == employee) {
                employees[i] = employees[currentNumberOfEmployees - 1];
                employees[currentNumberOfEmployees - 1] = null;
                // update current number of contracts
                currentNumberOfEmployees--;
                // Exit function; we're done
                return;
            }
        }
        //If employee does not exist, print message
        System.out.println("Employee not found");
    }


}
