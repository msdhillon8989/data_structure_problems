package hackerearth.practice;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SAPFindIntegerInPathRecursive
{
	static int nodeValue[] ; 
	static Vertex adj[];
	static boolean visited[];
	static boolean integerFound[];
	static Vertex path;
	
	public static void getPath(int s,int d)
	{
		visited[s-1]=true;
		Vertex v = new Vertex(s);
		v.neighbour=path;
		path=v;
		
		if(s==d)
		{
			int integerCount=0;
			 while(v!=null)
        	 {
        		// System.out.print(v.vertex+" ");
        		 
        		 if(!integerFound[nodeValue[v.vertex-1]])
        		 {
        			 integerFound[nodeValue[v.vertex-1]]=true;
        			 integerCount++;
        		 }
        		 v = v.neighbour;
        		 
        	 }
			 System.out.println(integerCount);
		}
		else
		{
			Vertex neighbour =  adj[s-1];
			
			 while(neighbour!=null)
        	 {
				 if(!visited[neighbour.vertex-1])
					 getPath(neighbour.vertex, d);
        		 neighbour = neighbour.neighbour;
        	 }
				
		}
		
		path = path.neighbour;
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodes = Integer.parseInt(br.readLine());
		
		nodeValue = new int[nodes];
		String array = br.readLine();
		 int pos = 0, end;
		 int index=0;
         while ((end = array.indexOf(' ', pos)) >= 0) 
         {
         	try
         	{
         		nodeValue[index]=Integer.parseInt(array.substring(pos, end));
         		index++;
         		pos = end + 1;
         	}
         	catch(Exception xx)
         	{
         		
         	}
         }
         try
         {
         	nodeValue[index]=Integer.parseInt(array.substring(pos, array.length()));
         }
         catch(Exception xx)
         {
         	
         }
         adj = new Vertex[nodes];
         
         for(int i=0;i<nodes-1;i++)
         {
        	 String input = br.readLine();
 			int s = Integer.parseInt(input.substring(0, input.indexOf(" ")));
 			int d = Integer.parseInt(input.substring(input.indexOf(" ")+1));
 			
 			Vertex v1 = new Vertex(d);
 			Vertex v2 = new Vertex(s);
 			
 			
 			v1.neighbour = adj[s-1];
 			adj[s-1]=v1;
 			
 			v2.neighbour = adj[d-1];
 			adj[d-1]=v2;
 			
 			
 			
         }
		
         
         int queries = Integer.parseInt(br.readLine());
         while(queries-->0)
         {
        	 String input = br.readLine();
  				int s = Integer.parseInt(input.substring(0, input.indexOf(" ")));
  				int d = Integer.parseInt(input.substring(input.indexOf(" ")+1));
  				visited=new boolean[nodes];
  				integerFound = new boolean[101];
  				System.gc();
  				getPath(s, d);
  				
         }
         
/*         int vertx=1;
         for(Vertex v : adj)
         {
        	 System.out.print("Neighbour of "+vertx++ + " are " );
        	 while(v!=null)
        	 {
        		 System.out.print(v.vertex+" ");
        		 v = v.neighbour;
        	 }
        	 System.out.println();
         }
         
         
         getPath(2, 4);
         System.out.println();
         visited = new boolean[nodes];
         getPath(1, 4);
    */     
	}

}
