package hackerrank;

import java.util.Scanner;

public class TreeSwapNodes {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int total = s.nextInt();
		Node nodes[] = new Node[total]; 
		for(int i=0;i<total;i++)
		{
			nodes[i] = new Node(i+1);
		}
		Node head = nodes[0];
		for(int i=0;i<total;i++)
			{
				int left = s.nextInt();
				int right = s.nextInt();
				if(left != -1)
				{
					nodes[i].left = nodes[left-1];
					
				}
				if(right != -1)
				{
					nodes[i].right = nodes[right-1];
					
				}
				
			}
		
		int cases = s.nextInt();
		while(cases-->0)
		{
			int level = s.nextInt();
			//printInorder(head);
			
			swap(head,1,level);
			printInorder(head);
			System.out.println();
		}
			
		
	}


	private static void printInorder(Node head) 
	{
		if(head!=null)
		{
			printInorder(head.left);
			System.out.print(head.data+" ");
			printInorder(head.right);
		}
		
	}


	private static void swap(Node head, int i, int level) 
	{
		if(head.left!=null )
		{
			swap(head.left, i+1, level);
		}
		if(head.right!=null )
		{
			swap(head.right, i+1, level);
		}
		
		if(i%level == 0 )
		{
			Node temp = head.left;
			head.left = head.right;
			head.right = temp;
		}
		
	}

}
