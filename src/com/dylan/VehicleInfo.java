package com.dylan;


public class VehicleInfo {
//    (Vehicle Identification Number)
    int VIN;
//    (miles traveled)
    double odometer;
//    (gallons of gas consumed)
    double consumption;
//    for last oil change
    double odometerReading;
//    (e.g. 2.0, 4.5) engine size in liters
    double engineSize;

    public VehicleInfo() {

    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(double odometerReading) {
        this.odometerReading = odometerReading;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }
}
