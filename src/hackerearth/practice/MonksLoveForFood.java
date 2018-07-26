package hackerearth.practice;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerearth.com/problem/algorithm/monks-love-for-food/
 * 
 *
 */
public class MonksLoveForFood 
{
	public static void main(String[] args) 
	{
		int cost[] = new int[100000];
		int current=-1;
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=0;i<n;i++)
		{
			int q = s.nextInt();
			if(q==1)
			{
				if(current==-1)
				{
					System.out.println("No Food");
				}
				else
				{
					System.out.println(cost[current--]);
				}
			}
			else
			{
				cost[++current]=s.nextInt();
			}
		}

	}

}
