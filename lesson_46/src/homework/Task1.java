package homework;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 50);
        map1.put("banana", 20);
        map1.put("cherry", 30);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 25);
        map2.put("cherry", 30);
        map2.put("date", 40);

        Map<String, Integer> intersectionMap = intersection(map1, map2);
        intersectionMap.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    public static Map<String, Integer> intersection(Map<String, Integer> map1, Map<String, Integer>map2) {
        Map<String, Integer> result = new HashMap<>();
        map1.forEach((k,v)->{
            if (map2.containsKey(k))
                result.put(k,v);
        });
        return result;
    }
}
