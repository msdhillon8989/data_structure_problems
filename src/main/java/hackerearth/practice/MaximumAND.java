package hackerearth.practice;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/maximum-and/
 * Given two numbers A and B. Find the value of pair (P,Q) such that A <= P < Q <= B value of P AND Q is maximum where AND is a binary operator. Refer to this link for more information about AND operator : http://en.wikipedia.org/wiki/Bitwise_operation#AND

Input:
First line of input contains number of test cases T. Each test case contains two numbers A and B.

Output: For each test case print the value of maximum AND.
 *
 */
public class MaximumAND {

	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i =0;i<n;i++)
		{
			long n1=s.nextLong();
			long n2=s.nextLong();
			long max = 0;
			for(long num = n2;num>n1;num--)
			{
				long AND =(num&(num-1));
				if(AND >=max)
				{
					max=AND;
					
					
				}
				
			}
			System.out.println(max);
		}

	}

}
