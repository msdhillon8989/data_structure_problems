package hackerearth.practice;

public class FoldTheArrayAndPrint {

	
	public static  int[][] foldTheArray(int arr[][])
	{
		if(arr[0].length==1)
		{
			return arr;
		}
		int newArr[][] = new int[arr.length*2][arr[0].length/2];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length/2;j++)
			{
				newArr[newArr.length-i-1][j]=arr[arr.length-i-1][j];
				
				newArr[i][j] = arr[arr.length-i-1][arr[i].length-j-1];
				
			}
		}
		printArray(newArr);
				System.out.println();
		newArr = foldTheArray(newArr);
		
		return newArr;
		
	}
	
	
	
	public static void printArray(int newArr[][])
	{
		for(int i=0;i<newArr.length;i++)
		{
			for(int j=0;j<newArr[i].length;j++)
			{
				System.out.print(newArr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) 
	{
		int arr[][]={{1,2,3,4,5,6,7,8}};
		
		int newArr[][] = foldTheArray(arr);
		
		//printArray(newArr);
		
		//newArr = foldTheArray(newArr);
		
		
		
		

	}

}
