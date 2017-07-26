package com.dylan;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        VehicleInfo vehicleInfo = new VehicleInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, Please input your VIN");
        int VIN = scanner.nextInt();
        vehicleInfo.setVIN(VIN);

        System.out.println("Next, your odometer reading.");
        double odometer = scanner.nextDouble();
        vehicleInfo.setOdometer(odometer);

        System.out.println("How many gallons of gas did you consume");
        double consumption = scanner.nextDouble();
        vehicleInfo.setConsumption(consumption);

        System.out.println("What was the odometer reading for your last oil change?");
        double odometerReading = scanner.nextDouble();
        vehicleInfo.setOdometerReading(odometerReading);

        System.out.println("What is your engine size");
        double engineSize = scanner.nextDouble();
        vehicleInfo.setEngineSize(engineSize);

        TelematicsService telematicsService = new TelematicsService();

        telematicsService.report(vehicleInfo);


    }
}
