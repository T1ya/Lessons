package homework.task3;

import java.util.Arrays;
import java.util.Comparator;

/*
Task 3 * ОПЦИОНАЛЬНО
Напишите MyComparator2 с методом сравнения для сортировки массива целых чисел в следующем порядке:

Четные целые числа должны идти перед нечетными числами в порядке возрастания.
Нечетные целые числа должны идти после четных в порядке убывания
 */
public class MyComparator2 {
    public static void main(String[] args) {
        Integer[] integers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };
        //для разнообразия сделаю через лямбда-выражение
        Comparator<Integer> myComparator2 = (a,b)->{
            //остаток от деления даст ноль для чётного числа и единицу для нечётного
            int aIsEven = a%2;
            int bIsEven = b%2;
            //чётные числа идут перед нечётными
            if (aIsEven!=bIsEven) return aIsEven-bIsEven;
            //нечётные числа сортируем в обратном порядке
            else if (aIsEven == 1) {
                return b-a;
            }
            //а чётные - по возрастанию
            return a-b;
        };
        System.out.println(Arrays.toString(integers));
        Arrays.sort(integers,myComparator2);
        System.out.println(Arrays.toString(integers));
    }
}
