package hackerrank;

import com.sun.scenario.effect.Merge;

class Node
{
	int data;
	Node next;
	
}

public class LinkedList {

	
	static Node insert(Node head , int data)
	{
		Node n = new Node();
		n.data=data;
		n.next = null;
		if(head!=null)
		{
			n.next=head;
		}
		
		return n;
	}
	
	
	static void print(Node head)
	{
		Node t = head;
		while(t!=null)
		{
			System.out.println(t.data);
			t = t.next;
		}
	}
	
	
	static Node Reverse(Node head) 
	{
	    if(head==null)
	    {
	        return head;
	    }
	    else if(head.next==null)
	    {
	        return head;
	    }
	    else
	    {
	        
	         Node t = head;
	         
	        t=t.next;
	        head.next=null;
	        Node next ,pre = head;
	        while(t!=null)
	        {
	            next = t.next;
	            t.next = pre;
	            pre = t;
	            t = next;
	        }    
	        return pre;
	        
	    }
	}
	
	
	static 	int   CompareLists(Node headA, Node headB) 
	{
		if(headA==null && headB==null)
		{
			return 1;
		}
		else
		{
			while(headA!=null && headB!=null)
			{
				if(headA.data != headB.data)
				{
					return 0;
				}
				headA = headA.next;
				headB = headB.next; 
			}
			
			if(headA == null && headB==null)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	  
	}
	static Node MergeLists(Node headA, Node headB) 
	{
		Node newList = null;
		Node lastNode;
		
		if(headA ==null)
		{
			return headB;
		}
		else if (headB == null)
		{
			return headA;
		}
		else
		{
			if(headA.data <= headB.data)
			{
				newList = headA;
				lastNode = headA;
				headA = headA.next;
			}
			else
			{
				newList = headB;
				lastNode = headB;
				headB = headB.next;
			}
			
			while(headA!=null && headB!=null)
			{
				if(headA.data <= headB.data)
				{
					lastNode.next = headA;
					lastNode = headA;
					headA = headA.next;
				}
				else
				{
					
					lastNode.next = headB;
					lastNode = headB;
					headB = headB.next;
				}
				
			}
			
			while(headA!=null)
			{
				lastNode.next = headA;
				lastNode = headA;
				headA = headA.next;
			}
			
			while(headB!=null)
			{
				lastNode.next = headB;
				lastNode = headB;
				headB = headB.next;
			}
						
			
			
			
			
		}
		
		
		
		
		return newList;
	     

	}
	
	
	static int GetNode(Node head,int n) 
	{
	    Node t = head;
	    Node t2  = head;
	    
	    while(n-->0)
	    {
	    	t2 = t2.next;
	    	
	    }
	    
	    while(t2.next!=null)
	    {
	    	t2 = t2.next;
	    	t = t.next;
	    }
	    
	    return t.data;

		
	}
	
	
	static Node RemoveDuplicates(Node head) 
	{
		Node lastElement = head;
		
		Node t = head.next;
		
		while(t!=null)
		{
			if(t.data!=lastElement.data)
			{
				lastElement.next=t;
				lastElement=t;
				
			}
			t=t.next;
			
		}
		lastElement.next=null;
		return head;
	
	}
	
	static Node generateCyclicLinkedList()
	{
		Node n = new Node();
		n.data =1;
		
		Node n1 = new Node();
		
		n1.data=2;
		n.next = n1;
		Node n2 = new Node();
		n2.data=3;
		n1.next = n2;
		Node n3 = new Node();
		n3.data=4;
		n2.next = n3;
		Node n4 = new Node();
		n4.data=5;
		n3.next = n4;
		Node n5 = new Node();
		n5.data=3;
		n4.next = null;
		
		n5.next = null;
		
		
		return n;
	}
	
	
	static boolean hasCycle(Node head) 
	{
		Node t1 = head;
		
		if(head==null || head.next==null || head.next.next==null)
		{
			return false;
		}
		
		Node t2 = head.next.next;
		
		while(t1!=null && t2!=null )
		{
			if(t1 == t2)
			{
				return true;
			}
			t1=t1.next;
			t2 = t2.next;
			if(t2!=null)
			{
				t2=t2.next;
			}
			else
			{
				break;
			}
			
		}
		
		
		return false;
	}
	
	
	static int FindMergeNode(Node headA, Node headB) 
	{
		Node t1 = headA;
		Node t2 = headB;
		
		int size1 =0;
		int size2=0;
		while(t1!=null)
		{
			size1++;
			t1=t1.next;
			
		}
		System.out.println(size1);
		while(t2!=null)
		{
			size2++;
			t2=t2.next;
		}
		System.out.println(size2);
		if(size1>size2)
		{
			int diff = size1-size2;
			t1=headA;
			t2=headB;
			while(diff-->0)
			{
				t1 = t1.next;
			}
		}
		else
		{
			int diff = size2-size1;
			t2=headA;
			t1=headB;
			while(diff-->0)
			{
				t1 = t1.next;
			}
		}
		
		while(t1!=t2)
		{
			t1=t1.next;
			t2=t2.next;
		}
		
		return t1.data;
		

	}
	
	
	static void mergedList()
	{

		Node y = new Node();
		y.data =740;
		Node y1 = new Node();
		y1.data=2;
		y.next = y1;
		y1 = null;
		
		
		
		Node n = new Node();
		n.data =1;
		Node n1 = new Node();
		n1.data=2;
		n.next = n1;
		Node n2 = new Node();
		n2.data=3;
		n1.next = n2;
		Node n3 = new Node();
		n3.data=4;
		n2.next = n3;
		Node n4 = new Node();
		n4.data=5;
		n3.next = n4;
		n.next = n4;
		n4.next = y;
		
		
		Node x = new Node();
		x.data =1;
		Node x1 = new Node();
		x1.data=2;
		x.next = x1;
		Node x2 = new Node();
		x2.data=3;
		x1.next = x2;
		Node x3 = new Node();
		x3.data=4;
		x2.next = x3;
		Node x4 = new Node();
		x4.data=5;
		x3.next = x4;
		
		Node x5 = new Node();
		x5.data=3;
		x4.next = x5;
		x5.next = y;
		
		
		System.out.println(FindMergeNode(x, n));
		
	}
	
	
	
	//static Node head =null;
	public static void main(String[] args) 
	{
		Node  head1 =null;
		Node  head2 =null;
		
		head1 = insert(head1, 8);
		head1 = insert(head1, 7);
		head1 = insert(head1, 4);
		head1 = insert(head1, 4);
		head1 = insert(head1, 4);
		head1 = insert(head1, 3);
		head1 = insert(head1, 2);
		head1 = insert(head1, 2);
		head1 = insert(head1, 2);
		
		head1 = insert(head1, 1);
		
		head2 = insert(head2, 9);
		head2 = insert(head2, 6);
		head2 = insert(head2, 5);
		head2 = insert(head2, 3);
		head2 = insert(head2, 1);
		
	//	System.out.println(CompareLists(head1, head2));
		
	//	print(MergeLists(head1, head2));
		
	//	System.out.println(GetNode(head1, 2));
		
	//	head = Reverse(head);
		
		//print(RemoveDuplicates(head1));
		
	//	Node n =generateCyclicLinkedList();
		
	//	System.out.println(hasCycle(n));
		mergedList();
		

	}

}
