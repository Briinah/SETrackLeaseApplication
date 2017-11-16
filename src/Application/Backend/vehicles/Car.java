package Application.Backend.vehicles;

import java.time.LocalDate;

//A car. In addition to the Vehicle superclass, it has a boolean hasTowbar and int trunkSpace.

public class Car extends Vehicle{

    //variables and set and get methods
    private boolean hasTowbar;
    private int trunkSpace;

    public Car (String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        super(newBrand,newType,newLicensePlate, newManufactureDate, newTax, newFuelType);

    }

    public String getDetails(){

        String details = "This " + getVehicleType() + " is a " + getBrand() + " " + getType() + "\n";
        details += "\t" + "License plate: " + getLicensePlate() + "\n";
        details += "\t" + "Current mileage: " + getMileageInKm() + "\n";
        details += "\t" + "Manufacture date: " + getManufactureDate() + "\n";
        details += "\t" + "Fuel type: " + getFuelType() + "\n";
        details += "\t" + "Tow bar: " + hasTowbar + "\n";
        details += "\t" + "Trunk space: " + trunkSpace + "\n";

        return details;

    }

    public boolean hasTowbar() {
        return hasTowbar;
    }

    public void setHasTowbar(boolean hasTowbar) {
        this.hasTowbar = hasTowbar;
    }

    public int getTrunkSpace() {
        return trunkSpace;
    }

    public void setTrunkSpace(int trunkSpace) {
        this.trunkSpace = trunkSpace;
    }
}
