package homework;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1,3,4,5,2,1,3,26,746,3,2));
        System.out.println("Integers: " + getRetains(ints, List.of(1,3,2)));

        List<String> strings = new ArrayList<>(List.of("all", "around", "the", "mulberry", "bush",
                "the", "doggie", "chased", "the", "weasel"));
        System.out.println("Strings: " + getRetains(strings, List.of("bush","the","weasel")));


    }

    public static <T> List<T> getRetains(List<T> c1, List<T> c2) {
        List<T> result = new ArrayList<>(c1);
        result.retainAll(c2);
        return result;
    }
}
