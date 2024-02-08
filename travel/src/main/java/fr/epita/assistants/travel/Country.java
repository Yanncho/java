package fr.epita.assistants.travel;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Country {
    String countryName;
    ZoneId countryZone;
    public Map<String, Integer> travelTimes;

    public Country(String countryName, String countryZone, String inputFilePath) {
        this.countryName = countryName;
        this.countryZone = ZoneId.of(countryZone);
        travelTimes = initTravelTimes(inputFilePath);
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) {
        Map res = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(inputFilePath));) {
            String[] line = null;
            while ((line = csvReader.readNext()) != null) {
                if (line[0].equals(this.countryName)) {
                    res.put(line[1], Integer.valueOf(line[2]));
                } else if (line[1].equals(this.countryName)) {
                    res.put(line[0], Integer.valueOf(line[2]));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static void main(String[] args) {
        Country fr = new Country("France", "Europe/Paris", "src/main/resources/travel_times.csv");
        System.out.println(fr.travelTimes);
        Country it = new Country("Italy", "Europe/Paris", "src/main/resources/travel_times.csv");
        System.out.println(it.travelTimes);
    }
}
