package homework;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        //Task 1
        System.out.println("====== Task 1 ======");
        List<Integer> ints = Arrays.asList(-10, 20, 31, 23, 34, 54, 1010, -1010, 99, 98, 0, 1);
        List<Integer> sortedInts = task1(ints);
        System.out.println(sortedInts);
        //Task 2
        System.out.println("====== Task 2 ======");
        List<String> strings = Arrays.asList("At", "  As", null, " Af", "Bao", "Bob", "  Bee", "Chao  ", " Chai", "Cog");
        System.out.println(task2(strings, 'b'));
        //Task 3
        System.out.println("====== Task 3 ======");
        List<Person> people = getListPeople();
        List<Person> peopleFromBerlin = filteredPersonList(people, 24, "Berlin");
        System.out.println(peopleFromBerlin);
        List<Person> peopleFromParis = filteredPersonList(people, 24, "Paris");
        System.out.println(peopleFromParis);
    }

    /*
    Task 1
    Напишите метод, принимающий список чисел и возвращающий новый, отфильтрованный список.

    В новом списке должны быть только те числа из старого списка, которые соответствуют всем условиям:
    четные, больше 10 и меньше 100

    Для фильтрации используйте Stream API
     */
    private static List<Integer> task1(List<Integer> list) {
        // проверка параметра на null и пустоту
        if (list == null || list.isEmpty()) return Collections.emptyList();

        return list.stream()
                .filter(i -> i % 2 == 0   // чётные
                        && i > 10                // больше 10
                        && i < 100               // меньше 100
                )
                .collect(Collectors.toList());
    }

    /*
    Task 2
    Дан список строк.

    Используя Stream API, отфильтруйте строки, которые начинаются на определенную букву (например, "A") и отсортируйте их в алфавитном порядке.
    Результат сохраните в новый список строк
     */
    private static List<String> task2(List<String> strings, Character firstLetter) {
        // проверка параметров на null и пустоту
        if (strings == null || firstLetter == null) return Collections.emptyList();

        return strings.stream()
                .filter(i -> i != null
                        && !i.trim().isEmpty()
                        && i.trim().toLowerCase().charAt(0) == Character.toLowerCase(firstLetter)
                )
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    /*
    Task 3
    Дан список Person с полями name, age, city.
    Используйте Stream API для фильтрации людей, которые старше определенного возраста и проживают в определенном городе, а затем соберите их в список.
    Например, старше 25 лет и проживающих в городе "Berlin"
     */
    public static List<Person> getListPeople() {
        return List.of(
                new Person("Bob", 25, " Berlin"),
                new Person("Tom", 41, "London"),
                new Person(null, null, null),
                new Person("Austin", 33, "Berlin"),
                new Person("Jack", 23, "Oslo"),
                new Person("Niko", 18, "Frankfurt"),
                new Person("Kristine", 43, "Bad Nauheim"),
                new Person("Helga", 51, "Friedberg"),
                new Person(null, 44, null),
                new Person("Nikole", 29, " Berlin"),
                new Person("Nikole", null, " Berlin "),
                new Person(null, 29, "   Berlin")
        );
    }

    public static List<Person> filteredPersonList(List<Person> people, Integer ageFrom, String city) {
        // проверка параметров на null и пустоту
        if (people == null || people.isEmpty() || ageFrom == null || city == null) {
            return Collections.emptyList();
        }

        List<Person> result = people.stream()
                .filter(personPassed(ageFrom,city))
                .peek(person -> System.out.println("After filter: " + person))
                .collect(Collectors.toList());
        //если после фильтрации лист будет пустым, выведем сообщение
        if (result.isEmpty()) {
            System.out.printf("There is no people older than %d years in %s.%n", ageFrom, city);
        }
        return result;
    }
    // вынес проверку условий person в предикат
    private static Predicate<Person> personPassed(Integer ageFrom, String city) {
        return person -> person != null
                && person.getName() != null
                && person.getAge() != null
                && person.getCity() != null
                && person.getAge() > ageFrom
                && person.getCity().toLowerCase().contains(city.trim().toLowerCase());
    }
}
