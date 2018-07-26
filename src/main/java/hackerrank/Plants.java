package hackerrank;

import java.util.Scanner;

import sun.rmi.transport.LiveRef;

public class Plants {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int total = s.nextInt();
		int plants[] = new int[total];
		for(int i=0;i<total;i++)
		{
			plants[i] =s.nextInt();
		}
		int died = 0;
		int days = 0;
		int nextStartFrom=0;
		do{
			died=0;
			int living =nextStartFrom+1;
			int previousPlant = plants[nextStartFrom];
			for(int i=living;i<total;i++)
			{
				if(plants[i]<=previousPlant)
				{
					plants[living++]=plants[i];
				}
				else
				{
					if(died==0)
					{
						nextStartFrom = i-1;
					}
					died++;
				}
				previousPlant = plants[i];
			}
			total=living;
			days++;
		}while(died!=0);	
		System.out.println(days-1);
	}

}
