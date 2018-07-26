import java.util.StringTokenizer;

import sun.util.locale.StringTokenIterator;

public class ReduceFraction {
	
	public static  int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	
	public static void main(String ap[])
	{
		String fractions="258/840+854/686";
		StringTokenizer st = new StringTokenizer(fractions, "+");
	//	String fraction[]=fractions.split("+");
	  
		String f1Nums[] = st.nextToken().split("/");
		String f2Nums[] = st.nextToken().split("/");
		
		int X = Integer.parseInt(f1Nums[0]);
		int Y = Integer.parseInt(f1Nums[1]);
		
		int U = Integer.parseInt(f2Nums[0]);
		int V = Integer.parseInt(f2Nums[1]);
		
		
		int N=V*X+U*Y;
		int D=Y*V;
		
		
		int gcd = GCD(N,D);
		
		System.out.println((N/gcd)+"/"+(D/gcd));
		
		
		
		
	}

}
