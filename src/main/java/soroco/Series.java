package soroco;

public class Series {


   /* int s(int i , int i1, int i0){
        if(i == 1)
        {
            return 1;
        }
        else if(i == 0){
            return -1;
        }


    }*/


   static long get2or5(long n)
   {

       int product = 1;
       while(n>0 )
       {
           if(n%5 == 0)
           {
               product*=5;
               n/=5;
           }
           else if(n%2 ==0)
           {
               product*=2;
               n/=2;
           }
           else {
               break;
           }

       }
       return product;

   }

    public static void main(String[] args) {
        long i0 = 0;
        long i1 = 1;
        int n = 40;

        int f0 = 24;  //2*2*2*3
        int f1 = 75;  //5*5

        long count = 0;

        System.out.println(get2or5(24));
        System.out.println(get2or5(24));
        long product = get2or5(f1) * get2or5(f0);

        System.out.println(product);
        int remainder = (int) (product % 10);
        while (remainder == 0) {
            count++;
            product /= 10;
            remainder = (int) (product % 10);
        }

        if (count > 0) {
            for (int i = 2; i <= n; i++) {
                long temp = i1 + i0;
                i0 = i1;
                i1 = temp;
            }
//126491972
            if(i0>0)
            {
                count = count*i0;
            }
        }
        System.out.println(count);


    }
}
