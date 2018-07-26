

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;


class Item implements Comparable<Item>
{
	String name;
	int value;
	int weight;
	public Item(String data)
	{
		String _data[] = data.split(" ");
		name = _data[0];
		value = Integer.parseInt(_data[1]);
		weight = Integer.parseInt(_data[2]);
		
		
	}
	@Override
	public int compareTo(Item o) {
		
		return o.value-value;
	}
	
	public String toString()
	{
		return name+"  "+value+" "+weight;
	}
}

public class Backpack {

	
	static int arr[];
	
		
	
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		ArrayList<Item> items =  new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("No of items");
		int totalItems  = Integer.parseInt(br.readLine());
		System.out.println("Enter Capacity");
		int capacity = Integer.parseInt(br.readLine());
		
		for(int i=0;i<totalItems;i++)
		{
			items.add(new Item(br.readLine()));
		}
		
		Collections.sort(items);
		int selectedItemsWeight=0;
		int maxValue=0;
		for(int i=0;i<items.size();i++)
		{
			
			Item currentItem = items.get(i);
		
			if(capacity >= (selectedItemsWeight+currentItem.weight))
			{
			
				selectedItemsWeight=selectedItemsWeight+currentItem.weight;
				maxValue=maxValue+currentItem.value;
				System.out.println(currentItem.toString());
			}
			
		}
		
		System.out.println("MAx Value"+maxValue);
		System.out.println(selectedItemsWeight);
		


	}

}
