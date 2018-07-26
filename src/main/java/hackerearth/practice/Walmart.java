package hackerearth.practice;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	public int value;
	public int capacity;
	public Node parent, left, right;

	public Node(int value) {
		this.value = value;

	}
}

public class Walmart {
	static long min = Long.MAX_VALUE;
	static ArrayList<Node> path = new ArrayList<>();
	// static ArrayList<Node> shortestPath = new ArrayList<>();

	public static void main(String[] args) {
		Node nodes[];
		Scanner s = new Scanner(System.in);
		int junctions = s.nextInt();
		nodes = new Node[junctions];

		int queues = s.nextInt();
		Node rootNode = null;
		while (queues-- > 0) {
			int entry = s.nextInt();
			int junction = s.nextInt();
			int capacity = s.nextInt();
			Node _entry = null;
			Node parent = null;
			if (nodes[entry - 1] != null) {
				_entry = nodes[entry - 1];
			} else {
				_entry = new Node(entry);
				nodes[entry - 1] = _entry;
			}

			if (nodes[junction - 1] != null) {
				parent = nodes[junction - 1];

			} else {
				parent = new Node(junction);
				nodes[junction - 1] = parent;

			}

			if (parent.parent == null) {
				rootNode = parent;
			}

			_entry.capacity = capacity;
			_entry.parent = parent;

			if (parent.left == null) {
				parent.left = _entry;
			} else {
				parent.right = _entry;
			}

		}

		// System.out.println("rootNode"+rootNode.value );
		dfs(rootNode, 0, 0);

		// System.out.println("Min Path lenght "+ min);
		/*
		 * StringBuilder sb = new StringBuilder(); int total = 0; for(int
		 * i=shortestPath.size()-1;i>=0;i--) { Node n = shortestPath.get(i);
		 * long multiple = 2<<(i-1); total+= n.capacity*multiple;
		 * sb.append(n.value+" -> ");
		 * 
		 * }
		 */ // total = total+ (2<<(shortestPath.size()-2))-1;

		// System.out.println(total);
		// sb.setLength(sb.length()-4);
		System.out.println(sb.toString());

		/*
		 * for(Node n : shortestPath) { System.out.println(n.value); }
		 */
	}

	static StringBuilder sb = new StringBuilder();

	private static void dfs(Node rootNode, long capacity, int level) {
		path.add(rootNode);
		long multiple = 2 << (level - 1);
		if (rootNode.left != null) {
			if(rootNode.right!=null)
			{
				if(rootNode.right.capacity > rootNode.left.capacity )
					dfs(rootNode.left, capacity + rootNode.capacity * multiple + 1 , level + 1);
				else
					dfs(rootNode.left, capacity + rootNode.capacity * multiple  , level + 1);
				
			}
				
			else
			{
				multiple = 2 << (level - 2);
				dfs(rootNode.left, capacity + rootNode.capacity * multiple, level);
			}
		}
		if (rootNode.right != null) {
			if(rootNode.right.capacity < rootNode.left.capacity )
			dfs(rootNode.right, capacity + rootNode.capacity * multiple+1, level + 1);
			else
			{
				dfs(rootNode.right, capacity + rootNode.capacity * multiple, level + 1);
			}
		}

		if (rootNode.left == null) {
			long currentCapacity = capacity + rootNode.capacity * multiple;
			if (currentCapacity <= min) {

				// min = pathLength+rootNode.capacity;
				// shortestPath.clear();
				// shortestPath.addAll(path);
				if (currentCapacity != min) {
					min = currentCapacity;
					sb.setLength(0);
					sb.append(min+1);
				}
				sb.append("\n");
				for (int i = path.size() - 1; i >= 0; i--) {
					Node n = path.get(i);
				//	System.out.print(n.capacity+ " ");
					sb.append(n.value + " -> ");
				}
				sb.setLength(sb.length() - 4);

			}

		}
		/*
		 * if(rootNode.parent!=null) { System.out.println(rootNode.value +" - "
		 * +rootNode.parent.value+"  = "+rootNode.capacity );
		 * 
		 * }
		 */
		path.remove(rootNode);
	}

}
