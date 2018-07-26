package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//LendingKart Hiiring challange

public class WordInWordPassword {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0;i<n;i++)
		{
			String pass[] = br.readLine().split(" ");
			boolean possible=false;
			if(pass[1].length()==2*pass[0].length())
			{
				int index = pass[1].indexOf(pass[0]);
				if(index!=-1)
				{
					String s1=pass[1].substring(0, index);
					 s1+= pass[1].substring(index+pass[0].length());
					 System.out.println(s1);
					if(s1.equalsIgnoreCase(pass[0]))
					{
						possible=true;
					}
				}
			}
			System.out.println(possible?"Possible":"Impossible");
		}
	}

}
