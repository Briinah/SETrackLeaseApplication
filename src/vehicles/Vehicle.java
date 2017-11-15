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


    private LocalDate manufactureDate;

    /* Unused:
    private int tax;
    private int price;
    */

    private float mileageInKm;


    private FuelType fuelType;

    // initialises new vehicle
    public Vehicle(String newBrand, String newType, String newLicensePlate, LocalDate newManufactureDate, int newTax, FuelType newFuelType) {
        this.brand = newBrand;
        this.type = newType;
        this.licensePlate = newLicensePlate;
        this.manufactureDate = newManufactureDate;
        //this.tax = newTax;
        this.mileageInKm = 0;
        this.fuelType = newFuelType;
    }

    /* Unused:
    change price
    returns: current price
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

    } */


    // returns vehicle type as string
    protected String getVehicleType () {
        return this.getClass().getSimpleName();
    }

    public abstract String getDetails();

    protected String getBrand() {
        return brand;
    }

    protected String getType() {
        return type;
    }

    protected String getLicensePlate() {
        return licensePlate;
    }

    protected LocalDate getManufactureDate() {
        return manufactureDate;
    }

    protected float getMileageInKm() {
        return mileageInKm;
    }

    protected FuelType getFuelType() {
        return fuelType;
    }

    /* Unused:
    public int getPrice() {
        return price;
    }

    public int getTax() {
        return tax;
    }

     */
}
