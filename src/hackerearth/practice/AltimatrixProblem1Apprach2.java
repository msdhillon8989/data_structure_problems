package hackerearth.practice;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class AltimatrixProblem1Apprach2 
{
	
	public static void main(String arg[]) throws Exception
	{
		
		boolean l[] = new boolean[1000000001];
		int lastPower = 20;
		for(int i=2;i<31622;i++)
		{
			for(int j=2;j<lastPower;j++)
			{
				int num = (int)Math.pow(i, j);
				if(num>1000000000)
				{
					lastPower=j;
					break;
				}
				//System.out.println(i+"^"+j+" = "+num );
				//list.add(num);
				l[num]=true;
			}
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		int cases = Integer.parseInt(br.readLine().trim());
		
		
		while(cases-->0)
		{
			int q = Integer.parseInt(br.readLine().trim());
			while(q-->0)
			{
				int n = Integer.parseInt(br.readLine().trim());
				if(n<=4)
				{
					System.out.println(4-n);
				}
				else if(n >= 999950884)
				{
					System.out.println(n-999950884);
				}
				else
				{
					if(l[n])
					{
						System.out.println("0");
					}
					else
					{
						int preIndex = n-1;
						int diff1=0;
						
						while(!l[preIndex])
						{
							preIndex--;
						}
						diff1 = n-preIndex;
						
						
						int nextIndex = n+1;
						while(!l[nextIndex])
						{
							nextIndex++;
						}
						int diff2 = nextIndex-n;
						
						
						System.out.println(diff1<diff2?diff1:diff2);
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
