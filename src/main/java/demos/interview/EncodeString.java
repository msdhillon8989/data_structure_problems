package demos.interview;

public class EncodeString {

	public static void main(String[] args) {

		String string = null;

		System.out.println(encode(string));
	}

	static private String encode(String string) {
		if (string == null || string.length() == 0)
			return "";
		char c = string.charAt(0);
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < string.length(); i++) {
			char cc = string.charAt(i);
			if (c == cc) {
				count++;
			} else {
				sb.append(count).append(c);
				c = cc;
				count = 1;
			}
		}
		sb.append(count).append(c);
		return sb.toString();
	}
}
