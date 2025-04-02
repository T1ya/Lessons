import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Stream API - мощный инструмент, позволяющий обрабатывать наборы данных в декларативном стиле.
    Основная идея - преобразование последовательности элементов через набор операций.

    Определения

    Stream - поток данных, последовательность элементов. Даёт возможность поочерёдного получения элементов для обработки
        Стримы могут быть созданы из различных источников (хотя в основном их используют для работы с коллекциями, но можно работать с чем угодно - хоть с файлами, хоть с консолью).
        Поток - это НЕ хранилище и НЕ структура данных. Это просто способ получения и обработки данных!

    Pipeline - последовательность операций, выполняемая на потоке
        Промежуточные операции / методы (Intermediate operations) преобразуют поток в другой поток (возвращают поток). Их может быть много (от 0 до бесконечности)
        Терминальные операции / методы (Terminal operations) запускают обработку потока и закрывают его.
            После выполнения терминальной операции поток перестаёт быть доступным.
            Поэтому ТО может у потока может быть только одна!


 */
public class StreamExample {
    /*
    Промежуточные методы - все возвращают поток (Stream<T>)
         filter(Predicate<T> predicate) - оставляет в потоке только элементы, для которых предикат вернёт true
         sorted() - сортирует поток в естественном порядке
         sorted(Сomparator<T> comparator) - сортирует поток c использованием компаратора
         Stream<R> map(Function<T, R> action) - преобразует один тип данных в другой
         Stream<T> peek(Consumer<T> action) - выполняет операцию для каждого элемента потока, не изменяя сам элемент
         distinct() - возвращает поток уникальных элементов списка (по методу equals)

    ------

    Терминальные методы -
        R Collect(Collector<T,A,R> collector) - преобразует элементы потока в разные виды коллекций (или другие структуры данных)
        Stream<T> foreach(Consumer<T> action) - выполняет заданное действие для каждого элемента потока
     */


    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
        task10();
    }

    private static void task10() {
        //удалить повторяющиеся значения из списка
        List<Integer> ints = Arrays.asList(1, 2, 3, 2, 3, 5, 0);

        List<Integer> unique = ints.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique: " + unique);
        System.out.println("========================");
        Cat cat = new Cat("Tom", 5, "braun");
        Cat cat1 = new Cat("Lily", 7, "green");
        Cat cat2 = new Cat("Jasper", 3, "yellow");
        Cat cat3 = new Cat("Mimi", 4, "black");

        List<Cat> cats = Arrays.asList(cat, cat1, cat1, cat2, cat3, cat2, cat);
        System.out.println("Cats:        " + cats);

        List<Cat> uniqueCats = cats.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique cats: " + cats);


    }

    private static void task9() {
        //создание стрима из  Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", -19);
        map.put("Cherry", 4);

        //создание стрима из элементов entrySet
        map.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static void task8() {
        Cat cat = new Cat("Tom", 5, "braun");
        Cat cat1 = new Cat("Lily", 7, "green");
        Cat cat2 = new Cat("Jasper", 3, "yellow");
        Cat cat3 = new Cat("Mimi", 4, "black");

        Cat[] cats = {cat, cat1, null, cat2, cat3};

        //получить список кошек, длинна имени которых больше 3 символов

        //Arrays.stream(cats) - создаст поток из элементов массива
        //Objects::nonNull - вернёт true, если объект не равен null
        //Objects::isNull - вернёт true, если объект null
        List<Cat> longCats = Arrays.stream(cats)
                .filter(Objects::nonNull)
                .filter(c -> c.getName().length() > 3)
                .collect(Collectors.toList());
        System.out.println("Long cats: " + longCats);
    }

    private static void task7() {
        //Вывести на экран ИМЕНА котов, чей вес меньше 4
        //и вывести на экран КОТОВ, оставшихся после фильтрации
        List<Cat> cats = getListCats();
        /*
        peek() - промежуточный метод, используется для отладки, не закрывает поток
        foreach() - терминальный метод для выполнения действия с каждым элементом потока, закрывает поток
         */

        Stream<String> catStream = cats.stream()
                .filter(cat -> cat.getWeight() < 5)
                .peek(cat -> System.out.println("After filter: " + cat))
                .map(cat -> cat.getName());

        catStream.forEach(s -> System.out.println("Terminal: " + s));

    }

    private static void task6() {
        List<Cat> cats = getListCats();
        //получить список имён кошек короче 4 символов

        /*
        Эффективность - методы фильтрации потока должны выполняться как можно раньше (классический подход)
         */
        List<String> result = cats.stream()
                .filter(cat -> cat.getName().length() < 4)  //ищется ОДИН кот
                .map(Cat::getName)  //мапируется ОДИН кот
                .collect(Collectors.toList());
        System.out.println(result);
        /*
        Читаемость, понимание кода (второй подход)
        но операций при таком подходе выполняется больше
         */
        result = cats.stream()
                .map(Cat::getName)  //мапируются ВСЕ коты
                .filter(name -> name.length() < 4) //в них ищется тот самый кот
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void task5() {
        //получить список имён кошек, чей вес больше 4 кг
        List<Cat> cats = getListCats();
        List<String> fattiesNames = cats.stream()
                .filter(cat -> cat.getWeight() > 4)
                .map(Cat::getName)
                .collect(Collectors.toList());
        System.out.println("Fatties are: " + fattiesNames);
    }

    private static void task4() {
        //получить список всех имён из списка кошек
        List<Cat> cats = getListCats();
        List<String> catNames = cats.stream()
//                .map(cat -> cat.getName())  // или можно так ->
                .map(Cat::getName)
                .collect(Collectors.toList());
        System.out.println(catNames);
    }

    private static void task3() {
        List<Cat> cats = getListCats();
        //оставить котов с именем длиннее 3 символов

        //стримы НЕ выполняют промежуточные операции, пока на потоке не будет вызван терминальный метод)

        Stream<Cat> streamCats = cats.stream()
                .filter(cat -> cat.getName().length() > 4);   //пока filter() не работает...

        List<Cat> longNames = streamCats.collect(Collectors.toList());  //а сейчас работает!
    }

    private static List<Cat> getListCats() {
        return List.of(
                new Cat("Tom", 5, "braun"),
                new Cat("Lily", 7, "green"),
                new Cat("Jasper", 3, "yellow"),
                new Cat("Mimi", 4, "black")
        );
    }

    private static void task2() {
        List<Cat> cats = getListCats();
        //получить список кошек с весом больше 4
        Stream<Cat> catStream = cats.stream()
                .filter((cat) -> cat.getWeight() > 4);
        //N.B. в Java 17 метод collect(Collectors.toList()) может быть замещён просто .toList
        List<Cat> fatCats = catStream.collect(Collectors.toList());
        System.out.println("Fatties: " + fatCats);
        // повторно использовать закрытый коллектором поток НЕЛЬЗЯ
//        List<Cat> fatCats = catStream.collect(Collectors.toList()); //выдаст ошибку
    }

    private static void task1() {
        List<Integer> integerList = List.of(0, -1, -2, 3, 4, 7, 5, 6);

        //Получить список, содержащий все положительные числа из исходного, в порядке возрастания
        List<Integer> result = new ArrayList<>();
        for (Integer i : integerList) {
            if (i > 0) result.add(i);
        }
        result.sort(Comparator.naturalOrder());
        System.out.println("Result = " + result);

        // У всех коллекций есть метод .stream(), создающий поток из элементов коллекций
        // а у потока есть методы которые можно последовательно вызывать на потоке
        result = integerList.stream()          // создали поток изо всех элементов коллекции
                .filter(i -> i > 0)    // фильтрация элементов
                .sorted()                      // и сортировка
                .collect(Collectors.toList()); // cобирает элементы потока в коллекцию типа List
        System.out.println("Result = " + result);
    }
}
