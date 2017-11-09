package leasecompany;

import company.Company;
import company.Employee;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import leasecompany.Contract;
import leasecompany.vehicles.Car;
import leasecompany.vehicles.FuelType;
import leasecompany.vehicles.Vehicle;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class LeaseCompany {

    Vehicle[] vehicles;
    Contract[] contracts;
    int maxNumberOfVehicles, maxNumberOfContracts;
    int currentNumberOfVehicles = 0;
    int currentNumberOfContracts = 0;

    public LeaseCompany(int numberOfVehicles, int numberOfContracts ){
        vehicles = new Vehicle[numberOfVehicles];
        contracts = new Contract[numberOfContracts];
        maxNumberOfVehicles = numberOfVehicles;
        maxNumberOfContracts = numberOfContracts;

    }

    public Vehicle[] getVehicles(){
        return vehicles;
    }

    public Contract[] getContracts() {
        return contracts;
    }

    public void addVehicle(Vehicle vehicle){
        if(currentNumberOfVehicles < maxNumberOfVehicles){
            vehicles[currentNumberOfVehicles] = vehicle;
            currentNumberOfVehicles++;
        }else{
            System.out.println("Er past geen auto meer bij. Check het wetboek at artikel 315, lid x.");
        }
    }

    public void addContract(Contract contract){
        if(currentNumberOfContracts < maxNumberOfContracts){
            contracts[currentNumberOfContracts] = contract;
            currentNumberOfContracts++;
        } else{
            System.out.println("Er past geen contract meer bij.");
        }
    }

    // Remove a contract
    public void removeContract(Contract contract) {
        for (int i = 0; i < currentNumberOfContracts; i++){
            if (contracts[i] == contract){
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
        for (int i = 0; i < currentNumberOfVehicles; i++){
            if (vehicles[i] == vehicle){
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

    public void printCars(){
        for (Vehicle vehicle :
                vehicles) {
            System.out.println(vehicle);
        }
    }


    public void getAvailableVehicles(){

    }

}
