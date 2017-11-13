package company;

import leasecompany.Contract;
import leasecompany.LeaseCompany;
import leasecompany.vehicles.Vehicle;

public class Employee {

    String firstName;
    String lastName;
    boolean contract; //Initialises to false
    int leaseLevel;
    Company company;

    public Employee(String firstname, String lastname, int leaseLevel, Company company){
        this.firstName = firstname;
        this.lastName = lastname;
        this.leaseLevel = leaseLevel;
        this.company=company;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public boolean getHasContract() {
        return this.contract;
    }

    public void setHasContract(boolean set) {
        this.contract=set;
    }


    public Contract getContract() {
        for(LeaseCompany lc : company.getLeaseCompanies()){
            if(lc.getContractOfEmployee(this) != null){
                Contract c = lc.getContractOfEmployee(this);
                return c;
            }
        }
        System.out.println("Couldn't find a contract for " + this.getFullName());
        return null;
    }

    // Prints array of vehicles available for rent through the company
    public void printAvailableVehicles(){
        Vehicle[] availableVehicles = company.getAvailableVehicles();
        for(Vehicle vehicle: availableVehicles){
            System.out.println(vehicle.getDetails());
        }
    }

    /*
    Get vehicle details via contract
    Returns a string with vehicle details. If no details are available, returns empty string.
     */
    public String getVehicleDetails () {

        try {
            return getContract().getVehicle().getDetails();
        }
        catch(NullPointerException npe){
            System.out.println("No vehicle details available.");
            return "";
        }
    }

}