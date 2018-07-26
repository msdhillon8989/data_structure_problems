package hackerearth.practice;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;




public class QuintypeProblem1 {

	static long cars[] ; 
    static int users[];
    static private int partition(int start,int end)
	{
		int piv = users[start];
		int pos = start+1;
		for(int j=start+1;j<=end;j++)
		{
			if(users[j]<piv)
			{
				int temp = users[j];
				users[j]=users[pos];
				users[pos]=temp;
				pos++;
			}
		}
		pos--;
		users[start]=users[pos];
		users[pos]=piv;
		
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
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		cars = new long[m];
		users = new int[n];
		LinkedHashMap<Integer,Integer> req = new LinkedHashMap<>();
		for(int i=0;i<n;i++)
		{
			int userStartTime=s.nextInt();
			users[i]=userStartTime;
			req.put(userStartTime,s.nextInt());
		}
		
		quickSort(0, users.length-1);
		
		for(int currentReq : users)
		{
			int travelTime = req.get(currentReq);
			boolean alloted =false;
			for(int i=0;i<m;i++)
			{
				if(cars[i]<=currentReq)
				{
					cars[i]=travelTime+currentReq;
					alloted=true;
					req.put(currentReq, i+1);
					break;
				}
			}
			if(!alloted)
			{
				req.put(currentReq, -1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Entry e : req.entrySet())
		{
			sb.append(e.getValue()+" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
		

	}

}


// 1   10      11
// 2  
// 2 4 8  
