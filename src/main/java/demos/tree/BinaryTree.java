package demos.tree;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

class A{}
class B extends A{}
class C extends B{};

public class BinaryTree {


	int BinaryTree(int i)
	{
		return i;
	}
	static private void initTree(Node node,int max)
	{
		int data = node.data*2;
		if(data>=max)
		{
			return;
		}
		node.left = new Node(node.data*2);
		node.right = new Node(node.data*2+1);

		initTree(node.left,max);
		initTree(node.right,max);
	}



	public static void main(String[] args) {
		Node root  = new Node(1);
		initTree(root,20);

		traverseReverse(root);


	}





	private static void traverseReverse(Node root) {
		Stack<Node> reverseOrderStack = new Stack<>();

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty())
		{
			Node node = queue.poll();
			reverseOrderStack.push(node);

			if(node.left!=null)
			{
				queue.add(node.left);
			}

			if(node.right!=null)
			{
				queue.add(node.right);
			}

		}

		while(!reverseOrderStack.isEmpty())
		{
			System.out.println(reverseOrderStack.pop().data+" ");
		}

	}


}
