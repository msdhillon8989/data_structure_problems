package hackerearth.practice;

import java.util.Scanner;

public class RoyAndRops {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	      int T = s.nextInt();
	      int lenght=0;
	      int u[];
	      int l[];
	      
	      long mins=0;
	      for(int i=0;i<T;i++)
	      {
	    	
	    	int currentMax=0;
	      	lenght = s.nextInt();
	      	mins=lenght;
	      	u = new int[lenght];
	      	l = new int[lenght];
	      	for(int x =0;x<lenght-1;x++)
	      	{
	      		u[x] = s.nextInt();
	      		
	      	}
	      	for(int x =0;x<lenght-1;x++)
	      	{
	      		l[x] = s.nextInt();
	      		
	      	}
	      	
	      	
	      	for(int x =0;x<lenght-1;x++)
	      	{
	      		currentMax = u[x] > l[x]?u[x] : l[x];
	      		long diff=currentMax-(mins-x-1);
	      		if(diff>0)
	      		{
	      			mins+=diff;
	      		}
	      		
	       	}
	      	System.out.println(mins);
	      	 
	      }

	}

}
