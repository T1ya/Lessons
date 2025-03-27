import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        //конструкторы

        //конструкторы АrrayList
        List<Integer> list = new ArrayList<>(); //пустой список
        list = new ArrayList<>(15); //с указанной ёмкостью
        list = new ArrayList<>(List.of(1,3,4,5,123));//принимает коллекцию

        //конструкторы LinkedList
        list = new LinkedList<>(); //пустой список (внутренняя реализация - двухсвязный список)
        list = new LinkedList<>(List.of(4,45,5,21,2)); //принимает коллекцию

        //методы интерфейса List

        //boolean add(E e) - добавляет элемент в конце списка
        System.out.println(list);
        list.add(1000);
        list.add(45);   //поддерживает дубликаты!
        System.out.println(list);

        //void add(int index, E e) - добавляет элемент на указанную позицию
        list.add(3,400);    //не переписывает значение по индексу, а вставляет и смещает список вправо
        System.out.println(list);

        //E get(int index) - возвращает элемент по индексу
        System.out.println(list.get(3));

        //E remove(int index) - удаляет элемент по индексу и возвращает старое значение
        System.out.println("Remove index 3: " + list.remove(3));
        System.out.println(list);

        //boolean remove(Object o) перегрузка метода - удаление по значению. Принимает объект

        //int indexOf(Object o) поиск по значению - возвращает ПЕРВЫЙ индекс искомого объекта

        System.out.println("Index of 123 = " + list.indexOf(123));  //нету
        System.out.println("Index of 45 = " + list.indexOf(45));    //есть!
        //int lastIndexOf(Object o) поиск по значению - возвращает ПОСЛЕДНИЙ индекс искомого объекта
        System.out.println("Last index of 45 = " + list.lastIndexOf(45));

        //void sort(Comparator<? super E> comparator) - сортирует список с использованием указанного компаратора
        list.sort((a,b)->Integer.compare(a,b));
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        //List<E> sublist(index fromIndex, index toIndex) - возвращает список из элементов диапазона [from,to)
        System.out.println(list.subList(2,5));
    }
}
