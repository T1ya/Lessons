import java.util.*;

public class homework {
    public static void main(String[] args) {
        String text = "Строка для проверки количества вхождений слов" +
                ".\n Строка для проверки и теста. и количества слов для проверки";

        Map<String, Integer> frequencyMapWords = frequencyDictionaryWords(text);
        System.out.println("Частота вхождений слов:");
        frequencyMapWords.forEach((k, v) -> System.out.print("'" + k + "': " + v+ " | "));
        System.out.println("\n========================");

        Map<Character, Integer> frequencyMapChars = frequencyDictionaryChars(text);
        System.out.println("Частота вхождений символов:");
        frequencyMapChars.forEach((k, v) -> {
            //перенос строки придётся обработать отдельно
            if (k == '\n') {
                System.out.print("'\\n': " + v+ " | ");
            }
            else {
                System.out.print("'" + k + "': " + v+ " | ");
            }

        });
        System.out.println("\n========================");
    }

    /*
    Task 1
    Частотный словарь слов: Напишите метод, который принимает строку текста и возвращает Map<String, Integer>, где каждому слову соответствует количество его вхождений в текст.
     */
    public static Map<String, Integer> frequencyDictionaryWords(String str) {
        //1 очищаем строку от лишних символов
        String newString = str.replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", "").toLowerCase();
        //2 парсим
        String words[] = newString.split("\\s+");
        //3 создадим сортированный по алфавиту мап для слов и количества их вхождений
        Map<String, Integer> result = new TreeMap<>();
        //4 заполним его символами, увеличивая значение по ключу на единицу при каждом новом присваивании
        for (String w : words) {
            /*
            getOrDefault возвращает либо значение по ключу, либо дефолтный 0.
            прибавим к нему единицу, и для только что добавленного слова w ключ станет 1
            при следующем нахождении по ключу значение перезапишется на текущее+1
             */
            result.put(w, result.getOrDefault(w, 0) + 1);
        }
        return result;
    }

    /*
    Task2 (*Опционально):
    Напишите метод, возвращающий частотный словарь вхождения символов в строку
     */
    public static Map<Character, Integer> frequencyDictionaryChars(String str) {
        //1 возьмём строку "как есть"
        //2 создадим сортированный по алфавиту мап для символов и количества их вхождений
        Map<Character, Integer> result = new TreeMap<>();
        //3 заполним его символами, увеличивая значение по ключу на единицу при каждом новом присваивании
        for (Character c : str.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
