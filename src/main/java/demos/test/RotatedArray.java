package demos.test;

public class RotatedArray {
    public static void main(String[] args) {
        int array[] = {2,2,1,2,2,2,2,2};

        int srrayStartPoint = getArrayStartPoint(array);

        System.out.println("first element array["+srrayStartPoint+"] = " + array[srrayStartPoint] );
    }


    private static int getArrayStartPoint(int array[])

    {
        int start  =0 ;
        int end = array.length-1;

        int mid =0;

        while(start<=end)
        {
            mid = start + (end-start)/2;
            if(mid>0 && array[mid]<array[mid-1])
            {
                return mid;
            }else if (mid<end && array[mid+1]<array[mid])
            {
                return mid+1;
            }

            if(array[start] > array[mid])
            {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return mid;
    }
}
