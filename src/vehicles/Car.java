package vehicles;

import java.time.LocalDate;

public class Car extends Vehicle{

    private boolean hasTowbar;
    private int trunkSpace;

    public Car (String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        super(newBrand,newType,newLicensePlate, newManufactureDate, newTax, newFuelType);

    }

    public String getDetails(){

        String details = "This " + getVehicleType() + " is a " + brand + " " + type + "\n";
        details += "\t" + "License plate: " + licensePlate + "\n";
        details += "\t" + "Current mileage: " + mileageInKm + "\n";
        details += "\t" + "Manufacture date: " + manufactureDate + "\n";
        details += "\t" + "Fuel type: " + fuelType + "\n";
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
