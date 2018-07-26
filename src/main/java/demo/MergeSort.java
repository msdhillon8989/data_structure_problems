package demo;

/**
 * Created by maninder on 27/4/17.
 */

class MergeSortAlgo{
    int numbers[];
    int tmp[];
    MergeSortAlgo(int arr[])
    {
        numbers =arr;
        tmp= new int[arr.length];
    }

    public void sort()
    {
        mergeSort(0,numbers.length-1);
    }

    private  void mergeSort(int start, int end) {

        if(start<end)
        {
            int mid = start+(end-start)/2;
            mergeSort(start,mid);
            mergeSort(mid+1,end);
            merge(start,mid,end);
        }

    }

    private  void merge(int start, int mid, int end) {
        for(int i=start;i<=end;i++)
            tmp[i]=numbers[i];
        int k=start;
        int x=start;
        int y = mid+1;
        while(x<=mid && y<=end)
        {
            if(tmp[x]>tmp[y])
            {
                numbers[k++]=tmp[y++];
            }
            else{
                numbers[k++]=tmp[x++];
            }
        }

        while(x<=mid)
        {
            numbers[k++]=tmp[x++];
        }
    }
}


public class MergeSort
{
    public static void main(String[] args) {
        int arr[] = {42,34,56,23,21};
        new MergeSortAlgo(arr).sort();
        for(int i:arr)
        {
            System.out.print(i+" ");
        }

    }


}
