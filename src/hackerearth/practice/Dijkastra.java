package hackerearth.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.sun.javafx.collections.MappingChange.Map;

class City
{
	String name;
	
	City(String name)
	{
		this.name=name;
	}
	
	@Override
	public int hashCode() {
		
		return 31*name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
		{
			return true;
		}
		if(obj==null)
		{
			return false;
		}
		
		if(getClass()!=obj.getClass())
		{
			return false;
		}
		City c = (City)obj;
		return name.equals(c.name);
	}
}

class Road
{
	City source;
	City destination;
	int length;
	

	public Road(String source, String destination, int length) 
	{
		this.source = new City(source);
		this.destination = new City(destination);
		this.length = length;
	}
	
	
	
	
	
}



public class Dijkastra {

	static int V =9;
	public static void dijkastra(int graph[][],int src)
	{
		int dist[] = new int[V];
		boolean settled[] = new boolean[V];
		for(int i=0;i<V;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		settled[src]=true;
		dist[src]=0;
		
		for(int count=0;count<V-1;count++)
		{
			int u = getMinDistanceNode(dist,settled);
			
			settled[u]=true;
			
			
			for(int v=0;v<V;v++)
			{
				if(!settled[v] && graph[u][v]!=0 && dist[u]+graph[u][v]<dist[v])
				{
					dist[v]=dist[u]+graph[u][v];
				}
			}
		}
		
		
	}
	
	private static int getMinDistanceNode(int[] dist, boolean[] settled) {
		int min = Integer.MAX_VALUE;
		int index=-1;
		for(int i=0;i<dist.length;i++)
		{
			if(min>dist[i] && !settled[i])
			{
				index=i;
				min=dist[i];
			}
		}
		return index;
	}

	
	List <City> cities = new ArrayList<>();
	List <Road> roads = new ArrayList<>();
	Set<City> visited = new HashSet<>();
	Set<City> nextCities = new HashSet<>();
	HashMap<City, City> predecessor = new HashMap<City,City>();
	HashMap<City, Integer> distance = new HashMap<City,Integer>();
	
	
	public void dijkastraAlgo(City source)
	{
		distance.put(source, 0);
		nextCities.add(source);
		
		while(nextCities.size()>0)
		{
			City nearestCity = getNearestCity(nextCities);
			visited.add(nearestCity);
			nextCities.remove(nearestCity);
			City pre = predecessor.get(nearestCity);
		//	String name = pre==null?nearestCity.name:pre.name;
					
			System.out.println(nearestCity.name +" from "+source.name+"  "+distance.get(nearestCity));
			for(Road next : getNeighbour(nearestCity))
			{
				if(getShortestDistance(next.destination) > getShortestDistance(nearestCity)+ next.length )
				{
					distance.put(next.destination, getShortestDistance(nearestCity)+ next.length);
					nextCities.add(next.destination);
					predecessor.put(next.destination,nearestCity);
				}
			}
		}
	}
	
	
	
	public int getShortestDistance(City c)
	{
		Integer dis = distance.get(c);
		if(dis==null)
		{
			return Integer.MAX_VALUE;
		}
		return dis;
	}
	
	private List<Road> getNeighbour(City nearestCity) {
		ArrayList<Road> neighbour = new ArrayList<>();
		
		for(Road road : roads)
		{
		//	System.out.println("Nest Road "+road.destination.name +" "+road.source.equals(nearestCity) +"  "+!visited.contains(road.destination)  );
			if((road.source.equals(nearestCity) && !visited.contains(road.destination)) )
			{
				neighbour.add(road);
			}
			if((road.destination.equals(nearestCity) && !visited.contains(road.source)) )
			{
				Road r = new Road(road.destination.name,road.source.name,road.length);
				neighbour.add(r);
			}
		}
		return neighbour;
	}

	private City getNearestCity(Set<City> nextCities2) {
		City nearestCity=null;
		int mininum=Integer.MAX_VALUE;
		for(City c: nextCities2)
		{
			if(mininum>=distance.get(c))
			{
				nearestCity=c;
				mininum=distance.get(c);
			}
		}
		return nearestCity;
	}

	
	 public LinkedList<City> getPath(City target) 
	 {
		    LinkedList<City> path = new LinkedList<City>();
		    City step = target;
		    // check if a path exists
		    if (predecessor.get(step) == null) {
		      return null;
		    }
		    path.add(step);
		    while (predecessor.get(step) != null) {
		      step = predecessor.get(step);
		      path.add(step);
		    }
		    // Put it into the correct order
		    Collections.reverse(path);
		    return path;
		  }

		 

	
	
	public static void main(String[] args) 
	{
		Dijkastra d = new Dijkastra();
		d.cities.add(new City("Amritsar"));
		d.cities.add(new City("TarnTaran"));
		d.cities.add(new City("Jalandhar"));
		d.cities.add(new City("Ludhiana"));
		d.cities.add(new City("Patti"));
		d.cities.add(new City("Chandigarh"));
		d.cities.add(new City("Delhi"));
		
		d.roads.add(new Road("Amritsar","TarnTaran",20));
		d.roads.add(new Road("Amritsar","Jalandhar",80));
		d.roads.add(new Road("TarnTaran","Jalandhar",80));
		d.roads.add(new Road("Jalandhar","Ludhiana",40));
		d.roads.add(new Road("TarnTaran","Patti",70));
		d.roads.add(new Road("Jalandhar","Chandigarh",120));
		d.roads.add(new Road("Ludhiana","Chandigarh",70));
		d.roads.add(new Road("Patti","Delhi",210));
		d.roads.add(new Road("Ludhiana","Delhi",190));
		d.roads.add(new Road("Ludhiana","Patti",50));
		d.roads.add(new Road("Chandigarh","Delhi",200));
			
		d.dijkastraAlgo(new City("Ludhiana"));
		

	}

}
