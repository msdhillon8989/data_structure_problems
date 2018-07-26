package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.plaf.SliderUI;
 
 
public class TimeLottery {
	
	static long getMax(long[] ar,int skip)
	{
		long maxx=0;
		int n = ar.length;
		long maxAt[] = new long[n];
		for(int i=0;i<=skip;i++)
		{
			
				maxAt[i]=ar[i];
				if(ar[i]>maxx)
				{
					maxx=ar[i];
				}
				else
				{
					maxAt[i]=maxx;
				}
			
		}
		
		for(int i=skip+1;i<n;i++)
		{
			if (ar[i]<=0)
			{
				maxAt[i]=maxx;
			}
			else
			{
				maxAt[i]=maxAt[i-skip-1]+ar[i];
				if(maxx<maxAt[i])
				{
					maxx=maxAt[i];
				}
				else
				{
					maxAt[i]=maxx;
				}
		
			}
		}
		
	
		
		return maxx;
	}
	
	

	
	
	public static void main(String[] args) throws IOException 
	{
		
		
		
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) 
	        {
	            String []cases = br.readLine().split(" ");
	            int  n=Integer.parseInt(cases[0]);
	            int   skip=Integer.parseInt(cases[1]);
	            
	             long[]  ar= new long[n];
	       
	            int x=0;
	            for(String num: br.readLine().split(" "))
	            {
	            	ar[x++]=Integer.parseInt(num);
	            }
	            System.out.println(getMax(ar,skip));
	        }
		
	}
 
}