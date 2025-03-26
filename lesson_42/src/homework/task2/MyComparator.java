package homework.task2;

import java.util.Comparator;
/*
Task 2 * ОПЦИОНАЛЬНО
Напишите MyComparator, реализующий Comparator с методом сравнения для сортировки массива целых чисел в следующем порядке:

Четные целые числа должны идти перед нечетными числами
 */
public class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        //остаток от деления даст ноль для чётного числа и единицу для нечётного
        int aIsEven = a%2;
        int bIsEven = b%2;
        //чётное - нечётное даст -1, нечётное - чётное даст 1, так что чётные пойдут перед нечётными
        if (aIsEven != bIsEven) return aIsEven - bIsEven;
        //по умолчанию - сортируем во возрастанию
        return a-b;
    }
}
