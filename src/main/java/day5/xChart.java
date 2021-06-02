/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

public class xChart {
      public static void main(String[] args){
          try {
          File file = new File("I:\\AI_Pro_intake1\\5- Java\\day5\\team sessions\\lec6lab\\src\\main\\java\\data\\titanic.json");
          ObjectMapper mapper = new ObjectMapper();
          mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
              List<Passenger> passengers=mapper.readValue(file,new TypeReference<List<Passenger>>(){
              });
              
          passengers.stream().forEach(System.out::println);
              System.out.println("out");
          List<Double> ages = passengers.stream().map(Passenger::getAge).limit(5).collect(Collectors.toList());
          List<String> names = passengers.stream().map(Passenger::getName).limit(5).collect(Collectors.toList());
          
          CategoryChart chart = new CategoryChartBuilder ().width (1024).height (768).title ("Age Histogram").xAxisTitle ("Names").yAxisTitle
            ("Age").build ();
          chart.addSeries ("Passenger's Ages", names, ages);
          new SwingWrapper (chart).displayChart ();



            Map<Integer, Long> classes = passengers.stream ().collect (Collectors.groupingBy (
            Passenger::getPclass, Collectors.counting ()));
             PieChart chart1 = new PieChartBuilder ().width (800).height (600).title (Passenger.class.getSimpleName()).build ();
            chart1.addSeries ("First Class", classes.get (1));
            chart1.addSeries ("Second Class", classes.get (2));
            chart1.addSeries ("Third Class", classes.get (3));
            new SwingWrapper (chart1).displayChart ();
            
          
          
          } catch (IOException ex) {
              ex.printStackTrace();
          }
}
}
