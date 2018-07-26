
public class CountHoles {
	
	public static void main(String arr[])
	{
		int number=98765670;
		short holes[]={1,0,0,0,1,0,1,0,2,1};
		int totalHoles=0;
		while(number>0)
		{
			int digit=number%10;
			number/=10;
			totalHoles+=holes[digit];
		}
		
		System.out.println(totalHoles);
	}

}
