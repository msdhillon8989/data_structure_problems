import java.util.Stack;

public class MaxSumInPathThrough2DArray {

	static int arr[][] = { { 1, 2, 4 }, 
							{ 1, 5, 4 }, 
							{ 1, 2, 4 } };
	static int R = 3, C = 3;
	//static int memo[][] = new int[R][C];
	
	

	static Stack<Integer>  s= new Stack(); 
	
	
	
	
	
	static int maxValue() 
	{
	   
	    int[][] maxValues = new int[R][C];
	    for (int i = 0; i < R; i++) {
	        for (int j = 0; j < C; j++) 
	        {
	            if (i == 0 && j == 0) {
	                maxValues[i][j] = arr[i][j];
	            } else if (i == 0) {
	                maxValues[i][j] = maxValues[i][j-1] + arr[i][j];
	            } else if (j == 0) {
	                maxValues[i][j] = maxValues[i-1][j] + arr[i][j];
	            } else {
	                maxValues[i][j] = Math.max(maxValues[i][j-1], maxValues[i-1][j]) + arr[i][j];
	            }
	        }
	    }
	    return maxValues[R-1][C-1];
	}
	
	
	
	
	
	
	
	static 	int max(int r,int c)
	{
		if(r>=R || c>=C)
		{
			return 0;
		}
		
		int down = max(r+1,c);
		int right = max(r,c+1);
		
		int num =0;
		if(down>right)
		{
			num=down;
			
			
		}
		else
		{
			num=right;
			
		}
		return  arr[r][c]+num;
	}
	
	

	public static void main(String[] args) 
	{
		int max = max(0,0);
		int max2 = maxValue();
		
		System.out.println(max+"  "+max2);
		

	}

}
