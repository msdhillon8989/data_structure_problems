
public class WitchThePainful
{

	
	public static void main(String[] args)
	{
		long h[] = {2,4,8};
		long count=0; 
		
		
		while(true)
		{
			if(h[0]+1==h[1] &&  h[1]+1==h[2])
			{
				break;
			}
			
			if(h[2]-h[1]>=h[1]-h[0])
			{
				h[0]=h[1];
				h[1]=h[2]-1;
				
			}
			else
			{
				h[2]=h[1];
				h[1]=h[0]+1;
			}
			count++;
			System.out.println(h[0]+" "+h[1]+" "+h[2]);
		}
		
		
	//	count=h[2]-h[1]>h[1]-h[0]?h[2]-h[1]-1:h[1]-h[0]-1;
		
		
		System.out.println(count);
		

	}

}
