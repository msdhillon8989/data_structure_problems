package hackerearth.practice;

import java.lang.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XsquareAndChocolatesBars
{

	
	
	private static int getRemainingDP(String bar)
	{
		int max = 0;
		int maxAt[] = new int[bar.length()+1];
		
		
		for(int i=3;i<=bar.length();i++)
		{
			if (bar.charAt(i-1) != bar.charAt(i - 2) || bar.charAt(i - 2) != bar.charAt(i - 3))
			{
				maxAt[i]=maxAt[i-3]+1;
				max = max<maxAt[i]?maxAt[i]:max;
			}
		}
		
		
		
		return bar.length()-max*3;
	}
	
	private static int getRemaining(String bar)
	{
		int total = bar.length();
		// int i=0;
		int maxx=0;
		for (int x = 0; x < total - 2; x++)
		{
			int max=0;
			int i=x;
			while (true)
			{
				try
				{
					if (bar.charAt(i) != bar.charAt(i + 1) || bar.charAt(i + 1) != bar.charAt(i + 2))
					{
						max+=3;
						i = i + 3;
					} else
					{
						maxx=maxx<max?max:maxx;
						break;
					}
				}
				catch (Exception s)
				{
					maxx=maxx<max?max:maxx;
					break;
				}
			}
		}

		return total-maxx;
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		StringBuffer br1 = new StringBuffer();
		for (int i = 0; i < line; i++)
		{
			String bar = br.readLine();
			br1.append(getRemainingDP(bar)+"\n");

		}
		System.out.println(br1.toString());

	}

}
