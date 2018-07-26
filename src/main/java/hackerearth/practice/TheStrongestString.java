package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheStrongestString {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int lenght = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int arr[] = new int[26];
		
		for(int i=0;i<lenght;i++)
		{
			arr[s.charAt(i)-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
	//	int currentCompareIndex =0;
		boolean keepAdding = false;
		char lastChar = 0;
		int  lastIndex =0; 
		for(int i=25;i>=0;i--)
		{
			char currentChar = (char)(((int)'a')+i);
			if(arr[i]>0)
			{
				
				if(keepAdding)
				{
					
					int currentIndex = s.indexOf(currentChar, lastIndex);
					if(lastIndex < currentIndex )
					{
						sb.append(currentChar);
						lastIndex = currentIndex;
					}
				}
				else
				{
					sb.append(currentChar);
					keepAdding=true;
					lastChar = currentChar;
					lastIndex = s.indexOf(currentChar);
				}
				
				
			//	currentCompareIndex++;
				
			}
		}
		
		System.out.println(sb.toString());

	}

}
