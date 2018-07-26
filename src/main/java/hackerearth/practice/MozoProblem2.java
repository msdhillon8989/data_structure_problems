package hackerearth.practice;


import java.util.Scanner;

public class MozoProblem2 {

	static int arr[] ;
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
		int n = s.nextInt();
		arr = new int[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		quickSort(0, arr.length-1);
		int start =0; 
		int end =n-1;
		
		boolean flag=true;
		long sum =0;
		while(start<end)
		{
			int diff = arr[end]-arr[start];
			System.out.println(arr[end]+"-"+arr[start]);
			sum+=diff;
			if(flag)
			{
				flag=false;
				start++;
			}
			else
			{
				flag=true;
				end--;
			}
		}
		
		System.out.println(sum);

	}

}


/**
 * 1 2 3 4
 * 1 4 2 3  3 2 1 6
 * 1 3 2 4  2 1 2 5
 * 1 4 3 2  3 1 1 5
 * 3 4 8 9 12
 * 3 12 4 9 8  9+8+5+1
 */

