/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3.lab1;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class CityDAO {
    
    public City createCity(String[] metadata) {//metadata = fields array of string
        for (int fieldIndex = 0; fieldIndex < metadata.length; fieldIndex++) {
            metadata[fieldIndex] = metadata[fieldIndex].trim();
        }
        City c = new City(Integer.valueOf(metadata[0]), metadata[1], metadata[2], Double.valueOf(metadata[3]), Integer.valueOf(metadata[4]),metadata[5],Integer.valueOf(metadata[6]));
        return c;
    }
    public List<City> readCitiesFromCSV(String fileName) {//fileName = filePath
        List<City> cities = new ArrayList<>();
        File citiesInfo = new File(fileName);//city file
        List<String> lines = new ArrayList<>();//cities lines
        try {
            lines = Files.readAllLines(citiesInfo.toPath());
        } catch (Exception e) {
            System.out.println("issue happened during reading citiesInfo : " + e);
        }
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            String[] fields = line.split(",");
            cities.add(createCity(fields));
        }
        return cities;
    }
}
