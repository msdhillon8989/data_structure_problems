package hackerearth.practice;

import java.util.Scanner;

class Altimatrix2 {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		boolean[] ids = null;

		int cases = s.nextInt();

		while(cases-->0) 
		{
			int totalIds = s.nextInt();

			int users[] = new int[2];

			users[0] = s.nextInt();
			users[1] = s.nextInt();
			ids = new boolean[totalIds + 1];

			for (int userPens : users) {
				for (int j = 0; j < userPens; j++) {
					int penId = s.nextInt();
					ids[penId] = true;
				}
			}

			boolean possible = true;

			for (int j = 1; j < ids.length; j++) {
				if (!ids[j]) {
					possible = false;
					break;
				}
			}

			if (possible) {
				System.out.println("They can");
			} else {
				System.out.println("They can't");
			}

		}
	}
}
