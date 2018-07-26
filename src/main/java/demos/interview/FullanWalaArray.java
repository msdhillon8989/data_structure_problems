package demos.interview;

public class FullanWalaArray {
	public static void main(String[] args) {

		int arr[] = {1,0,0,0,0,1,0,0,0,0,1};
		System.out.println(isPossible(arr,2));
	}

	private static boolean isPossible(int []flowerbed , int n)
	{
		//0 0 0 0 0 0 0 1 0 0 0 1 0 1
		if(flowerbed.length==1 && flowerbed[0]==0)
		{
			n--;
		}
		else if(flowerbed.length>1)
		{
			int flowerIndex =0;
			/*if(flowerbed[flowerIndex] == 0)
			{
				if(flowerbed[flowerIndex+1]==0)
				{
					flowerbed[flowerIndex] =1;
					n--;
					flowerIndex=2;
				}
				else {
					flowerIndex=3;
				}
			}*/
			while(flowerIndex<flowerbed.length)
			{
				if(flowerbed[flowerIndex] == 0)
				{
					int previous = flowerIndex-1>=0?flowerbed[flowerIndex-1]:0;
					int next = flowerIndex+1<flowerbed.length ? flowerbed[flowerIndex+1]:0;

					if(previous == 0 && next ==0)
					{
						flowerbed[flowerIndex] =1;
						n--;
						flowerIndex+=2;
					}else if (previous ==1 && next ==0){
						flowerIndex++;
					}else if( next ==1 )
					{
						flowerIndex+=3;
					}
				}
				else
				{
					flowerIndex+=2;
				}
			}
		}

		for(int i: flowerbed)
		{
			System.out.print(i+" ");
		}
		if(n <=0)
		{
			return true;
		}
		return false;
	}
}
