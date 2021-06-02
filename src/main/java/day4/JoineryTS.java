
package day4;

import joinery.DataFrame;

import java.io.IOException;
import java.util.Date;
import java.util.*;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Table;


public class JoineryTS {
    public static void main(String[] args) throws IOException {
        DataFrame<Object>  df= DataFrame.readCsv ("I:\\AI_Pro_intake1\\5- Java\\day4\\group sessions\\mavenproject1\\src\\main\\java\\data\\titanic.csv");
        System.out.println(df.describe());
        
        List<Integer> newcol = new ArrayList<>();
        
        DataFrame newDF = df.retain("pclass","survived");
        System.out.println(newDF.describe());
        
        DataFrame newDF2 = df.retain("age","body");
        System.out.println(newDF2.describe());
        
        for(int i=0 ; i<df.length() ; i++){
            newcol.add(i);
        }
        
        newDF.add("new cloumn", newcol);
        newDF2.add("new cloumn", newcol);
        
        System.out.println(newDF.describe());
        System.out.println(newDF2.describe());
        
        newDF.joinOn(newDF2, "new cloumn");
        
        System.out.println(newDF.describe());
        DataFrame newdf = newDF.joinOn(newDF2, "new cloumn");
        System.out.println(newdf.describe());
//        System.out.println(newDF.merge(newDF2).describe());
        
        Table df2 = Table.read().csv("I:\\AI_Pro_intake1\\5- Java\\day4\\group sessions\\mavenproject1\\src\\main\\java\\data\\titanic.csv");
        System.out.println(df2.summary());
        System.out.println(df2.structure());
        
        Table newTdf2 =df2.select("age","body");
        Table newTdf =df2.select("pclass","survived");
        
        int[] arr = arr = new int[df.length()];
        for(int i=0 ; i<df.length() ; i++){
            arr[i]=i;
        }
//        for (Integer n : arr) {
//            System.out.println(n);
//        }
        IntColumn c = IntColumn.create("new column", arr);
        newTdf.addColumns(c);
        newTdf2.addColumns(c);
        
        
        System.out.println(newTdf.summary());
        System.out.println(newTdf2.summary());
        Table joinOnT = newTdf.joinOn("new column").inner(newTdf2);
        System.out.println(joinOnT.summary());
        
    }
}
