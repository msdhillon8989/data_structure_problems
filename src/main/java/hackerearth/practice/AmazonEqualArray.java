package hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AmazonEqualArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		while (cases-- > 0) {

			String inputs[] = br.readLine().split(" ");

			int size = Integer.parseInt(inputs[0]);
			ArrayList<Integer> al = new ArrayList<>(3);

			int arr[] = new int[size];
			
			al.add(Integer.parseInt(inputs[1]));
			al.add(Integer.parseInt(inputs[2]));
			al.add(Integer.parseInt(inputs[3]));

			Collections.sort(al);
			Collections.reverse(al);

			String array = br.readLine();
			
			 int pos = 0, end;
			 int index=0;
	            while ((end = array.indexOf(' ', pos)) >= 0) {
	                arr[index]=Integer.parseInt(array.substring(pos, end));
	           
	                index++;
	                pos = end + 1;
	            }
	            
	            arr[index]=Integer.parseInt(array.substring(pos, array.length()));
               
			for (int i = 0; i < al.size()-1; i++) {
				for (int j = i+1; j < al.size(); j++) {
					
					if (al.get(i) == al.get(j)) {
						al.remove(j);
						i--;
					}
				}
			}
			
			boolean possible=true;
			for(int i=0;i<size;i++)
			{
				
				for(int divider:al)
				{
					while(arr[i]%divider==0 )
					{
						
						arr[i]=arr[i]/divider;
						
					}
				}
				if(i>0 && arr[i]!=arr[i-1])
				{
					possible=false;
					break;
				}
			}
			
			if(possible)
			{
				System.out.println("She can");
			}
			else{
				System.out.println("She can't");
			}
			
			

		}

	}

}
