package hackerearth.practice;

import java.util.Scanner;
/**
 * 2496
 * 2622
 * 2288
 *  
 * 
 */
public class MojoInfinite {

	
	private static 	int  GCD(int a,int b)
	{
		if (b==0) return a;
		   return GCD(b,a%b);
	}
	
	public static void main(String[] args) 
	{
		
		int next[] = {2,2,4,4,6,6,8,8,0,0};
		int pre[] = {8,0,0,2,2,4,4,6,6,8};
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int digits[] = new int[9];
		for (int i = 0; i < n; i++) 
		{
			int num = s.nextInt();
			int temp=num;
			int x=-1;
			boolean power=true;
			while(temp>0)
			{
				int digit = temp%10;
				if(digit%2==1)
				{
					power=false;
				}
				digits[++x]=digit;
				temp=temp/10;
			}
			
			//next num
			int nextnum[] = new int[x+1];
			int prenum[] = new int[x+1];
		
			boolean changed=false;
			
			for(int d=x;d>=0;d--)
			{
				if(!changed)
				{
					int cd =digits[d];
					if(cd%2==1)
					{
						changed=true;
						if(cd==9)
						{
							nextnum[d]=next[cd];
							for(int pd = d+1; pd <=x ;pd++)
							{
								int cpd=digits[pd];
								if(cpd!=8)
								{
									nextnum[pd] = next[cpd];
									d=pd;
									break;
								}
								if(cpd==8 && pd==x)
								{
									nextnum[pd]=20;
									d=pd;
									break;
								}
								
							}
						}
						else
						{
							nextnum[d]=next[cd];
						}
					}
					else
					{
						nextnum[d]=cd;
					}
				}
				else
				{
					nextnum[d]=0;
				}
				
			}
			
	/**
	 *   0  1
	 *   1  1
	 *   2 1 0
	 *   2 0 8
	 *      		
	 */
			
			
			changed=false;
			for(int d=x;d>=0;d--)
			{
				if(!changed)
				{
					int cd =digits[d];
					if(cd%2==1)
					{
						changed=true;
						if(cd==0)
						{
						
							prenum[d]=pre[cd];
							
							for(int pd = d; pd <=x ;pd++)
							{
								int cpd=digits[pd];
								
								if(cpd>2)
								{
									prenum[pd] = pre[cpd];
									d=pd;
									break;
								}
								if(cpd<=2 && pd==x)
								{
									prenum[pd]=0;
									d=pd;
									break;
								}
								
							}
						}
						else
						{
							prenum[d]=pre[cd];
						}
					}
					else
					{
						prenum[d]=cd;
					}
				}
				else
				{
					prenum[d]=8;
				}
				
			}
			
			
			
			
			int nextNum=0;
			int preNum=0;
			if(power)
			{
				System.out.println("Unlimited Power");
			}
			else
			{
				for (int j = x; j >=0; j--) 
				{
					nextNum*=10;
					nextNum+=nextnum[j];
				}
				
				for (int j = x; j >=0; j--) {
					preNum*=10;
					preNum+=prenum[j];
				}
				
				int N = nextNum-num;
				int D = num-preNum;
				int gcd = GCD(N,D);
				N=N/gcd;
				D=D/gcd;
				System.out.println(N+"/"+D);
			}
		}

	}

}
