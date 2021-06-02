/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3.lab2;

/**
 *
 * @author Dell
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.lang.Character;

class Strings {

    public static boolean isbiggerLength(int n1, int n2) {
        return n1 > n2;
    }

    public static String betterString(String s1, String s2, BiPredicate<Integer, Integer> p) {
        if (p.test(s1.length(), s2.length())) {
            return s1;
        }
        return s2;
    }
}
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = Strings.betterString("mm", "aaaaaaaaaaaaaaaaa", Strings::isbiggerLength);
        System.out.println(s);
    }

}
