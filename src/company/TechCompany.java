package company;

import company.modules.Contract;
import company.modules.Employee;
import vehicles.Vehicle;

public class TechCompany extends Company {


    //Max number of leasecompanies as by techcompany.
    int maxNumberOfLeaseCompanies = 10;
    int currentNumberOfLeaseCompanies = 0;
    LeaseCompany[] leaseCompanies = new LeaseCompany[maxNumberOfLeaseCompanies];

    public LeaseCompany[] getLeaseCompanies() {
        return leaseCompanies;
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



}