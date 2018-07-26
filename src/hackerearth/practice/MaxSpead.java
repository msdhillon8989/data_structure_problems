package hackerearth.practice;

import java.util.Scanner;

//https://www.hackerearth.com/problem/algorithm/speed-7/

public class MaxSpead 
{

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		while(cases-->0)
		{
			int cars = s.nextInt();
			int count=0;
			int last=s.nextInt();
			count++;
			for(int i=1;i<cars;i++)
			{
				int cc = s.nextInt();
				if(cc<=last)
				{
					count++;
					last=cc;
				}
				
			}
			System.out.println(count);
		}

	}

}
