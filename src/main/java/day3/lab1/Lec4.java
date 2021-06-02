/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3.lab1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Dell
 */
public class Lec4 {

    /**
     * @param args the command line arguments
     */
    static List<City> findAll(String countryName, List<City> list) {
        List<City> result = new ArrayList<>();
        for (City city : list) {
            if (city.getCountry().equals(countryName)) {
                result.add(city);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        CityDAO cDAO = new CityDAO();
        List<City> cities = cDAO.readCitiesFromCSV("G:\\lec4\\src\\lec4\\city.csv");

        CountryDAO countryDAO = new CountryDAO();
        List<Country> countries = countryDAO.readCountriesFromCSV("G:\\lec4\\src\\lec4\\country.csv");

        List<City> l = new ArrayList<>();
        Map< Integer, List<City>> map = new HashMap<>();
        for (Country c : countries) {
            map.put(c.getCountry_code(), findAll(c.getCountry(), cities));
        }
        System.out.println("Initial Mappings are: " + map);

        List<City> ll = findAll("egypt", cities);
        List<City> sortedList = ll.stream().sorted(Comparator.comparingInt(City::getPopulation)).collect(Collectors.toList());
        int i = 0;
        for (City p : sortedList) {
            System.out.println("#" + (i++) + p);
        }

        //
        System.out.println("lab3");
        //

        List<City> maxcity = new ArrayList<>();
        for (Country c : countries) {
            int maxOfC = cities.stream()
                    .filter(cityobj -> cityobj.getCountry().equals(c.getCountry()))
                    .mapToInt(cityobj -> cityobj.getPopulation())
                    .max().getAsInt();

            cities.stream()
                    .filter(obj -> obj.getPopulation() == maxOfC)
                    .forEach(obj -> maxcity.add(obj));

        }
        for (City city : maxcity) {
            System.out.println("country : " + city.getCountry() + " highest population city is : " + city.getName());

        }

        
        List<String> continentList = cities.stream()
                .map(obj -> obj.getContinent())
                .distinct().collect(Collectors.toList());
       
        List<City> maxcityOFcontinent = new ArrayList<>();
        for (String c : continentList) {
            int maxOfC = cities.stream()
                    .filter(cityobj -> cityobj.getContinent().equals(c))
                    .mapToInt(cityobj -> cityobj.getPopulation())
                    .max().getAsInt();

            cities.stream()
                    .filter(obj -> obj.getPopulation() == maxOfC)
                    .forEach(obj -> maxcityOFcontinent.add(obj));

        }
        for (City city : maxcityOFcontinent) {
            System.out.println("continent : " + city.getContinent() + " highest population city is : " + city.getName());

        }
        int maxOfCapitals = cities.stream()
                    .filter(cityobj -> cityobj.getCapital()==1 )
                    .mapToInt(cityobj -> cityobj.getPopulation())
                    .max().getAsInt();
        cities.stream()
                    .filter(obj -> obj.getPopulation() == maxOfCapitals)
                    .forEach(obj -> System.out.println("Highest population capital is : "+obj.getName()));

    }

}
