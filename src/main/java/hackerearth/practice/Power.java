package hackerearth.practice;

public class Power 
{
	public static void main(String[] args) 
	{
		int count =0;
		int lastPower = 20;
		for(int i=2;i<316;i++)
		{
			for(int j=2;j<lastPower;j++)
			{
				int num = (int)Math.pow(i, j);
				if(num>100000)
				{
					//lastPower = j;
					//System.out.println("LAst Power  ="+lastPower );
					break;
				}
				System.out.println(i+"^"+j+" = "+num );
				count++;
			}
		}
		System.out.println("Total Count "+count);
	}
}
