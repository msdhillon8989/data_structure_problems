import java.util.HashSet;

public class CheckDuplicate {

	public static void main(String[] args) 
	{
		HashSet<Integer> unique = new HashSet<>();
		HashSet<Integer> duplicate = new HashSet<>();
		int arr[] = {1,2,3,4,5,6,7,3,4,5};
		for(int i=0;i<arr.length;i++)
		{
			if(!unique.add(arr[i]))
			{
				duplicate.add(arr[i]);
			}
		}
		System.out.println(duplicate.size());
	}

}
