
public class QuickSort {
	
	static int arr[] = {25,25,29,76,54,30,98,34,53,9,10,72};
	static int count=0;
	static private int partition(int start,int end)
	{
		int piv = arr[start];
		int pos = start+1;
		for(int j=start+1;j<=end;j++)
		{
			count++;
			if(arr[j]<piv)
			{
				int temp = arr[j];
				arr[j]=arr[pos];
				arr[pos]=temp;
				pos++;
			}
		}
		pos--;
		arr[start]=arr[pos];
		arr[pos]=piv;
		System.out.println(count);
		return pos;
		
	}
	
	static void quickSort(int start,int end)
	{
		if(start<end)
		{
			int piv_pos = partition(start, end);
			
			quickSort(start,piv_pos-1);
			quickSort(piv_pos+1,end);
				
		}
	//	System.out.println(count);
	}
	
	
	
	public static void main(String[] args) 
	{
		
		quickSort(0, arr.length-1);
		
		for(int c:arr)
		{
	//		System.out.print(c+"  ");
		}
		
	//	System.out.println();
	//	System.out.println(count);
	}

}
