/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3.lab1;

/**
 *
 * @author Dell
 */
public class Country {
    private int country_code;
    private String country;

    public Country(int country_code, String country) {
        this.country_code = country_code;
        this.country = country;
    }

    public int getCountry_code() {
        return country_code;
    }

    public void setCountry_code(int country_code) {
        this.country_code = country_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return getCountry()+" "+getCountry_code(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
