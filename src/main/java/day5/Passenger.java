/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;

/**
 *
 * @author Dell
 */
public class Passenger {
    int pclass,survived;
    double sibsp,parch,fare,age;
    String name,sex,ticket,cabin,boat,body,home_dest;

    public Passenger() {
    }

    public int getPclass() {
        return pclass;
    }

    public void setPclass(int pclass) {
        this.pclass = pclass;
    }

    public int getSurvived() {
        return survived;
    }

    public void setSurvived(int survived) {
        this.survived = survived;
    }

    public double getSibsp() {
        return sibsp;
    }

    public void setSibsp(double sibsp) {
        this.sibsp = sibsp;
    }

    public double getParch() {
        return parch;
    }

    public void setParch(double parch) {
        this.parch = parch;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHome_dest() {
        return home_dest;
    }

    public void setHome_dest(String home_dest) {
        this.home_dest = home_dest;
    }

//    @Override
//    public String toString() {
//        return "Passenger{" + "pclass=" + pclass + ", survived=" + survived + ", sibsp=" + sibsp + ", parch=" + parch + ", fare=" + fare + ", age=" + age + ", name=" + name + ", sex=" + sex + ", ticket=" + ticket + ", cabin=" + cabin + ", boat=" + boat + ", body=" + body + ", home_dest=" + home_dest + '}';
//    }
//    

    
}
