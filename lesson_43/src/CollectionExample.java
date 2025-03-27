import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        //интерфейс Collection гарантирует наличие базовых методов для всех расширяющих его интерфейсов - list, queue, set
        //это позволяет единообразно обрабатывать различные типы коллекций

        //правило - ссылка типа интерфейс ->
        //справа можно поставить объект любого класса, который реализует интерфейс Collection
        //в зависимости от типа справа будет по разному реализована логика хранение данных, но все методы будут доступны так или иначе
        Collection<String> strings = new HashSet<>();
        System.out.println(strings.size());

        strings = new ArrayList<>();

        //size() - возвращает размер массива
        System.out.println(strings.size());
        //isEmpty() - возвращает true если коллекция пуста
        System.out.println(strings.isEmpty());
        //boolean add (T t) - добавляет элемент в коллекцию
        System.out.println("Add Java - " + strings.add("Java"));;
        System.out.println("Add Python - " + strings.add("Python"));
        //toString - выводит список всех элементов коллекции (переопределённый)
        System.out.println(strings.toString());
        //.of - статический метод, который присутствует почти во всех интерфейсах и классах JFC
        //создаёт неизменяемую коллекцию из предоставленных элементов (она не будет редактироваться)
        //доступен для list, set, map
        Collection<Integer> integers = List.of(1,2,3,4,5);
        System.out.println(integers);
//        integers.add(7); //выкинет ошибку
        //addAll(Collection ? extends T) - добавит все элементы из указанной коллекции
        strings.addAll(List.of("PHP","C","C++","Lua"));
        System.out.println(strings);
        Collection<Integer> colA = new ArrayList<>();
        colA.addAll(List.of(0,1,2,3,4,5,3,2,1,5,6));
        //сontainsAll(<?> c) - true, если в вызываемой коллекции есть все элементы коллекции с
        System.out.println("colA = " + colA);
        System.out.println("colA has 3,4,2 - " + colA.containsAll(List.of(3,4,2)));
        //removeAll(Collection<?> colB) - удаляют все элементы коллекции colB из коллекции, на которой вызван этот метод
        //colA.removeAll(colB) удаляет из коллекции А все элементы которые содержит коллекция В (ВЫЧИТАНИЕ)

        colA.removeAll(List.of(3,2,1));
        System.out.println(colA);
        //retainAll(Collection<?> colB) - оставляет в коллекции вызова только те элементы, что содержатся в коллекции В
        colA.addAll(List.of(3,4,5,6,7,8,9,2,3));
        colA.retainAll(List.of(3,4));
        System.out.println(colA);

        //boolean remove(Obj o) - удаляет объект из коллекции. Вернёт true, если удалось удаление
        System.out.println("Remove 13 - " + colA.remove(13));
        System.out.println("Remove 3 - " + colA.remove(3)); //удалит ПЕРВЫЙ найденный объект
        System.out.println(colA);
        //clear() - удаляет все элементы из коллекции
        colA.clear();
        System.out.println(colA);
    }
}
