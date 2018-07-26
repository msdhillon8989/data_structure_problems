package demos.interview;

import java.util.HashMap;
import java.util.Map;

public class ReplaceToMakeAnagram {
	public static void main(String[] args) {
		System.out.println(getReplacementCount("abcdd","abcff"));
	}

	static int getReplacementCount(String s1,String s2)
	{

		int count =0;
		if (s1.length() != s2.length())
		{
			return -1;
		}
		else {
			Map<Character,Integer> characterACount = new HashMap<>();


			for(int i=0;i<s1.length();i++)
			{
				Character c = s1.charAt(i);
				addInHM(characterACount,c);
			}

			for(int i=0;i<s2.length();i++)
			{
				Character c = s2.charAt(i);
				if(characterACount.containsKey(c))
				{
					Integer charCount = characterACount.get(c);
					if(charCount ==1)
					{
						characterACount.remove(c);
					}
					else {
						characterACount.put(c,charCount-1);
					}
				}

			}
			for(int val:characterACount.values())
			{
				count+=val;
			}
		}


		return count;
	}

	static void addInHM(Map<Character,Integer> map,Character c)
	{
		if(map.containsKey(c))
		{
			Integer charCount = map.get(c);
			map.put(c,charCount+1);
		}
		else{
			map.put(c,1);
		}
	}
}
