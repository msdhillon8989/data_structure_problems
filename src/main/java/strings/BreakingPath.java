package strings;

import java.util.HashMap;
import java.util.Map;

public class BreakingPath {

    //input A.B.C.D.LAB
    //Output
    // LAB with parent A.B.C.D
    // D with parent A.B.C
    // C with parent A.B
    // B with parent A
    // A with no parent

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String groupFullName1 =  "A.B.C.D.LAB1";
        String groupFullName2 =  "A.B.C.D.LAB2";
        String groupFullName3 =  "A.B.C.D.E.LAB3";

        processGroup(map,groupFullName3);
        processGroup(map,groupFullName3);
        processGroup(map,groupFullName1);
        processGroup(map,groupFullName2);
    }

    private static void processGroup(Map<String, String> map, String groupFullName) {

            if(!map.containsKey(groupFullName)) {
                if(!groupFullName.contains("."))
                {
                    System.out.println("Creating parent "+groupFullName);
                }
                else {
                    int lastIndex = groupFullName.lastIndexOf(".");
                    String parent = groupFullName.substring(0, lastIndex);
                    if (!map.containsKey(parent)) {
                        processGroup(map, parent);
                    }
                    String groupName = groupFullName.substring(lastIndex + 1);
                    System.out.println("Create " + groupFullName);
                }
                map.put(groupFullName,"");
            }
    }
}
