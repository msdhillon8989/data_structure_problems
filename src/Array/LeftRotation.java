package Array;

import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int rot = in.nextInt();
		rot = rot%size;
        int arr[] = new int[size];
        
        for(int i=0;i < size; i++)
        {
        	arr[i] = in.nextInt();
        }
        
        for(int i=rot;i < size; i++)
        {
            System.out.print(arr[i]+" ");
        }
        for(int i=0;i < rot; i++)
        {
            System.out.print(arr[i]+" ");
        }

	}

}
