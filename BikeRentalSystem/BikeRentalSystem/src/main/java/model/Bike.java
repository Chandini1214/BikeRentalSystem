package model;

public class Bike {
    private int bikeId;
    private String make;
    private String model;
    private int year;
    private double rentalRatePerDay;
    private String availabilityStatus;

    public Bike() {}

    public Bike(int bikeId, String make, String model, int year, double rentalRatePerDay, String availabilityStatus) {
        this.bikeId = bikeId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.availabilityStatus = availabilityStatus;
    }

    public Bike(String make, String model, int year, double rentalRatePerDay, String availabilityStatus) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.availabilityStatus = availabilityStatus;
    }

    public int getBikeId() { return bikeId; }
    public void setBikeId(int bikeId) { this.bikeId = bikeId; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getRentalRatePerDay() { return rentalRatePerDay; }
    public void setRentalRatePerDay(double rentalRatePerDay) { this.rentalRatePerDay = rentalRatePerDay; }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }
}