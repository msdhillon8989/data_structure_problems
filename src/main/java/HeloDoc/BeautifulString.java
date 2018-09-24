package HeloDoc;

/**
 * how many strings u can create of size n using only vowels.those strings has to be lexicographically sorted
 * <p>
 * eg if n =2
 * <p>
 * aa ae ai ao au
 * ee ei eo eu
 * ii io iu
 * oo ou
 * iu
 */
public class BeautifulString {

    public static void main(String[] args) {

        System.out.println(getCount(5, 0, 200));
    }


    private static long getCount(int current, int currentLevel, int level) {
        if (currentLevel == level) {
            return 1;
        }

        long total = 0;
        for (int i = 1; i <= current; i++) {
            total += getCount(i, currentLevel + 1, level);
        }
        return total;
    }
}
