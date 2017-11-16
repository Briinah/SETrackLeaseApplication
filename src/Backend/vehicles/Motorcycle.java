package Backend.vehicles;

import java.time.LocalDate;

//A motercycle. In addition to the Vehicle superclass, it has two booleans hasSideCar and hasSaddleBags.

public class Motorcycle extends Vehicle {

    //variables and set and get methods
    private boolean hasSideCar;
    private boolean hasSaddleBags;

    public Motorcycle (String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        super (newBrand,newType,newLicensePlate, newManufactureDate, newTax, newFuelType);
    }

    public String getDetails(){

        String details = "This " + getVehicleType() + " is a " + getBrand() + " " + getType() + "\n";
        details += "\t" + "License plate: " + getLicensePlate() + "\n";
        details += "\t" + "Current mileage: " + getMileageInKm() + "\n";
        details += "\t" + "Manufacture date: " + getManufactureDate() + "\n";
        details += "\t" + "Fuel type: " + getFuelType() + "\n";
        details += "\t" + "Side car: " + hasSideCar + "\n";
        details += "\t" + "Saddle bags: " + hasSaddleBags + "\n";

        return details;
    }

    public boolean hasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }

    public boolean getHasSaddleBags() {
        return hasSaddleBags;
    }

    public void setHasSaddleBags(boolean hasSaddleBags) {
        this.hasSaddleBags = hasSaddleBags;
    }
}
