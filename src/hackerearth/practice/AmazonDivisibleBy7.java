package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class AmazonDivisibleBy7 {

	public static void main(String[] args) throws Exception 
	{
		
		checkDivisibilityBy7();

	}
	
	public static void checkDivisibilityBy7UsingBigInteger() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number = br.readLine();
		int cases = Integer.parseInt(br.readLine());
		BigInteger currentNum,mod,result;
		mod = new BigInteger("7");
		
		while(cases-->0)
		{
			String input = br.readLine();
			int l = Integer.parseInt(input.substring(0, input.indexOf(" ")));
			int r = Integer.parseInt(input.substring(input.indexOf(" ")+1));
			currentNum = new BigInteger(number.substring(l-1,r));
			result = currentNum.mod(mod);
			if(result.toString().equals("0"))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}
	
	
	public static void checkDivisibilityBy7() throws Exception
	{
		int rem[] = {1, 3, 2, 6, 4, 5};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String number = br.readLine();
		int cases = Integer.parseInt(br.readLine());
		while(cases-->0)
		{
			String input = br.readLine();
			int l = Integer.parseInt(input.substring(0, input.indexOf(" ")));
			int r = Integer.parseInt(input.substring(input.indexOf(" ")+1));
			long productSum=0;
			int remIndex=0;
			for(int i=r-1;i>=l-1;i--)
			{
				int currentDigit = number.charAt(i)-'0';
				productSum+=currentDigit*rem[remIndex];
				remIndex++;
				if(remIndex==6)
				{
					remIndex=0;
				}
			}
			if(productSum%7==0)
			{
				sb.append("YES\n");
				
			}
			else{
				sb.append("NO\n");
				
			}
			
		}
		
		System.out.println(sb.toString());
	}
	
	
	
	

}
