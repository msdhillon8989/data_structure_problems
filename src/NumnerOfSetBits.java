
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumnerOfSetBits {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			int count = 0;
			while (n > 0) {
				n = n & (n - 1);
				count++;
			}
			System.out.println(count);

		}

	}
}
