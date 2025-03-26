package homework.task2;

import java.util.Arrays;

public class MyComparatorApp {
    public static void main(String[] args) {
        Integer[] integers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };
        System.out.println(Arrays.toString(integers));
        MyComparator comparator = new MyComparator();
        Arrays.sort(integers, comparator);
        System.out.println(Arrays.toString(integers));
    }
}
