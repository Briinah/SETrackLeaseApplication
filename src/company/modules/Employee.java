package company.modules;

import company.LeaseCompany;
import company.TechCompany;
import vehicles.Vehicle;

//a employee of the companies
public class Employee {

    //employee variables and get and set methods
    String firstName;
    String lastName;
    boolean contract; //Initialises to false
    int leaseLevel;
    TechCompany techCompany;

    public Employee(String firstname, String lastname, int leaseLevel, TechCompany techCompany){
        this.firstName = firstname;
        this.lastName = lastname;
        this.leaseLevel = leaseLevel;
        this.techCompany = techCompany;
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


    //returns the contract of this employee
    public Contract getContract() {
        for(LeaseCompany lc : techCompany.getLeaseCompanies()){
            if(lc.getContractOfEmployee(this) != null){
                Contract c = lc.getContractOfEmployee(this);
                return c;
            }
        }
        System.out.println("Couldn't find a contract for " + this.getFullName());
        return null;
    }

    // Prints array of vehicles available for rent through the techCompany
    public void printAvailableVehicles(){
        Vehicle[] availableVehicles = techCompany.getAvailableVehicles();
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