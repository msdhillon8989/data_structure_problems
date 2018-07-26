

 
  final class Employee{  
	 final String pancardNumber;  
	   
	 public Employee(String pancardNumber){  
	 this.pancardNumber=pancardNumber;  
	 }  
	   
	 public String getPancardNumber(){  
	 return pancardNumber;  
	 }  
	   
	 }   
 
interface DeclareStuff {
	public static final int EASY = 3;

	public  void doStuff(int t);
}

public class Test {
	
	static final long tooth=343L;
	
	
	public long doit(long tooth)
	{
		System.out.println(++tooth+" ");
		return ++tooth;
	}
	
	
	public void  maxPathInTrianle()
	{
		int tri [][] = {{0,0,0,55,0,0,0},
				{0,0,94,0,48,0,0},
				{0,95,0,30,0,96,0},
				{77,0,71,0,26,0,140},
		
};



int r = tri.length;
int c =tri[0].length;
int val[][] = new int[r][c];
int max =0;
for(int i=0;i<r;i++)
{
	for(int j=0;j<c;j++)
	{
		if(i==0)
		{
			val[i][j]=tri[i][j];
		}
		else
		{
			int v=tri[i][j];
			int vl =0;
			int vr =0;
			if(v!=0)
			{
				if(j>0)
				{
					vl = val[i-1][j-1];
				}
				if(j<c-1)
				{
					vr = val[i-1][j+1];
				}
				int maxx = vl>vr?vl+v:vr+v;
				
				
				val[i][j]=maxx;
				if(maxx>max)
				{
					max=maxx;
				}
			}
		}
	}
}

for(int i=0;i<r;i++)
{
	for(int j=0;j<c;j++)
	{
		System.out.print(val[i][j]+" ");
	}
	System.out.println();
}



System.out.println(max);

	}
	
	
	private static 	int  GCD(int a,int b)
	{
		if (b==0) return a;
		   return GCD(b,a%b);
	}
	
	public static void main(String[] args) throws Exception
	{
		
		System.out.println(GCD(10, 2));
	
		
		
		
	
		
	}

	

}
