package demo;

/**
 * Created by maninder on 18/1/17.
 */
public class Palindrom {
    public static void main(String[] args) {

        System.out.println(isPalindrome("Madam, I'm Adam."));
    }

    private static boolean isLowerCase(int c)
    {
        if(c>=97 && c<=122)
        {
            return true;
        }
        return false;
    }

    private static boolean isUpperCase(int c)
    {
        if(c>=65 && c<=90)
        {
            return true;
        }
        return false;
    }


    private static boolean isNotAlphabet(int c)
    {
        if(isLowerCase(c) || isUpperCase(c))
        {
            return false;
        }
        return true;
    }
    private static boolean isPalindrome(String s)
    {

        int i=0; int j=s.length()-1;
        while(i<=j)
        {
            int ic = s.charAt(i);
            int jc = s.charAt(j);
            if(isNotAlphabet(ic))
            {
                i++;
                continue;
            }
            if(isNotAlphabet(jc))
            {
                j--;
                continue;
            }
            if(isLowerCase(ic))
            {
                ic-=32;

            }
            if(isLowerCase(jc))
            {
                jc-=32;
            }

            if(ic!=jc)
            {
                return  false;
            }
            i++;
            j--;
        }
        return true;
    }
}
