package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/problem/algorithm/mirror-of-mahatma-gandhi/
public class MirrorNumber {

	public static void main(String[] args) throws IOException {
		
	    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) 
        {
        	String num = br.readLine();
        	
        	if(num.contains("2") || num.contains("3")||num.contains("4")||num.contains("5") || num.contains("6")||num.contains("7")||num.contains("9") )
        	{
        		System.out.println("NO");
        	}
        	else
        	{
        		StringBuilder ss = new StringBuilder(num);
        		ss.reverse();
        		
        		if(num.equals(ss.toString()))
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

}
