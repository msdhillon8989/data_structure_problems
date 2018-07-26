package demos.interview;

import java.util.Stack;

public class BalanceParanthesis {

	static private int findIndex(String string, int i) {
		Stack<Integer> stack = new Stack<>();

		int counter = 0;
		int index = -1;
		for (int j = 0; j < string.length(); j++) {
			char cc = string.charAt(j);

			if (cc == '(') {
				counter++;
				stack.push(counter);
			} else if (cc == ')') {
				if (stack.isEmpty()) {
					return -1;
				} else {
					int ii = stack.pop();
					if (ii == i) {
						index = j;
					}
				}
			}
		}

		if (stack.size() == 0) {
			return index + 1;
		}
		return -1;
	}


	public static void main(String[] args) {
		System.out.println(findIndex("(i want (to write a language parser), would (you) help me)", 2));
	}
}
