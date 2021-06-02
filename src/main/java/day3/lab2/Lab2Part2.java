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
public class Lab2Part2 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        String s = "mam4444";
        int flag =0 ;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(!Character.isLetter(c)){
                flag =1;
                break;
            }
        }
        if(flag == 1){
            System.out.println("not letter");
        }  
        else{
            System.out.println("letter");
        }
    }
}
