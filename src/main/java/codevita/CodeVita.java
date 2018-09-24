package codevita;

public class CodeVita {
    public static void main(String[] args) {
        int init = 9;
        int x = 5,y=12;

        int jump = 1;

        while(true)
        {
            int hopValue = y*jump;

            if((hopValue - init)%x == 0)
            {
                System.out.println(jump);
                break;
            }
            jump++;
        }
    }
}
