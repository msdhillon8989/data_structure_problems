
public class TopNElementInArray {

	static int arr[] = {43,65,87,98,23,45,67,93,45,74,52,75,80,39};
	static int n = 5;
	
	private static int[] getTop()
	{
		int top[] = new int[n];
	    
		for(int i=0;i<arr.length;i++)
		{
			
			for(int j=0;j<n;j++)
			if(arr[i]>top[j])
			{
				for(int x=n-1;x>j;x--)
				{
					top[x]=top[x-1];
				}
				top[j]=arr[i];
				break;
			}
		}
		return top;
	}
	
	
	
	public static void main(String[] args) 
	{
		for(int n : getTop())
		{
			System.out.print(n+" ");
		}

	}

}
