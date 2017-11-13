package vehicles;

import java.time.LocalDate;

public class Truck extends Vehicle {

    private boolean hasSleepingSpace;
    private int amountOfTrailers;
    private CargoType cargoType;


    public Truck(String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        super(newBrand, newType, newLicensePlate, newManufactureDate, newTax, newFuelType);

    }

    public String getDetails() {

        String details = "This " + getVehicleType() + " is a " + brand + " " + type + "\n";
        details += "\t" + "License plate: " + licensePlate + "\n";
        details += "\t" + "Current mileage: " + mileageInKm + "\n";
        details += "\t" + "Manufacture date: " + manufactureDate + "\n";
        details += "\t" + "Fuel type: " + fuelType + "\n";
        details += "\t" + "Sleeping space: " + hasSleepingSpace + "\n";
        details += "\t" + "Amount of trailers: " + amountOfTrailers + "\n";
        details += "\t" + "Cargo type: " + cargoType + "\n";

        return details;

    }

    public boolean isHasSleepingSpace() {
        return hasSleepingSpace;
    }

    public void setHasSleepingSpace(boolean hasSleepingSpace) {
        this.hasSleepingSpace = hasSleepingSpace;
    }

    public int getAmountOfTrailers() {
        return amountOfTrailers;
    }

    public void setAmountOfTrailers(int amountOfTrailers) {
        this.amountOfTrailers = amountOfTrailers;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }
}


