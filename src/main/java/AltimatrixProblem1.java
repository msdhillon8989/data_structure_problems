

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AltimatrixProblem1 
{
	
	public static void main(String arg[])
	{
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=2;i<31622;i++)
		{
			for(int j=2;j<20;j++)
			{
				int num = (int)Math.pow(i, j);
				if(num>1000000000)
				{
					break;
				}
				//System.out.println(i+"^"+j+" = "+num );
				list.add(num);
			}
		}
		
		Collections.sort(list);
		Scanner s = new Scanner(System.in);
		int cases = s.nextInt();
		
		
		while(cases-->0)
		{
			int q = s.nextInt();
			while(q-->0)
			{
				int start = 0; int end = list.size()-1;
				int mid = end/2;
				int n = s.nextInt();
				if(n<=4)
				{
					System.out.println(n-4);
				}
				if(n >= 999950884)
				{
					System.out.println(n-999950884);
				}
				else
				{
					while(start<=end)
					{
						mid = start + (end-start)/2;
						int midNum =list.get(mid);
					
						if(midNum == n)
						{
							System.out.println("0");
							break;
						}
						else if(midNum > n) 
						{
							int previousNum =list.get(mid-1); 
							if(previousNum>n)
							{
								end = mid-1;
							}
							else
							{
								int diff1 = n-previousNum;
								int diff2 = midNum-n;
								
								System.out.println(diff1<diff2?diff1:diff2);
								break;
							}
						}else
						{
							int nextNum =list.get(mid+1); 
							if(nextNum<n)
							{
								start = mid+1;
							}
							else
							{
								int diff1 = nextNum-n;
								int diff2 = n-midNum;
								
								System.out.println(diff1<diff2?diff1:diff2);
								break;
							}
						}
					
				}
				}
				
			}
				
		}
	
/**
 * 3
 * 0 1 2
 * s 0  e 2
 * mid = 1
 * 
 * 		
 */
		
		
		
		
	}
	
}
