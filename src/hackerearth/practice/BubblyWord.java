package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubblyWord {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int x=0;x<n;x++)
		{
		String s = br.readLine();
		boolean d[] = new boolean[s.length()];
		boolean bubbly = true;
		boolean found = false;
		z: for (int i = 0; i < s.length(); i++) 
		{
			if (!d[i]) 
			{
				found=false;
				for (int j = i + 1; j < s.length(); j++) 
				{
					if (d[j]) 
					{
						bubbly = false;
						break z;
					} 
					else if (s.charAt(i) == s.charAt(j)) 
					{
						d[j] = true;
						found=true;
						break;
					}
				}
				if(!found)
				{
					bubbly = false;
					break z;
				}
			}
			d[i] = true;
		}

		System.out.println(bubbly ? "YES" : "NO");
		}

	}

}
