package hackerrank;

public class DoublyLinkedList {

	static class Node{
		int data;
		Node next;
		Node prev;
		
	}
	
	static void print(Node head)
	{
		Node t = head;
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t = t.next;
		}
	}
	
	static Node Reverse(Node head)
	{
		if(head != null)
		{
			Node t =head;
			Node temp = t.next;
			while(t.next!=null)
			{
				temp = t.next;
				t.next = t.prev;
				t.prev = temp;
				t=temp;
			}
			t.next = t.prev;
			t.prev =null;
			
			return t;
		}
		
		return null;
	}
	
	
	static Node sortedInsert(Node head,int data)
	{
		 Node n = new Node();
		    n.data = data;
		    
		    if(head==null)
		        {
		        return n;
		    }
		    else if(head.data > data)
		        {
		        head.prev=n;
		        n.next=head;
		        return n;
		    }
		    else
		        {
		        
		        Node t = head; 
		        
		        while(t.next !=null)
		        {
		            if(t.data >= data)
		            {
		                    t.prev.next = n;
		                    n.prev = t.prev; 
		                    n.next = t;
		                    t.prev = n;
		                    return head;
		            }
		            t = t.next;
		        }
		        if(t.data>=data)
		        {
		        	t.prev.next = n;
                    n.prev = t.prev; 
                    n.next = t;
                    t.prev = n;
                    return head;
		        }
		        else
		        {
		        	t.next = n;
		        	n.prev = t;
		        	
		        }
		        
		        
		        return head;
		    }
		    
	}
	
	public static void main(String[] args) 
	{
		Node head  = null;
		
		head = sortedInsert(head, 4);
		head = sortedInsert(head, 9);
		head = sortedInsert(head, 3);
		head = sortedInsert(head, 5);
		head = sortedInsert(head, 22);
		head = sortedInsert(head, 1);
		head = sortedInsert(head, 7);
		
		
		
		print(head);
		System.out.println();
		head = Reverse(head);
		print(head);
		
		
	}

}
