/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteu333a.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maynard
 */
public class Iteu333aProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner reader = new Scanner(System.in);
        String a = "add(3+3);";
        int count = 0;
        System.out.println("Inputs: "+ a);
        for(int i =0 ; i<a.length(); i++)
        {
           if(a.charAt(a.length() - 2)!=')')
           {
               System.out.println("Syntax Error 1");
           }
           else if(a.charAt(a.length() - 1)!=';')
           {
               System.out.println("Syntax Error 2");
           }
           else if(a.charAt(i)!='(')
               {
                   System.out.println("Syntax Error 3");
               }
           else if (Character.isDigit(a.charAt(i))) 
           {
               count++;
               System.out.println(count);
 //              if(count % 2==0)
 //            {
 //                System.out.println("Syntax Error");
 //              }
           }
        }
    }
}
