package hackerearth;

import java.util.*;

public class CityMap {
    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int city = 1; city < n; city++) {
            if (city <= g) {
                continue;
            }
            for (int nextCity = city + 1; nextCity <= n; nextCity++) {
                if (GCD(city, nextCity) > g) {
                    Set<Integer> nextCities = map.computeIfAbsent(city, k -> new HashSet<>());
                    Set<Integer> nextToNextCities = map.computeIfAbsent(nextCity, k -> new HashSet<>());

                    if (!nextCities.isEmpty()) {
                        for (Integer cityRoad : nextCities) {
                            Set<Integer> set1 = map.get(cityRoad);
                            set1.add(nextCity);
                            nextToNextCities.add(cityRoad);
                        }
                    }


                    if (!nextToNextCities.isEmpty()) {
                        for (Integer connectedCity : nextToNextCities) {
                            Set<Integer> set1 = map.get(connectedCity);
                            set1.add(city);
                            nextCities.add(connectedCity);
                        }
                    }
                    nextCities.add(nextCity);
                    nextToNextCities.add(city);

                }
            }


        }

        for(int i=0;i<originCities.size();i++)
        {
            int originCity = originCities.get(i);
            int destinationCity = destinationCities.get(i);

            Set<Integer> cities = map.get(originCity);
            if(cities != null && cities.contains(destinationCity))
            {
                result.add(1);
            }
            else{
                result.add(0);
            }

        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> c1 = new ArrayList<>();
        List<Integer> c2 = new ArrayList<>();
        c1.add(10);
        c1.add(4);
        c1.add(3);
        c1.add(6);

        c2.add(3);
        c2.add(6);
        c2.add(2);
        c2.add(9);





        List<Integer> integers = connectedCities(10, 1, c1, c2);

        for(int i : integers)
        {
            System.out.println(i);
        }
    }
}

