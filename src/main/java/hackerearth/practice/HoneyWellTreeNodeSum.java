package hackerearth.practice;

import java.io.IOException;

import java.util.Scanner;

/**
 * 
 * @author simanind Crazy tree (value of root node is product of left and right
 *         node) 24 / \ 2 12 /\ /\ 1 2 3 4
 * 
 *         write function S(N,X,Y) = Xth + (X+1)th ..... Yth at level N max
 *         level = 21 ans in module of 1299709
 */
public class HoneyWellTreeNodeSum {

	static int nodes[];
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();

		int totalNodes = 1 << N;
		int firstLeafNode = 1 << (N - 1);
		nodes = new int[totalNodes];

		for (int i = firstLeafNode, j = 1; i < totalNodes; i++, j++) {
			nodes[i] = j % 1299709;
		}
		for (int i = firstLeafNode - 1; i >= 1; i--) {
			nodes[i] = (nodes[i * 2] * nodes[i * 2 + 1]) % 1299709;
		}

		int current = 0;
		for (int i = 0; i < N; i++) {
			int children = 1 << i;
			for (int j = 0; j < children; j++) {
				current++;
				System.out.print(nodes[current] + "  ");
			}
			System.out.println();
		}

		for (int q = 0; q < Q; q++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int base = (1 << n - 1) - 1;
			int sum = 0;
			for (int i = base + x; i <= base + y; i++) {
				sum += nodes[i];
				sum %= 1299709;
			}
			
			
			
			System.out.println(sum);
		}

	}
	
	
	private int S(int n)
	{
		int base = (1 << n - 1) - 1;
		int last = (1 << n);
		int sum = 0;
		for (int i = base ; i < last; i++) {
			sum += nodes[i];
			sum %= 1299709;
		}
		return sum;
		
		
	}

}
