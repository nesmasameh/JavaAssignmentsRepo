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
public class CountryDAO {
    public Country createCountry(String[] metadata) {//metadata = fields array of string
        for (int fieldIndex = 0; fieldIndex < metadata.length; fieldIndex++) {
            metadata[fieldIndex] = metadata[fieldIndex].trim();
        }
          Country c = new Country(Integer.valueOf(metadata[0]),metadata[1]);
//        Country c = new Country(Integer.valueOf(metadata[0]), metadata[1]);
        return c;
    }
    public List<Country> readCountriesFromCSV(String fileName) {//fileName = filePath
        List<Country> countries = new ArrayList<>();
        
        File countriesInfo = new File(fileName);//country file
        List<String> lines = new ArrayList<>();//countries lines
        try {
            lines = Files.readAllLines(countriesInfo.toPath());
        } catch (Exception e) {
            System.out.println("issue happened during reading countriesInfo : " + e);
        }
        for (int lineIndex = 1; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            String[] fields = line.split(",");
            countries.add(createCountry(fields));
        }
        return countries;
    }
    
}
