package demos.test;

import static demos.test.CommonUtils.convertUTCtoCurrent;
import static demos.test.CommonUtils.getCurrentUTCDate;

public class Test {
    public static void main(String[] args) {

        patternMatch();


    }

    public static void dateConversionTest()
    {
        String datePassed = "2017-12-01 13:05:00";

        System.out.println(getCurrentUTCDate().toString());

        System.out.println(convertUTCtoCurrent(datePassed).toString());
    }

    private static void patternMatch()
    {
        String regex = "[0-9]+";
        String data = "233434538";
        System.out.println(data.matches(regex));
    }
}
