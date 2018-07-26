package hackerearth.practice;

import java.util.Scanner;

public class BeingGreedyForWater {

	
	static int arr[];
	
	static private int partition(int start,int end)
	{
		int piv = arr[start];
		int pos = start+1;
		for(int j=start+1;j<=end;j++)
		{
			
			if(arr[j]<piv)
			{
				int temp = arr[j];
				arr[j]=arr[pos];
				arr[pos]=temp;
				pos++;
			}
		}
		pos--;
		arr[start]=arr[pos];
		arr[pos]=piv;
		
		return pos;
		
	}
	
	static void quickSort(int start,int end)
	{
		if(start<end)
		{
			int piv_pos = partition(start, end);
			
			quickSort(start,piv_pos-1);
			quickSort(piv_pos+1,end);
				
		}
	//	System.out.println(count);
	}
	
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		for(int i=0;i<T;i++)
		{
			int bottles = s.nextInt();
			int capacity = s.nextInt();
			arr  =new int[bottles];
			for(int x=0;x<bottles;x++)
			{
				arr[x]=s.nextInt();
			}
			
			quickSort(0, arr.length-1);
			int x=0;
			while(true)
			{
				if(x==arr.length-1) 
					{	
						x++;
						break;
					}
				capacity-=arr[x++];
				
				if(capacity<0)
				{
					x--;
					break;
				}
				
			}
			System.out.println(x);
			
		}

	}

}
