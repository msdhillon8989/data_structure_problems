package demos.test;

public class JumbleString {
    public static String orignial(String input1)
    {
        StringBuilder sb = new StringBuilder();
        int start = 0;

        int i = input1.length()-2;
        for(;i>=0;i-=2)
        {
            sb.append(input1.charAt(i));
        }
        if(i==-2)
        {
            i=1;
        }
        else {
            i=0;
        }

        for(;i<input1.length();i+=2)
        {
            sb.append(input1.charAt(i));
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(orignial("cbdae"));
    }
}
