package vehicles;

import java.time.LocalDate;

//A Truck. In addition to the Vehicle superclass, it has a boolean hasSleepingSpace an amountOfTrailers int and a Cargotype.

public class Truck extends Vehicle {

    //variables and set and get methods
    private boolean hasSleepingSpace;
    private int amountOfTrailers;
    private int maxAmountOfTrailers;
    private CargoType cargoType;

    //
    public Truck(String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        super(newBrand, newType, newLicensePlate, newManufactureDate, newTax, newFuelType);
        maxAmountOfTrailers = 3;
    }

    public String getDetails() {

        String details = "This " + getVehicleType() + " is a " + brand + " " + type + "\n";
        details += "\t" + "License plate: " + licensePlate + "\n";
        details += "\t" + "Current mileage: " + mileageInKm + "\n";
        details += "\t" + "Manufacture date: " + manufactureDate + "\n";
        details += "\t" + "Fuel type: " + fuelType + "\n";
        details += "\t" + "Sleeping space: " + hasSleepingSpace + "\n";
        details += "\t" + "Amount of trailers: " + this.amountOfTrailers + "\n";
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

    public void setAmountOfTrailers (int amountOfTrailers)

        {
            if (amountOfTrailers > maxAmountOfTrailers) {
                System.out.println("Er zitten nu " + maxAmountOfTrailers + " aan de truck. Omdat dit het maximaal aantal aanhangers is.");
                this.amountOfTrailers = maxAmountOfTrailers;

            }else {
                this.amountOfTrailers = amountOfTrailers;
                System.out.println("Er zitten nu " + amountOfTrailers + " trailers aan de truck.");
            }
        }


    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }




