import java.util.Scanner;

class Node {
	public int value;
	public Node next;
}

public class LinkList {
	Node head;

	public void addNode(int num) 
	{
		Node n = new Node();
		n.value=num;
		n.next = head;
		head = n;
	}

	public Node delete(int x) 
	{
		Node t = head;
		Node pre = null;
		Node deleted=null;
		boolean found=false;
		while (t != null) {
			if (t.value == x) 
			{
				found = true;
				break;
			}
			pre = t;
			t = t.next;
		}
		if (found) 
		{
			if (pre == null) 
			{
				deleted=head;
				head = head.next;
			} 
			else 
			{
				deleted=t;
				pre.next=t.next;
				
			}
		}
		
		return deleted;
		

	}

	
	
	public void print()
	{
		Node t = head;
		System.out.println();
		while(t!=null)
		{
			System.out.print(t.value+" ");
			t=t.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) 
	{
		LinkList l = new LinkList();
		
		Scanner s = new Scanner(System.in);
		z: 
		while(true)
		{
			System.out.println("1. Add");
			System.out.println("2. Delete");
			
			int c = s.nextInt();
			
			switch (c) {
			case 1:
				System.out.println("Enter Element");
				int num = s.nextInt();
				l.addNode(num);
				l.print();
				
				break;
			case 2:
				System.out.println("Enter Element To delete");
				num = s.nextInt();
				Node x =l.delete(num);
				if(x==null)
				{
					System.out.println(num+" not found in list");
				}
				else
				{
					l.print();
				}
				
				
				break;
			

			default:
				break z;
			}
			
		}
		
		
	
		
		
	}

}
