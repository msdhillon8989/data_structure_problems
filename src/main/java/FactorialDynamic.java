

import java.util.Scanner;
public class FactorialDynamic {
	static long fact [] = new long[100000];
    
	
	static
	{
		fact[0]=1;
		for(int i=1;i<=99999;i++)
		{
			fact[i] = (facto(i-1) * i)%1000000007;
		}
	}
    public static long facto(int n)
    {
    	return fact[n];
    	
    }
    public static void main(String args[] ) throws Exception 
    {
      
      Scanner s = new Scanner(System.in);
      int T = s.nextInt();
      for(int i=0;i<T;i++)
      {
      	System.out.println(facto(s.nextInt()));
      }
     
    }
}