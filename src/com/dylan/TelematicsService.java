package com.dylan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class TelematicsService {
    public void report(VehicleInfo vehicleInfo){
        try {
            File file = new File(String.valueOf(vehicleInfo.getVIN()) + ".json");
            FileWriter fw = new FileWriter(file);
//            fw.write(vehicleInfo.getVIN() + "\n");
//            fw.write(vehicleInfo.getOdometer()+ "\n");
//            fw.write(vehicleInfo.getConsumption()+ "\n");
//            fw.write(vehicleInfo.getOdometerReading()+ "\n");
//            fw.write(vehicleInfo.getEngineSize()+ "\n");
//            fw.close();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(vehicleInfo);
            fw.write(json);
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        File file = new File(".");
        for (File f : file.listFiles()) {
            if (f.getName().endsWith(".json")) {
                // Now you have a File object named "f". You can use this in the FileReader constructor
                // new FileReader(f)
                String json = null;
                try {
                    json = new String(Files.readAllBytes(Paths.get(f.getPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }

//            json to java
                ObjectMapper mapper = new ObjectMapper();
                VehicleInfo vi = null;
                try {
                    vi = mapper.readValue(json, VehicleInfo.class);
//                     String VIN = toString().valueOf(vi.getVIN());
//                     String odometer = toString().valueOf(vi.getOdometer());
//                     String consumption = toString().valueOf(vi.getConsumption());
//                     String oilChange = toString().valueOf(vi.getOdometerReading());
//                     String enginESize = toString().valueOf(vi.getEngineSize());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int VIN = vi.getVIN();
                double odometer = vi.getOdometer();
                double consumption = vi.getConsumption();
                double oilChange = vi.getOdometerReading();
                double engineSize = vi.getEngineSize();
                String html = "<html>\n" +
                        "<title>Vehicle Telematics Dashboard</title>\n" +
                        "<body>\n" +
                        "<h1 align=\"center\">Averages for # vehicles</h1>\n" +
                        "<table align=\"center\">\n" +
                        "    <tr>\n" +
                        "        <th>Odometer (miles) |</th><th>Consumption (gallons) |</th><th>Last Oil Change |</th><th>Engine Size (liters)</th>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "        <td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td><td align=\"center\">#</td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "<h1 align=\"center\">History</h1>\n" +
                        "<table align=\"center\" border=\"1\">\n" +
                        "    <tr>\n" +
                        "        <th>VIN</th><th>Odometer (miles)</th><th>Consumption (gallons)</th><th>Last Oil Change</th><th>Engine Size (liters)</th>\n" +
                        "    </tr>\n";
                String carInfo =
                        "    <tr>\n" +
                        "        <td align=\"center\">" + VIN + "</td><td align=\"center\">" + odometer + "</td><td align=\"center\">" + consumption + "</td><td align=\"center\">" + oilChange + "</td><td align=\"center\">" + engineSize + "</td>\n" +
                        "    </tr>\n" +
                        "</table>\n" +
                        "</body>\n" +
                        "<html>\n";
                File fileCars = new File("cars.html");
                try (FileWriter fwCars = new FileWriter(fileCars)) {
                    fwCars.write(html + carInfo);
                    fwCars.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}

