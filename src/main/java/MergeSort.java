

public class MergeSort {

	static int arr[] = {25,25,29,76,54,30,98,34,53,9,10,72};
	static int temp[] ;
	static int count=0;
	
	private static void  mergsort(int l,int h)
	{
		if(l<h)
		{
			int middle = l + (h-l)/2;
			mergsort(l, middle);
			mergsort(middle+1, h);
			merge(l,middle,h);
					
		}
	}
	
	
	private static void merge(int l, int middle, int h) 
	{
		for(int i=l;i<=h;i++)
		{
			count++;
			temp[i]=arr[i];
		}
		
		int i=l;
		int j=middle+1;
		int k=l;
		
		
		while(i<=middle && j<=h)
		{
			count++;
			if(temp[i]<=temp[j])
			{
				arr[k]=temp[i];
				i++;
			}
			else
			{
				arr[k]=temp[j];
				j++;
			}
			k++;
		}
		
		
		while(i<=middle)
		{
			count++;
			arr[k]=temp[i];
			i++;
			k++;
		}
		
//		while(j<=middle)
//		{
//			arr[k]=temp[j];
//			j++;
//			k++;
//		}
//		
	}


	public static void main(String[] args) 
	{
		temp = new int[arr.length];
		
		mergsort(0, arr.length-1);
		
		for(int k : arr)
		{
			System.out.print(k+"  ");
		}
		
		
		System.out.println(count);

	}

}
