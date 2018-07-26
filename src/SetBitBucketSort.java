import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SetBitBucketSort {

	
	static int getTotalBits(int x)
	{
		int count=0;
		while(x>0)
		{
			x = x&(x-1);
			count++;
		}
		return count;
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numbers = Integer.parseInt(br.readLine());
		
		
		ArrayList<Integer>[] group = (ArrayList<Integer>[])new ArrayList[11];
		for(int i=0;i<11;i++)
		{
			group[i] = new ArrayList<>();
		}
		
		String ss[] =  br.readLine().split(" ");
		for(String s: ss)
		{
			int numb = Integer.parseInt(s);
			
			group[getTotalBits(numb)].add(numb);
		}
		
		for(int i=0;i<group.length;i++)
		{
			Collections.sort(group[i]);
			boolean notBlank=false;
			for(int xx : group[i])
			{
				notBlank=true;
				System.out.print(xx+" ");
			}
			if(notBlank)
				System.out.println();
		}
		

	}

}
