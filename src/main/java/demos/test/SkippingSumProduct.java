package demos.test;

import java.util.HashMap;
import java.util.Map;

public class SkippingSumProduct {

	private static int arr[] = new int[8];
	private static Map<String, Long> sum = new HashMap<>();
	private static boolean memorize = false;
	public static void main(String[] args) {
		arr[0] = -1;
		arr[1] = -1;
		arr[2] = -1;
		arr[3] = -1;
		arr[4] = -1;
		arr[5] = -1;
		arr[6] = -1;
		arr[7] = 6;
		/*arr[3] = -1;
		arr[4] = -1;
		arr[5] = -1;
		arr[6] = 9;*/

		System.out.println(maxSumProduct(1, 0));
		System.out.println(count);

	}
	private static int count =0;
	private static long maxSumProduct(int item, int i) {
		count++;
		if (i == arr.length) {
			return 0;
		}
		if(memorize) {
			String key = item + "-" + i;
			Long currentSum = sum.get(key);
			if (currentSum != null) {
				return currentSum;
			}
		}
		long current = item * arr[i];


		if (arr[i] < 0) {


			long included = current + maxSumProduct(item + 1, i + 1);
			long notIncluded = maxSumProduct(item, i + 1);
			if (included > notIncluded) {
				sum.put((item + 1) + "-" + (i + 1), included - current);
				current = included;
			} else {
				sum.put((item) + "-" + (i + 1), notIncluded);
				current = notIncluded;
			}
		} else {

			long sumOfPendingList = maxSumProduct(item + 1, i + 1);
			sum.put((item + 1) + "-" + (i + 1), sumOfPendingList);

			current = current + sumOfPendingList;
		}

		return current;

	}

	private static long max(long a, long b) {
		return a > b ? a : b;
	}


}
