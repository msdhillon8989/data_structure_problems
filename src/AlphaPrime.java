import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;




public class AlphaPrime
{


	static boolean[] p = new boolean[1000000];
	
	public static void getPrime()
	{
		for(int i=0;i<1000000;i++)
		{
			p[i]=isPrime(i+1);
		}
	}
	
	
public static boolean isPrime(int num)
{
		if(num==1)
		{
			return false;
		}
		if(num>2 && num%2==0)
		{
			return false;
		}
	    int top = (int)Math.sqrt(num) + 1;
	    for(int i = 3; i < top; i+=2)
	    {
	        if(num % i == 0)
	        {
	            return false;
	        }
	    }
	    return true; 
}
	
	


private static boolean isAlphaPrime1(int num)
{
	double pow = (num+"").length()-1;
	double b = 10;
	int place = (int)(Math.pow(b, pow));
	
	while(place>0)
	{
	//	System.out.println(num +  " % "+  place);
			
		if( num>0  && p[num-1]   )
		{
			return true;
		}
		
		num=num%place;
		place/=10;
		
	};
	return false;
}

	
	private static boolean   isAlphaPrime(int number)
	{
		int sufix=0;
		int place=1;
		
		while(number>0)
		{
			int r = number%10;
			sufix=place*r+sufix;
			place*=10;
			
			if(sufix>0 && p[sufix-1])
			{
				return true;
			}
		//	System.out.println(sufix+"  is "+ (d==-1?"prime":"divisible by "+d)  );
			number=number/10;
		}
		return false;
		
	}

	
	
	public static void main(String[] args) throws Exception
	{
		getPrime();
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		int T = Integer.parseInt(scanner.nextLine());
		
		for(int i=0;i<T;i++)
		{
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int alphaPrimeNums=0;
			for(int num=a;num<=b;num++)
			{
				if(isAlphaPrime1(num))
				{
					alphaPrimeNums++;
				}
			}
			System.out.println(alphaPrimeNums);
			
			
		}

	}

}
