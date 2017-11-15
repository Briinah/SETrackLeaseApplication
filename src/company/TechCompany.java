package company;

import company.modules.Contract;
import company.modules.Employee;
import vehicles.Vehicle;

import java.rmi.dgc.Lease;

//A "normal" company, the leasecompanies are clients to the "normal" company. In addition to Company superclass, it has a list of available leasecompanies.

public class TechCompany extends Company {


    //Max number of leasecompanies as by techcompany.
    private int maxNumberOfLeaseCompanies = 10;
    private int currentNumberOfLeaseCompanies = 0;
    private LeaseCompany[] leaseCompanies = new LeaseCompany[maxNumberOfLeaseCompanies];
    private String name;

    public TechCompany(String name){
        this.name = name;
    }

    public LeaseCompany[] getLeaseCompanies() {
        return leaseCompanies;
    }

    public int getCurrentNumberOfLeaseCompanies() {
        return currentNumberOfLeaseCompanies;
    }

    // Returns all vehicles of all leasecompanies which are available
    public Vehicle[] getAvailableVehicles() {
        // Register length

       Vehicle[][] tempVehicleArray = new Vehicle[currentNumberOfLeaseCompanies][];
        // Get all available vehicles
        for (int i = 0; i < currentNumberOfLeaseCompanies; i++) {
            tempVehicleArray[i] = leaseCompanies[i].getAvailableVehicles();
        }
        // Get total length of resulting array
        int totalLength = 0;
        for (int i = 0; i < currentNumberOfLeaseCompanies; i++) {
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


    public void addLeaseCompany(LeaseCompany leaseCompany) {
        if (currentNumberOfLeaseCompanies < maxNumberOfLeaseCompanies) {
            leaseCompanies[currentNumberOfLeaseCompanies] = leaseCompany;
            currentNumberOfLeaseCompanies++;
        } else {
            System.out.println("Pool's closed bitchezzzz. Check het wetboek at artikel 315, lid x.");
        }
    }

    public void removeLeaseCompany(LeaseCompany leaseCompany) {
        //Go through employee list
        for (int i = 0; i < currentNumberOfLeaseCompanies; i++) {
            //Remove employee if it exists, and shorten array.
            if (leaseCompanies[i] == leaseCompany) {
                leaseCompanies[i] = leaseCompanies[currentNumberOfLeaseCompanies - 1];
                leaseCompanies[currentNumberOfLeaseCompanies - 1] = null;
                // update current number of contracts
                currentNumberOfLeaseCompanies--;
                // Exit function; we're done
                return;
            }
        }
        //If employee does not exist, print message
        System.out.println("Lease company not found");
    }

    public Contract getContract(Employee employee) {
        for(LeaseCompany lc : getLeaseCompanies()){
            if(lc.getContractOfEmployee(employee) != null){
                Contract c = lc.getContractOfEmployee(employee);
                return c;
            }
        }
        System.out.println("Couldn't find a contract for " + employee.getFullName());
        return null;
    }

    /*
    Get vehicle details via contract
    Returns a string with vehicle details. If no details are available, returns empty string.
    */
    public String getVehicleDetails (Employee employee){
        try {
            return getContract(employee).getVehicle().getDetails();
        }
        catch(NullPointerException npe){
            System.out.println("No vehicle details available.");
            return "";
        }
    }

    public void printAvailableVehicles(){
        for(int i=0; i<currentNumberOfLeaseCompanies;i++){
        leaseCompanies[i].printAvailableVehicleDetails();
        }
    }

    //Checks if the employee has a contract by one of the leasecompanies and prints out if there is
    public boolean checkIfEmpHasContract(Employee e) {

        for(int i = 0; i < leaseCompanies.length; i++){
            if(leaseCompanies[i].checkIfEmployeeHasCarHere(e)) {
                System.out.println(e.getFullName() + " has a contract by " + leaseCompanies[i].getName());
                return true;
            }
        }
        System.out.println("There is no contract found for " + e.getFullName() );
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}