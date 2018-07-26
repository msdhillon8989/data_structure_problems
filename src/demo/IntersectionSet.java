package demo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by maninder on 22/11/16.
 */
public class IntersectionSet
{
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        s1.add("String1");
        s1.add("String4");

        s2.add("String3");
        s2.add("String2");


        Set<String> s3 = new HashSet<>(s1.stream().filter(s -> s2.contains(s)).collect(Collectors.toList()));

        for(String c : s3)
        {
            System.out.println(c);
        }
    }
}
