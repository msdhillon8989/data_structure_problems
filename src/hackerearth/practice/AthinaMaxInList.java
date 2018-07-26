package hackerearth.practice;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AthinaMaxInList {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int N =s.nextInt();
		int M=s.nextInt();
		int a,b,k=0;
		long arr[] = new long[N];
		long maxx=0;
		long current=0;
		while(M-->0)
		{
			a = s.nextInt();
			b = s.nextInt();
			k = s.nextInt();
			
			arr[a-1]+=k;
			if(b<=N)
			{
				arr[b-1]-=k;
			}
		}
		
		for(long crr : arr)
		{
			current = current+crr;
			if(maxx<current)
			{
				maxx=current;
			}
		}
		
		System.out.println(maxx);

	}

	//       0 0  0  0  0    0 0 0 0    0
	//       0 50       -50        1000  -1000
	/**        50 100   -150       1000  -1000
	 *       0 50 150    0         1000
	 *  
	 *       0 50 50  50  0  0 0 0 50 50
	 *            150 150 
	 * 
	 */
	/*public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(System.in);
		
		int N =s.nextInt();
		int M=s.nextInt();
		int a,b,k=0;
		long arr[] = new long[N];
		long maxx=0;
		while(M-->0)
		{
			a = s.nextInt();
			b=s.nextInt();
			k=s.nextInt();
			
			for(int i=a-1;i<b;i++)
			{
				long current=arr[i]=arr[i]+k;
				if(current>maxx)
				{
					maxx=current;
				}
			}
		}
		
		System.out.println(maxx);

	}
	*/
	
	
}
