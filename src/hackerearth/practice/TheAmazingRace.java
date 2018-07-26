package hackerearth.practice;

import java.util.Scanner;

//https://www.hackerearth.com/problem/algorithm/the-amazing-race-1/?utm_source=header&utm_medium=search&utm_campaign=he-search

public class TheAmazingRace {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		
		while(cases-->0)
		{
			int total = s.nextInt();
			int hights[] = new int[total];
			long sight[]  = new long[total];
			for(int i=0;i<total;i++)
			{
				hights[i]=s.nextInt();
				
				for(int j=i-1;j>=0;j--)
				{
					sight[i]++;
					if(hights[j]>=hights[i])
					{
						break;
					}
					
				}
				
			}
			
			long max=0;
			int maxIndex=1;
			for(int i=0;i<total;i++)
			{
				
				for(int j=i+1;j<total;j++)
				{
					sight[i]++;
					if(hights[j]>=hights[i])
					{
						break;
					}
					
				}
				if(max< (sight[i]=sight[i]*(i+1)))
				{
					max=sight[i];
					maxIndex=i+1;
				}
				System.out.print("  "+sight[i]);
			}
		System.out.println(maxIndex);
		}

	}

}
