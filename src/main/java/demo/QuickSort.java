package demo;

/**
 * Created by maninder on 27/4/17.
 */
public class QuickSort {
    int arr[] ;
    int lenght;

    public void sort(int arrr[])
    {
        arr=arrr;
        lenght=arr.length;
        quickSort(0,lenght-1);
    }

    private void quickSort(int start, int end) {
        int i=start;
        int j = end;

        int pivot = arr[start + (end-start)/2];
        while(i<=j)
        {
            while (arr[i]<pivot)
            {
                i++;
            }
            while (arr[j]>pivot)
            {
                j--;
            }
            if(i<=j)
            {
                exchange(i,j);
                i++;
                j--;
            }
        }
        if(start<j)
        quickSort(start,j);
        if(i<end)
            quickSort(i,end);
    }

    private void exchange(int i, int j) {
            int tmp = arr[i];
        arr[i]= arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
        int arr[] = {12,23,54,65,76,87,98,43,32,21};
        new QuickSort().sort(arr);
        for (int i : arr)
        {
            System.out.print(i+"  ");
        }
    }


}
