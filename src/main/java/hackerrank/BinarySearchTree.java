package hackerrank;

public class BinarySearchTree {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	
	
	static int[] getMinMax(Node root)
	{
		int minMax[]  = new int [2];
		if(root.left != null && root.right!=null)
		{
			
			int arr1[]=getMinMax(root.left);
			if(arr1==null) return null;
			if(arr1[0]>=root.data || arr1[1]>=root.data)
			{
				return  null;
			}
			else
			{
				minMax[0] = arr1[0];
				
			}
			
			
			int arr[]=getMinMax(root.right);
			if(arr==null) return null;
			if(arr[0]<=root.data || arr[1]<=root.data)
			{
				return  null;
			}
			else
			{
				
				minMax[1] = arr[1];
			}
			
			
			
		}
		else if(root.left == null && root.right!=null)
		{
			int arr[]=getMinMax(root.right);
			if(arr==null) return null;
			if(arr[0]<=root.data || arr[1]<=root.data)
			{
				return  null;
			}
			else
			{
				minMax[0] = root.data;
				minMax[1] = arr[1];
			}
		}
		else if(root.left != null && root.right==null)
		{
			int arr[]=getMinMax(root.left);
			if(arr==null) return null;
			if(arr[0]>=root.data || arr[1]>=root.data)
			{
				return  null;
			}
			else
			{
				minMax[0] = arr[0];
				minMax[1] = root.data;
			}
			
				
		}
		else
		{
			minMax[0] = root.data;
			minMax[1]=root.data;
		}
		
		return minMax;
	}
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		Node a =  new Node(25);
		Node b =  new Node(12);
		Node c =  new Node(36);
		a.left = b;
		a.right = c;
		
		Node e =  new Node(6);
		Node f =  new Node(26);
		
		b.left =e;
		b.right=f;
		
		Node g =  new Node(30);
		Node h =  new Node(36);
		
		c.left = g;
		c.right= h;
		
		int arr[] = getMinMax(a);
		if(arr==null)
		{
			System.out.println("Not binary");
		}
		else
		{
			System.out.println(arr[0]+"  "+arr[1]);
		}
		
		
		
		
	}

}
