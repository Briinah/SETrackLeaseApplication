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

    public void removeContract(Contract contract){
        for (int i = 0; i < currentNumberOfContracts; i++) {
            // if contract found
            if (contracts[i] == contract){
                // remove contract
                contracts[i] = null;
                for (int j = i; j < currentNumberOfContracts - 1; j++) {
                    // Shift contracts to left
                    contracts[j] = contracts[j+1];
                }
                // update current number of contracts
                currentNumberOfContracts--;
                contracts[currentNumberOfContracts] = null;
                // Exit function; we're done
                return;
            }
        }
    }

    public void removeVehicle(Vehicle vehicle){
        for (int i = 0; i < currentNumberOfVehicles; i++) {
            // if vehicle found
            if (vehicles[i] == vehicle){
                // remove vehicle
                vehicles[i] = null;
                for (int j = i; j < currentNumberOfVehicles - 1; j++) {
                    // Shift contracts to left
                    vehicles[j] = vehicles[j+1];
                }
                // update current number of vehicles
                currentNumberOfVehicles--;
                vehicles[currentNumberOfVehicles] = null;
                // Exit function; we're done
                return;
            }
        }
    }

    public void getAvailableVehicles(){

    }

}
