//Stream API. Функциональные интерфейсы Function, Predicate, Consumer являются частью Java Lambda Expression с версии 8
//реализации этих интерфейсов применяются, когда некий метод применяет интерфейс в качестве параметра

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InterfacesExample {
    public static void main(String[] args) {
        System.out.println("========= Consumer<T> =========");
        //Consumer<T>  выполняет операцию над объектом, не возвращая никакого результата
        //void accept(T t)
        //сигнатура метода такая -
        Consumer<String> consumerExample = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "!");    //например
            }
        };
        //на лямбдах - так
        consumerExample = s -> System.out.println(s + "!");

        //как пользоваться?
        consumerExample.accept("Hello, world");
        consumerExample.accept("Java");

        //Составной интерфейс
        Consumer<String> consumer1 = str -> System.out.println("1. "+ str.length());
        Consumer<String> consumer2 = str -> System.out.println("2. "+ str);
        Consumer<String> resultConsumer = consumer1.andThen(consumer2);
        resultConsumer.accept("Test");

        System.out.println("========= Predicate<T> =========");
        //Predicate<T> - проверяет объект на соответствие условию (тестирование)
        //boolean test<T t>
        //тело метода
        Predicate<String> predicateExample = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s != null;
            }
        };
        //на лямбдах
        Predicate<String> isShort = str->str.length() < 3;
        boolean result = isShort.test("Java");
        System.out.println(result);
        System.out.println(isShort.test("JS"));

        //как пользоваться?
        List<Integer> list = new ArrayList<>(List.of(1,2,-1,3,-421,4,-5,5,-4,65,0,0,-7,-5,5,24));

        //хочу список всех отрицательных чисел
        List<Integer> testedList = filteredByPredicate(list,(integer -> integer < 0));
        System.out.println("Negative: " + testedList);
        //список положительных чисел
        testedList = filteredByPredicate(list,(integer)->integer>0);
        System.out.println("Positive: " +testedList);
        //список чётных чисел!
        testedList = filteredByPredicate(list, (integer -> integer%2 == 0));
        System.out.println("Even: " + testedList);
        //нечетных чисел!!!
        testedList = filteredByPredicate(list,(integer -> integer%2 != 0));
        System.out.println("Odd: " + testedList);
        //нечётных отрицательных!!!!!
        testedList = filteredByPredicate(list,(integer -> integer%2 != 0 && integer < 0));
        System.out.println("Odd negative: " + testedList);
        //чётных больше 5!!!!!
        testedList = filteredByPredicate(list,(integer -> integer%2 == 0 && integer < 5));
        System.out.println("Even > 5: " + testedList);

        /*
        Методы предикатов
            and() - логическое и
            or() - логическое или
            negate() - логическое не
         */
        System.out.println("========= and, or, negate =========");
        Predicate<String> isLong = s -> s.length() > 10;
        Predicate<String> containsJava = s -> s.contains("Java");

        Predicate<String> andPredicate = isLong.and(containsJava);
        Predicate<String> orPredicate = isLong.or(containsJava);
        Predicate<String> negatePredicate = andPredicate.negate();
        String testString = "Java";
        System.out.println("andPredicate: " + andPredicate.test(testString));
        System.out.println("orPredicate: " + orPredicate.test(testString));
        System.out.println("negatePredicate: " + negatePredicate.test(testString));

        //Function <T, R> - производит операцию над объектом типа Т, возвращает объект типа R
        //R apply(T t)

        //тело метода
        Function<String, Integer> exampleFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 0;
            }
        };
        System.out.println("========= Function<T,R> =========");
        Function<String, Integer> integerFunction = s->s.length();
        String str = "Hiiiiii!";
        int len = integerFunction.apply(str);
        System.out.println(len + " length -> " + len);
        //можно два совпадающих типа данных
        Function<String, String> stringFunction = s -> s.toUpperCase();
        System.out.println(str + "-> " + stringFunction.apply(str));

    }

    //метод должен возвращать список объектов, удовлетворябщих требованию\условию\прошедших проверку
    public static List<Integer> filteredByPredicate(List<Integer> integers, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer i: integers) {
            if (predicate.test(i)){
                result.add(i);
            }
        }
        return result;
    }

}
