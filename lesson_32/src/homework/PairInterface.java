package homework;

public interface PairInterface<T> {

    T getFirst(); //— возвращает первый элемент.
    T getSecond(); //— возвращает второй элемент.
    void setFirst(T value); //— устанавливает значение первого элемента.
    void setSecond(T value); //— устанавливает значение второго элемента.
    void swap(); //— меняет местами первый и второй элементы.
}
