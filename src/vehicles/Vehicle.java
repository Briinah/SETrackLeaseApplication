package vehicles;
/*
This class represents a vehicle
Authors: Carolien en Maarten
 */

import java.time.LocalDate;

public abstract class Vehicle {

    private String brand;
    private String type;
    private String licensePlate;

    private int price;
    private LocalDate manufactureDate;
    private int tax;

    private float mileageInKm;


    private FuelType fuelType;

    // initialises new vehicle
    public Vehicle(String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        this.brand = newBrand;
        this.type = newType;
        this.licensePlate = newLicensePlate;
        this.manufactureDate = newManufactureDate;
        this.tax = newTax;
        this.mileageInKm = 0;
        this.fuelType = newFuelType;
    }

    /*
    change price
    returns: current price
     */
    public int setPrice(int newPrice) {

        if(newPrice > 0) {
            this.price = newPrice;
            System.out.print("new price = ");
        }
        else {
            System.out.println("negative prices or value 0 are not accepted");
            System.out.print("price is not updated. price = ");
        }

        System.out.println(price);
        return price;

    }


    // returns vehicle type as string
    public String getVehicleType () {
        return this.getClass().getSimpleName();
    }

    public abstract String getDetails();

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public int getTax() {
        return tax;
    }

    public float getMileageInKm() {
        return mileageInKm;
    }

    public FuelType getFuelType() {
        return fuelType;
    }
}
