package hackerearth.practice;

import java.util.Scanner;

//https://www.hackerearth.com/problem/algorithm/rest-in-peace-21-1/


public class REST21 {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		
		for(int i=0;i<n;i++)
		{
			int num = s.nextInt();
			if(num%21==0)
			{
				System.out.println("The streak is broken!");
			}
			else
			{
				String number = num+"";
				if(number.contains("21"))
				{
					System.out.println("The streak is broken!");
				}
				else
				{
					System.out.println("The streak lives still in our heart!");
				}
			}
		}

	}

}
