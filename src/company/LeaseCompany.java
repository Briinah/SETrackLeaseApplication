package company;

import company.modules.Contract;
import company.modules.Employee;
import vehicles.Vehicle;

import static java.time.LocalDate.now;

//A lease company. In addition to Company superclass, it has vehicles and lease contracts.

public class LeaseCompany extends Company {

    private Vehicle[] vehicles;
    private Contract[] contracts;
    private int maxNumberOfVehicles, maxNumberOfContracts;
    private int currentNumberOfVehicles = 0, currentNumberOfContracts = 0;
    private String name;

    //Constructor that initialises the class with a specified maximum possible number of contracts and vehicles.
    public LeaseCompany(int numberOfVehicles, int numberOfContracts, String name) {
        vehicles = new Vehicle[numberOfVehicles];
        contracts = new Contract[numberOfContracts];
        maxNumberOfVehicles = numberOfVehicles;
        maxNumberOfContracts = numberOfContracts;
        this.name=name;

    }

    public String getName(){
        return this.name;
    }


    public void addVehicle(Vehicle vehicle) {
        if (currentNumberOfVehicles < maxNumberOfVehicles) {
            vehicles[currentNumberOfVehicles] = vehicle;
            currentNumberOfVehicles++;
        } else {
            System.out.println("Er past geen auto meer bij. Check het wetboek at artikel 315, lid x.");
        }
    }

    public void addContract(Contract contract) {
        if (currentNumberOfContracts < maxNumberOfContracts) {
            contracts[currentNumberOfContracts] = contract;
            currentNumberOfContracts++;
        } else {
            System.out.println("Er past geen contract meer bij.");
        }
    }

    // Remove a contract
    public void removeContract(Contract contract) {
        for (int i = 0; i < currentNumberOfContracts; i++) {
            if (contracts[i] == contract) {
                contracts[i] = contracts[currentNumberOfContracts - 1];
                contracts[currentNumberOfContracts - 1] = null;
                // update current number of contracts
                currentNumberOfContracts--;
                contract.endContract();
                // Exit function; we're done
                return;
            }
        }
        System.out.println("Contract not found");
    }

    // Remove a vehicle
    public void removeVehicle(Vehicle vehicle) {
        for (int i = 0; i < currentNumberOfVehicles; i++) {
            if (vehicles[i] == vehicle) {
                // overwrite with last car
                vehicles[i] = vehicles[currentNumberOfVehicles - 1];
                // remove duplicate
                vehicles[currentNumberOfVehicles - 1] = null;
                // update current number of contracts
                currentNumberOfVehicles--;
                // Exit function; we're done
                return;
            }
        }
        System.out.println("Car not found");

    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public Contract[] getContracts() {
        return contracts;
    }

    // Checks if the vehicle is available
    public Contract getContractOfVehicle(Vehicle vehicle) {
        for (int i = 0; i < currentNumberOfContracts; i++) {
            if (vehicle == contracts[i].getVehicle()) {
                return contracts[i];
            }
        }
        return null;
    }

    // Checks what contract belongs to the employee
    public Contract getContractOfEmployee(Employee employee) {
        for (int i = 0; i < currentNumberOfContracts; i++) {
            if (employee == contracts[i].getEmployee()) {
                return contracts[i];
            }
        }
        return null;
    }

    // Gets vehicleOfEmployee
    public Vehicle getVehicleOfEmployee(Employee employee){
        Contract contract = getContractOfEmployee(employee);
        if(contract == null){
            return null;
        }
        return contract.getVehicle();
    }

    // Checks if the vehicle is available
    private boolean isVehicleAvailable(Vehicle vehicle) {
        for (int i = 0; i < currentNumberOfContracts; i++) {
            if (vehicle == contracts[i].getVehicle()) {
                return false;
            }
        }
        return true;
    }

    //Returns number of available vehicles
    private int getNumberOfAvailableVehicles() {
        int number = 0;
        for (int i = 0; i < currentNumberOfVehicles; i++) {
            if (isVehicleAvailable(vehicles[i])) {
                number++;
            }
        }
        return number;
    }

    //Returns Array of available vehicles
    public Vehicle[] getAvailableVehicles() {
        int numberOfAvailableVehicles = getNumberOfAvailableVehicles();
        int currentIndex = 0;
        Vehicle[] returnArray = new Vehicle[numberOfAvailableVehicles];
        for (int i = 0; i < currentNumberOfVehicles; i++) {
            if (isVehicleAvailable(vehicles[i])) {
                returnArray[currentIndex] = vehicles[i];
                currentIndex++;
            }
        }
        return returnArray;
    }

    //Prints details of all vehicles
    public void printVehicleDetails() {
        for (int i = 0; i < currentNumberOfVehicles; i++) {
            System.out.println(vehicles[i].getDetails());
        }
    }

    //Prints details of all contracts
    public void printContractDetails() {
        for (int i = 0; i < currentNumberOfContracts; i++) {
            contracts[i].printDetails();
        }
    }

    public void printAvailableVehicleDetails(){
        System.out.println("Printing currently available vehicle details:");
        Vehicle[] availableVehicles = getAvailableVehicles();
        for(int i = 0; i < availableVehicles.length; i++){
            System.out.println(availableVehicles[i].getDetails());
        }
    }

    public Employee[] getEmployeesWithContract(){
        Employee[] returnEmployeeArray = new Employee[currentNumberOfContracts];
        for(int i = 0; i < currentNumberOfContracts; i++){
            returnEmployeeArray[i] = contracts[i].getEmployee();
        }
        return returnEmployeeArray;
    }

    // prints details of customers
    public void printEmployeesWithContract(){
        for(Employee employee : getEmployeesWithContract()){
            System.out.println(employee.getFullName());
        }
    }

    // Checks if the employee has a car here.
    public boolean checkIfEmployeeHasCarHere(Employee e) {

        for(int i = 0; i < currentNumberOfContracts; i++) {
            if(contracts[i].getEmployee() == e){
                return true;
            }
        }
        return false;
    }



}
