package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * https://www.hackerearth.com/problem/algorithm/roy-and-symmetric-logos-1/
 *
 */
public class SymmetricLogos {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		while(cases-->0)
		{
			int size = Integer.parseInt(br.readLine());
			int mx[][] = new int[size][size]; 
			for(int i=0;i<size;i++ )
			{
				String binaryString = br.readLine();
				for(int j=0;j<size;j++)
				{
					if(binaryString.charAt(j)=='1')
					{
						mx[i][j]=1;
					}
					else
					{
						mx[i][j]=0;
					}
					
					
				}
			}
			boolean notSymmetric=false;
			z:
			for(int i=0;i<=size/2;i++ )
			{
			
				for(int j=0;j<=size/2;j++)
				{
					if(! ( mx[i][j]  == mx[size-1-i][j] && mx[i][j]  == mx[i][size-1-j] && mx[i][j]  == mx[size-1-i][size-1-j]) )
					{
						notSymmetric=true;
						break z;
					}
				}
			}
			
			if(notSymmetric)
			{
				System.out.println("NO");
				
			}
			else{
				System.out.println("YES");
			}
			
		}

	}

}
