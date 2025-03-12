package homework;

public class HomeworkApp {
    //for Task2
    public static <T,U> void printTwoLists(MyArrayList<T> list1, MyArrayList<U> list2) {
        if (list1.isEmpty() || list2.isEmpty()) {
            return;
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }

    public static void main(String[] args) {
        //Task 1
        Pair<String> pair = new Pair<>("Hello", "World");
        System.out.println(pair.getFirst()); // Вывод: Hello
        System.out.println(pair.getSecond()); // Вывод: World

        pair.swap();
        System.out.println(pair.getFirst()); // Вывод: World
        System.out.println(pair.getSecond()); // Вывод: Hello

        //Task 2
        MyArrayList<String> names = new MyArrayList<>();
        names.add("John");
        names.add("Jane");

        MyArrayList<Integer> scores = new MyArrayList<>();
        scores.add(2);
        scores.add(3);

        printTwoLists(names,scores);

        //Task 3
        NumericPair<Integer> intPair = new NumericPair<>(13,442);
        System.out.println("Sum int = "+ intPair.sum());

        NumericPair<Double> doublePair = new NumericPair<>(13.0,31.2);
        System.out.println("Sum double = "+ doublePair.sum());
    }
}
