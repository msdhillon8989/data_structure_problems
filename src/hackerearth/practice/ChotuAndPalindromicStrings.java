package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.security.x509.IssuingDistributionPointExtension;

public class ChotuAndPalindromicStrings {

	
	public static String isPalindrom(String s1,String s2)
	{
		String newString  = s1.concat(s2);
		
		
		int length = newString.length();
		
		for(int i=0;i<length/2;i++)
		{
			if(newString.charAt(i)!=newString.charAt(length-i-1))
			{
				return "NO";
			}
		}
		
		return "YES";
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(br.readLine());
		
		while(cases-->0)
		{
			String s = br.readLine();
			String s2 = br.readLine();
			
			if(isPalindrom(s,s2).equals("YES") || isPalindrom(s2,s).equals("YES"))
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
