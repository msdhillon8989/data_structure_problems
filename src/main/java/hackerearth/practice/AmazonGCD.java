package hackerearth.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class AmazonGCD {

	
	
	private static 	int  GCD(int a,int b)
	{
		if (b==0) return a;
		   return GCD(b,a%b);
	}
	
	
	private static int F(int x)
	{
		int sum=0;
		for(int i=1;i<=x;i++)
		{
			sum+=GCD(i,x);
			sum%=1000000007;
		}
		return sum;
	}
	
	
	
	 public static void main(String args[] ) throws Exception {
	       

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        int arr[] = new int[N];
	        String nums[] = br.readLine().split(" "); 
	        for (int i = 0; i < N; i++) 
	        {
	        	arr[i]= Integer.parseInt(nums[i]);
	        }
	         int Q = Integer.parseInt(br.readLine());
	         for(int i=0;i<Q;i++)
	         {
	        	 String query[] = br.readLine().split(" ");
	        	 int X = Integer.parseInt(query[1]);
	        	 int Y = Integer.parseInt(query[2]);
	        	 
	        	 if(query[0].equals("U"))
	        	 {
	        		 arr[X-1]=Y;
	        	 }
	        	 else
	        	 {
	        		 int sum =0;
	        		 for(int n=X-1;n<Y;n++)
	        		 {
	        			 sum+=F(arr[n]);
	        			 sum%=1000000007;
	        		 }
	        		 System.out.println(sum);
	        	 }
	         }
	       
	                
	        

	    
	    }

}
