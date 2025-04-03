package homework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        System.out.println("============ Task 1 =============");
        List<Integer> ints = Arrays.asList(1, 2, -3, 2, 13, 15, 0, 100, 99, 101, 199, 188, -199);
        System.out.println("Sorted integers > 10: " + task1(ints));
        System.out.println("============ Task 2 =============");
        List<String> strings = List.of("pop!", "goes", "the", "weasel");
        System.out.println("Shortest string: " + task2(strings));
        System.out.println("============ Task 3 =============");
        System.out.println("Evens *2 are: " + task3(ints));
    }

    private static List<Integer> task3(List<Integer> ints) {
        return ints.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .collect(Collectors.toList());
    }
    /*
    Имеется список строк. Используя Stream API, найдите строку с минимальной длиной.
     */
    private static String task2(List<String> strings) {
        return strings.stream()
                .min((a, b) -> Integer.compare(a.length(), b.length()))
                .orElse(null);
    }
    /*
    Из списка целых чисел выделите те значения, которые больше 10; отсортируйте эти значения по значению последней цифры в числе и выведите результат на экране
     */
    private static List<Integer> task1(List<Integer> ints) {
        return ints.stream()
                .filter(num -> num > 10)
                .sorted((a, b) -> Integer.compare(a % 10, b % 10))
                .collect(Collectors.toList());
    }
}
