package leasecompany.vehicles;

import leasecompany.vehicles.FuelType;

public class Motorcycle extends Vehicle {

    public Motorcycle (String newBrand, String newType, String newLicensePlate, int newManufactureDate, int newTax, FuelType newFuelType) {
        super (newBrand,newType,newLicensePlate, newManufactureDate, newTax, newFuelType);
    }
}
