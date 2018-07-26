package hackerearth.practice;

import java.util.Scanner;

public class SAPSimilarSubArrays 
{
	public static void main(String[] arg){
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		while(cases-->0)
		{
			int size = s.nextInt();
			int count=0;
			int previous=s.nextInt();
			int currentCount=1;
			for(int i=1;i<size;i++)
			{
				int current = s.nextInt();
				
				if(current==previous)
				{
					currentCount++;
				}
				else
				{
					count+= (currentCount*(currentCount+1))/2;
				//	System.out.println(count);
					currentCount=1;
					previous=current;
				}
				
			}
			count+= (currentCount*(currentCount+1))/2;
			
			System.out.println(count);
		}
	}
}
