package hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StackDemo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            Stack<Character> stack = new Stack();
            String s = in.next();
            boolean valid = true;
            
            for(int i =0;i<s.length();i++)
                {
                    char cc = s.charAt(i);
                
                    
                    if(cc=='{' || cc=='[' || cc=='(')
                    {
                    	stack.push(cc);
                    }
                    else
                    {
                    	char opp = '{';
                    	
                    	if(cc == ']')
                    	{
                    		opp='[';
                    	}
                    	else if (cc == ')')
                    	{
                    		opp = '(';
                    	}
                    	
                    	
                    	 if(!stack.isEmpty())
                         {
                             char c = stack.pop();
                             if(c!=opp)
                             {
                                 valid = false; 
                                 break;
                             }
                         }
                         else
                         {
                             valid =false;
                             break; 
                         }
                    	
                    }
                    
                   
                }
            
            	if(valid && stack.isEmpty())
            	{
            		System.out.println("YES");
            	}
            	else
            	{
            		System.out.println("NO");
            	}
            
            
        }
    }
}
