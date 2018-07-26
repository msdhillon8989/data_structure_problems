package hackerrank;

import java.util.Scanner;



public class MaxRectangle {

	public static void main(String[] args) 
	{
		Scanner s  = new Scanner(System.in);
		int recs = s.nextInt();
		int area[] = new int[recs];
		for(int i=0;i<recs;i++)
		{
			area[i] = s.nextInt();
		}
		long maxArea=0;
		for(int i=0;i<recs;i++)
		{
			int count = 1;
			for(int j=i-1;j>=0;j--)
			{
				if(area[i]<=area[j])
				{
					count++;
				}
				else
				{
					break;
				}
			}
			
			for(int j=i+1;j<recs;j++)
			{
				if(area[i]<=area[j])
				{
					count++;
				}
				else
				{
					break;
				}
			}
			
			
			long currentMaxArea = count * area[i];
			if(maxArea<currentMaxArea)
			{
				 maxArea = currentMaxArea;
			}
			
		}
		System.out.println(maxArea);

	}

}
