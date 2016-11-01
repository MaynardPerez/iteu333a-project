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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Skhiburdhurs
 */
public class Iteu333aProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        //String[] INTvars = null,CHRvars= null,LFTvars= null,LNGvars= null,STRvars= null;
        ArrayList<String> INTvars = new ArrayList<String>();
        ArrayList<String> CHRvars = new ArrayList<String>();
        ArrayList<String> LFTvars = new ArrayList<String>();
        ArrayList<String> LNGvars = new ArrayList<String>();
        ArrayList<String> STRvars = new ArrayList<String>();
        ArrayList<String> ALLvars = new ArrayList<String>();
        
//        String line = "add(4+3);";
//        String line2 = "dd)4+3(;";
//        System.out.println("Line: "+line+"");
        
        
        //reads the file "input.txt"
        PrintWriter writer = new PrintWriter("Test.java", "UTF-8");

        while (sc.hasNext()) {
            String str = sc.nextLine();
            //System.out.println("\tLine: "+str);
            //replaces kung with if
//            str = str.replaceAll("kung", "if");
//            str = str.replaceAll("labas", "out");
//            str = str.replaceAll("iprint", "println");
            
            if(Comment(str))
            {
                writer.println(str);
                continue;
            }
            else
            {
                if(Semicolon(str)==1)
                    break;
                if(Space(str)==1)
                    break;
                if(Initialization(str,INTvars,CHRvars,LFTvars,LNGvars,STRvars,ALLvars)==1)
                    break;
                Parenthesis(str);
                Sout(str,ALLvars);
            }
            
            
            
            writer.println(str);
        }
        writer.close();
    }
    static boolean Comment(String x){
        boolean i=false;
        if(x.charAt(0)=='/' && x.charAt(1)=='/')
        {
            //System.out.println("This is a comment");
            i = true;
        }
        else if(x.charAt(0)=='/' && x.charAt(1)!='/')
        {
            //System.out.println("Not a comment");
            i = false;
        }
        else
        {
            //System.out.println("Not a comment");
            i = false;
        }
        return i;
    }
    static int Semicolon(String x){
        int i=0, j = x.length();
        //String[] arr = x.split(" ");
        if(j<=1)
        {
            if(x.charAt(0)=='{'||x.charAt(0)=='}')
            {
                //System.out.println("Its okay to miss a semi");
                i = 0;
            }
        }
        else if(x.charAt(0)=='i'&&x.charAt(1)=='f'||x.split(" ")[0].equals("else"))
        {
            
        }
        else if(x.charAt(j-1)==';'){
            //System.out.println("Semicolon detected :)");
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
    
    static int Initialization(String x,ArrayList<String> INTvars,ArrayList<String> CHRvars,ArrayList<String> FLTvars,ArrayList<String> LNGvars,ArrayList<String> STRvars,ArrayList<String> ALLvars){
        int i=0, j = x.length();
        String[] arr = x.split(" ");
        int lengt = arr.length;
        //System.out.println(lengt);
        //System.out.printf("Count [%d]%n", arr.length);
        if(lengt > 2)
        {
            if(arr[2].equals("="))
            {
                if(arr[0].equals("int")||arr[0].equals("String")||arr[0].equals("float")||arr[0].equals("long"))
                {
                    if(arr[0].equals("int")||arr[0].equals("String")||arr[0].equals("float")||arr[0].equals("long"))
                    {
                        ALLvars.add(arr[1]);
                        if(arr[0].equals("int"))
                        {
                            INTvars.add(arr[1]);
                        }
                        else if(arr[0].equals("String"))
                        {
                            STRvars.add(arr[1]);
                        }
                        else if(arr[0].equals("float"))
                        {
                            FLTvars.add(arr[1]);
                        }
                        else if(arr[0].equals("long"))
                        {
                            LNGvars.add(arr[1]);
                        }
                        else if(arr[0].equals("char"))
                        {
                            CHRvars.add(arr[1]);
                        }
                    }
                    //System.out.println("Declaration detected");
                }
                else
                {
                    System.out.println("Invalid data type");
                }
            }
            else
            {
                System.out.println("Invalid Declaration");
            }
                
        }
        
        
        return i;
    }
    static void Parenthesis(String x)
    {
        int i=0, j = x.length();
        int left=0,right=0;
        
        for(int a = 0;a<j;a++)
        {
            if(x.charAt(a)=='(')
            {
                while(a<j)//||x.charAt(a)!=')')
                {   
                    if(x.charAt(a)=='(')
                    {
                        left++;
                    }
                    else if(x.charAt(a)==')')
                    {
                        right++;
                    }
                    else if(a==j-1 && right != left)
                    {
                        System.out.println(x);
                        break;
                    }
                    a++;
                }
            }
        }
        //System.out.println("right"+right);
        //System.out.println("left"+left);
    }
    static void Sout(String x,ArrayList<String> ALLvars)
    {
        int i=0, j = x.length();
         
        String sub = null;
        if(Pattern.matches("System.out.print.+",x))
        {
            for(int a = 0;a<j;a++)
            {
                if(x.charAt(a)=='(')
                {
                    sub = x.substring(a+1,j-2);
                    //System.out.println(sub);
                    break;
                }
            }
            Pattern p = Pattern.compile("\\+");
            String[] vars = p.split(sub);
            for(int b = 0;b<vars.length;b++)
            {
                //System.out.println(vars[b]);
                i=1;
                for (String curVal : ALLvars)
                {
                    if (curVal.contains(vars[b]))
                    {
                        //System.out.println("ok to");
                        //resList.add(curVal);
                    }
                    else if(i==ALLvars.size())
                    {
                        System.out.println(x);
                        System.out.println(vars[b]+" => San mo nakuha tong variable na to?!?!");
                    }
                    i++;
                }
            }
            
            //Parenthesis(x);
            //System.out.println(x);
        }
    }
}