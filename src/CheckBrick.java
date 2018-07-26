
public class CheckBrick {
	
	public int[] number(int input1)
	{
		int total=input1*input1;
		int out[] = new int[input1];
		int d = ((total/(input1/2))-1)/(2*(input1-1));
		
		
		return out;
	}
	
	
	public static int card(int input1,int []input2)
	{
		
		int min =Integer.MAX_VALUE;
		int total=input2[0];
		int pos=1;
		int temp;
		for(int i=1;i<input2.length-1;i++)
		{
			total+=input2[i];
			temp=input2[i]+input2[i-1]+input2[i+1];
			if(temp<min)
			{
				min=temp;
				pos=i;
			}
		}
		
		total+=input2[input2.length-1];
		
		total=total+(min*(-2));
		
		return total;
	}
	
	
	public static void main(String sr[])
	{
		int x[] = {-2,3,-1,-4,-2};
		System.out.println(card(5,x));
	}
	
	

}
