package demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by maninder on 11/7/17.
 */
public class COllectionTest {
    public static void main(String[] args) {
        Map<String,Map<String,Entity>> regionMetricDatumMap = new HashMap<>();
        regionMetricDatumMap.put("A",new HashMap<>());
        regionMetricDatumMap.put("B",new HashMap<>());
        regionMetricDatumMap.get("A").put("AA",new Entity(1,1));
        regionMetricDatumMap.get("A").put("AB",new Entity(1,2));
        regionMetricDatumMap.get("A").put("AC",new Entity(1,3));
        regionMetricDatumMap.get("A").put("AD",new Entity(1,4));

        regionMetricDatumMap.get("B").put("BA",new Entity(1,1));
        regionMetricDatumMap.get("B").put("BB",new Entity(1,2));
        regionMetricDatumMap.get("B").put("BC",new Entity(1,3));
        regionMetricDatumMap.get("B").put("BD",new Entity(1,4));

        for(String region : regionMetricDatumMap.keySet())
        {
            List<Entity> values = regionMetricDatumMap.get(region).values().stream().map(entity -> entity).collect(Collectors.toList());
            System.out.println(values);
        }


    }
}
class Entity{
    int a;
    int b;

    public Entity(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
