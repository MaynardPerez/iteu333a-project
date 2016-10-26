/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteu333a.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Skhiburdhurs
 */
public class Iteu333aProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        //Scanner sc = new Scanner(new FileReader("input.txt"));
        String line = "int x = a;";
        System.out.println("Line: -"+line+"-");
        Comment(line);
        Semicolon(line);
        Space(line);
        Initialization(line);
        //reads the file "input.txt"
//        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");
//
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//            //replaces kung with if
//            str = str.replaceAll("kung", "if");
//            str = str.replaceAll("labas", "out");
//            str = str.replaceAll("iprint", "println");
//
//            writer.println(str);
//        }
//        writer.close();
    }
    static int Comment(String x){
        int i=0;
        if(x.charAt(0)=='/' && x.charAt(1)=='/')
        {
            System.out.println("This is a comment");
            i = 0;
        }
        else if(x.charAt(0)=='/' && x.charAt(1)!='/')
        {
            System.out.println("Not a comment");
            i = 1;
        }
        return i;
    }
    static int Semicolon(String x){
        int i=0, j = x.length();
        //String[] arr = x.split(" ");  
        if(x.charAt(0)=='i'&&x.charAt(1)=='f'||x.charAt(0)=='{'||x.charAt(0)=='}')
        {
            System.out.println("Its okay to miss a semi");
            i = 0;
        }
        else if(x.charAt(j-1)==';'){
            System.out.println("Semicolon detected :)");
            i=0;
        }
        else{
            System.out.println("Semi colon missing!!!");
            i = 1;
        }
        return i;
    }
    static int Space(String x){
        int i=0, j = x.length();
        for(int a = 0;a<j;a++)
        {
            if(x.charAt(a)==' ')
            {
                if(x.charAt(a+1)==' ')
                {
                    System.out.println("One space only pls");
                    i=1;
                }
            }
            
        }
        return i;
    }
    
    static int Initialization(String x){
        int i=0, j = x.length();
        String[] arr = x.split(" "); 
        if(arr[2].equals("="))
        {
            if(arr[0].equals("int")||arr[0].equals("int")||arr[0].equals("float")||arr[0].equals("long"))
            {
                System.out.println("Declaration detected");
            }
            else
            {
                System.out.println("Invalid data type");
            }
        }
        
        return i;
    }
    
}
