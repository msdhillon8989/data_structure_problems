

public class Hello {

	/**
	 * @param args
	 */
	
	static void check(String data )
	{
		if(data.isEmpty())
		{
			System.out.println("EMptry");
		}
	}
	
	
	public static String getSearchStrategyQuery(String userId, String clientId, String corpId, String binId, Integer strategyId, String name) 
	{
		
		userId=userId==null?"":userId;
		clientId=clientId==null?"":clientId;
		corpId=corpId==null?"":corpId;
		binId=binId==null?"":binId;
		name=name==null?"":name;
		
		String query = "SELECT client_id, corp_id, bin_id, strategy, name_of_strategy from strategy_transaction WHERE delete_flag='N' ";
		
		boolean isFiltered=false;
		if(strategyId!=null)
		{
			query+="AND strategy='"+strategyId.toString()+"' ";
			isFiltered=true;
		}
		
		if(clientId!="")
		{
			query+="AND client_id='"+clientId+"' ";
			isFiltered=true;
		}
		
		if(corpId!="")
		{
			query+="AND corp_id='"+corpId+"' ";
			isFiltered=true;
		}
		if(binId!="")
		{
			query+="AND bin_id='"+binId+"' ";
			isFiltered=true;
		}
		if(name!="")
		{
			query+="AND name_of_strategy like '"+name+"%' ";
			isFiltered=true;
		}
		
		query+="AND client_id in(SELECT client_id FROM client_map WHERE user_id='"
				+ userId
				+ "')";
		query+=";";
		
		return query;
	}
	
	
	public void divideIntoNumberHavingMaxProduct()
	{
		int num = 8;
		int srt =(int) Math.ceil(Math.sqrt(num));
		long product=1;
		while(num>srt)
		{
			product*=srt;
			System.out.print(srt+"x");
			num-=srt;
		}
		product*=num;
		System.out.print(num+"=");
		System.out.println(product);
	}
	
	 
	static char arr[];
	static char temp[];
	private static String reverseSub(String s,int n,int m)
	{
		//StringBuilder ss = new StringBuilder(s.substring(n,m));
		char chars[] = s.toCharArray();
		char max=chars[n];
		int index =n;
		for(int i=n;i<m;i++)
		{
			max = chars[i];
			index = i;
			for(int j=i+1;j<=m;j++)
			{
				if(max <= chars[j])
				{
					index=j;
					max=chars[j];
					
				}
			}
			chars[index]=chars[i];
			chars[i]=max;
	
		}
		
		StringBuilder ss = new StringBuilder();
		for(char c: chars)
		{
			ss.append(c+"");
		}
		return ss.toString();
	}
	
	
	private static void  mergsort(int l,int h)
	{
		if(l<h)
		{
			int middle = l + (h-l)/2;
			mergsort(l, middle);
			mergsort(middle+1, h);
			merge(l,middle,h);
					
		}
		
		
		
	}
	
	
	private static void merge(int l, int middle, int h) 
	{
		for(int i=l;i<=h;i++)
		{
			temp[i]=arr[i];
		}
		
		int i=l;
		int j=middle+1;
		int k=l;
		
		
		while(i<=middle && j<=h)
		{
			if(temp[i]<=temp[j])
			{
				arr[k]=temp[i];
				i++;
			}
			else
			{
				arr[k]=temp[j];
				j++;
			}
			k++;
		}
		
		
		while(i<=middle)
		{
			arr[k]=temp[i];
			i++;
			k++;
		}
		
//		while(j<=middle)
//		{
//			arr[k]=temp[j];
//			j++;
//			k++;
//		}
//		
	}
	
	public static void main(String[] args) 
	{
		
		
		StringBuilder s = new StringBuilder();
		String ss = "hello";
		int l=0;
		int h=4;
		
		String lower = ss.substring(0,l);
		String end = ss.substring(h+1);
		arr = ss.substring(l,h+1).toCharArray();
		temp = new char[arr.length];
		mergsort(0, arr.length-1);
		
		for(char c:arr)
		{
			s.append(c+"");
		}
		
		
		
		System.out.println(lower+"  "+s.toString()+"  "+end);
		
		
		
	//	System.out.println(ss);
	//	System.out.println(reverseSub(ss,1,3));
		
		
		
		
		
	}

	
}
