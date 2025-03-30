import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.hashCode());

        /*
        Хеш-код - это цифровой отпечаток объекта. Он часто используется в хеш-коллекциях
        Для работы хеш коллекций есть важное правило - контракт между hashCode и equals

        1) если два объекта равны по методу equals, то их хеш-коды должны быть равны
        2) если хеш-коды двух объектов различны, объекты точно НЕ равны по equals
        2.1) обратное не всегда верно - разные объекты могут иметь одинаковый хеш-код (т.н. Коллизия)
        3) вызов метода hashCode должен возвращать одинаковое значение при вызовах на неизменённом объекте
         */

        //Constructors
        Set<Integer> set = new HashSet<>(); //Создаёт пустой конструктор. Ёмкость 16, коэффициент заполнения 0.75
        set = new HashSet<>(20); //Создаёт пустой хещ-сет с указанной ёмкостью
        //принимает коллекцию, создаёт множество, содержащее ТОЛЬКО УНИКАЛЬНЫЕ элементы из указанной коллекции
        set = new HashSet<>(List.of(1,3,4,4,2,3,21,55,2,323,-100,4,5,6,7,8,2));
        System.out.println(set);

        List<Integer> startVals = List.of(15,2,3,4,4,5,6,7,9,16,32,0,5,6,15);
        //HashSet - не поддерживает порядок добавления элементов
        Set<Integer> integersSet = new HashSet<>(startVals);
        System.out.println("HashSet: " + integersSet);

        //LinkedHashSet - поддерживает
        Set<Integer> linkedSet = new LinkedHashSet<>(startVals);
        System.out.println("Linked set: " + linkedSet);

        //Methods
        //boolean add(E e) - добавление элемента
        System.out.println("Add 100 - " + integersSet.add(100)); //true
        System.out.println(integersSet);
        System.out.println("Add 100 - " + integersSet.add(100)); //false  - элемент уже существует
        System.out.println(integersSet);

        //boolean remove(Object 0) -удаляет элемент по значению. Не перегружен! Set НЕ ПОДДЕРЖИВАЮТ индексацию
        System.out.println("Remove 100 - " + integersSet.remove(100));
        System.out.println(integersSet);
        System.out.println("Remove 100 - " + integersSet.remove(100));
        System.out.println(integersSet);

        //boolean contains(Object o) - проверяет присутствие элемента во множестве
        System.out.println("Search 100 - " + integersSet.contains(100));
        System.out.println("Search 4 - " + integersSet.contains(4));

        /*
            int size() - возвращает количество элементов в сете
            boolean isEmpty() - пуст ли сет
            clear() - удаляет все элементы сета
         */

        System.out.println("======================");
        //поскольку индексация не поддерживается, используется специальный итератор (сет наследует класс Iterable)
        //iterator() - перебирает все элементы массива
        Iterator<Integer> iterator = integersSet.iterator();
        for (Integer i: integersSet) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(",");
            }
            else {
                System.out.println();
            }
        }
        // Пример - убрать дубликаты
        // написать метод, который принимает список и возвращает список, состоящий только из уникальных элементов начального списка
        System.out.println("======================");
        System.out.println(startVals);
        List<Integer> result = getUniqueList(startVals);
        System.out.println("Remove double values: " + result);

        //Sorted set конструкторы
        System.out.println("======================");
        SortedSet<Integer> sortedSet = new TreeSet<>(); //может принимать пустой конструктор
        sortedSet  = new TreeSet<>(startVals);  //может принимать список значений
        System.out.println(sortedSet);

        //конструктор с компаратором, определяющий порядок хранения элементов
        sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(startVals);
        System.out.println(sortedSet);

        sortedSet = new TreeSet<>(Comparator.naturalOrder());
        sortedSet.addAll(startVals);
        System.out.println(sortedSet);

        //Методы

        //first() last() - возвращают самый большой и самый маленький элементы коллекции (по мнению компаратора)
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());

        //SortedSet<E> headSet(E el) - возвращает часть множества, значения которого строго больше, чем элемент
        SortedSet<Integer> headSet = sortedSet.headSet(6);
        System.out.println("headSet(6): "+ headSet);

        //SortedSet<E> tailSet(E el) - возвращает часть множества, значения которого строго меньше, чем элемент
        SortedSet<Integer> tailSet = sortedSet.tailSet(6);
        System.out.println("tailSet(6): "+ tailSet);

        //SortedSet<E> subSet(E fromElement, E toElement) - возвращает подмножество элементов от и до
        //важно - нужно следить за порядком сортировки!

        SortedSet<Integer> subSet = sortedSet.subSet(4,16);
        System.out.println("subSet(4,16): "+ subSet);

        System.out.println("======================");
        //Часть домашнего задания - как преобразовать строку в список
        homework("Моя   !№;!;  строка со  813 словами ");
        }

    private static <T> List <T> getUniqueList(List<T> list) {
        Set<T> linkedSet = new LinkedHashSet<>(list);
        return new ArrayList<>(linkedSet);
    }

    private static void homework(String str) {
        System.out.println("Original: " + str);
        String newString = str.replaceAll("[^a-zA-Za-яА-аЯ-Я0-9 ]","");
        System.out.println("Only letters and digits: " +newString);

        String[] words = newString.split("\\s+");

        List<String> newList = Arrays.asList(words);
        System.out.println("List from string: " + newList);
    }
}
