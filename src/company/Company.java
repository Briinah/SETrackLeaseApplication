package company;

import leasecompany.LeaseCompany;
import leasecompany.vehicles.Vehicle;

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


    // Returns all vehicles of all leasecompanies which are available
    public Vehicle[] getAvailableVehicles() {
        // Register length
        int numberOfLeaseCompanys = leaseCompanies.length;

        Vehicle[][] tempVehicleArray = new Vehicle[numberOfLeaseCompanys][];
        // Get all available vehicles
        for (int i = 0; i < numberOfLeaseCompanys; i++) {
            tempVehicleArray[i] = leaseCompanies[i].getAvailableVehicles();
        }
        // Get total length of resulting array
        int totalLength = 0;
        for (int i = 0; i < numberOfLeaseCompanys; i++) {
            totalLength = totalLength + tempVehicleArray[i].length;
        }
        // Make new array, length is totalLength.
        Vehicle[] returnArray = new Vehicle[totalLength];
        // Index to keep on track
        int currentIndex = 0;
        for (Vehicle[] currentVehicleArray : tempVehicleArray) {
            for (Vehicle vehicle : currentVehicleArray ) {
                returnArray[currentIndex] = vehicle;
                currentIndex++;
            }

        }
        // return our list!
        return returnArray;
    }

}