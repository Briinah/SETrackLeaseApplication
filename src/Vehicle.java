
/*
This class represents a vehicle
Authors: Carolien en Maarten
 */

public class Vehicle {

    private String brand;
    private String type;
    private String licensePlate;

    private int price;
    private int manufactureDate;
    private int tax;

    private float mileageInKm;

    // represents different types of fuel
    public enum FuelType {
        Gasoline, Diesel, Electric
    }

    // represents different types of vehicles
    public enum VehicleType {
        Car, Motor, Truck
    }

    public FuelType fuelType;
    public VehicleType vehicleType;

    // initialises new vehicle
    public Vehicle(String newBrand, String newType, String newLicensePlate, int newManufactureDate, int newTax, FuelType        newFuelType, VehicleType newVehicleType) {
        this.brand = newBrand;
        this.type = newType;
        this.licensePlate = newLicensePlate;
        this.manufactureDate = newManufactureDate;
        this.tax = newTax;
        this.mileageInKm = 0;
        this.fuelType = newFuelType;
        this.vehicleType = newVehicleType;

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
            System.out.println("negative prices not accepted");
            System.out.print("price is not updated. price = ");
        }

        System.out.println(price);
        return price;

    }



}
