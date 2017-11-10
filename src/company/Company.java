package company;

import leasecompany.LeaseCompany;

public class Company {

    Employee[] employees;
    LeaseCompany[] leaseCompanies;

    int currentNumberOfEmployees;
    int maxNumberOfEmployees;

    public Company(){
        employees = new Employee[]{
                new Employee("Daniel", "Oliemans",5,this),
                new Employee("Jeffrey", "Scheidelaar",5,this),
                new Employee("Bas", "Weeterings",5,this),
                new Employee("Carolien", "Gilbers",4,this),
                new Employee("Koen", "Griffioen",3,this),
                new Employee("Jeran", "Kapel",2,this),
                new Employee("Maarten", "Stienstra",8,this),
                new Employee("Anton", "Quelle",9001,this)
        };

        leaseCompanies=new LeaseCompany[]{new LeaseCompany(100,100)};
    }

    public LeaseCompany[] getLeaseCompanies() {
        return leaseCompanies;
    }

    public Employee[] getEmployeeList() {
        return this.employees;
    }

    public void addEmployee(Employee employee) {
        if (currentNumberOfEmployees < maxNumberOfEmployees) {
            employees[currentNumberOfEmployees] = employee;
            currentNumberOfEmployees++;
        } else {
            System.out.println("Meer werknemers mogelijk. Check het wetboek at artikel 315, lid x.");
        }
    }

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