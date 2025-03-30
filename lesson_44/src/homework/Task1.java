package homework;

import java.util.*;
    /*
    Напишите метод, принимающий строку и возвращающий Список ее слов без повторений, отсортированный в порядке увеличения длин слов.
    Если строки имеют одинаковую длину - сортировать в естественном порядке
     */
public class Task1 {
    public static void main(String[] args) {
        String testString = "Тестовая строка для удаления слов, которые повторяются. \"строка\" для удаления!";
        System.out.println("Before: " + testString);
        List<String> sortedString = parseAndSort(testString);
        System.out.println("After: " + sortedString);
    }

    public static List<String> parseAndSort(String str) {
        //убираем неподходящие символы
        String newString = str.replaceAll("[^a-zA-Zа-яА-Я0-9\\\\s]","");
        //сплитим
        String words[] = newString.split("\\s+");
        //создаём сет уникальных строк
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        //преобразуем в массив для сортировки
        List<String> result = new ArrayList<>(uniqueWords);
        //сортируем
        result.sort(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        //возвращаем
        return result;
    }
}
