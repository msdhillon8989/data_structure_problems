package hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelCase {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String s = in.nextLine();
        int words=0;
        for(char c:s.toCharArray())
        {
        	int ascii= (int)c;
        	if(ascii>=65 && ascii<=90)
        	{
        		words++;
        	}
        }
        checkUperCase(s);
        System.out.println(words+1);
        
        for(String word:s.split("(?=[A-Z])"))
        	System.out.println(word);
        
    }
    
    public static void checkUperCase(String testStr)
    {
   int count=1;
    String regEx = "([A-Z])";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(testStr);
    while (matcher.find())
    	  count++;

    System.out.println(count);
    }
}