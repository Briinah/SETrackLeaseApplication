package company;

import leasecompany.LeaseCompany;
import leasecompany.vehicles.Vehicle;

public class Company {

    Employee[] employees;
    LeaseCompany[] leaseCompanies;

    int currentNumberOfEmployees;
    int maxNumberOfEmployees;

    public Company(){
        maxNumberOfEmployees = 10;
        currentNumberOfEmployees = 0;
        employees = new Employee[10];

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