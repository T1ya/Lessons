public class Task02 {
    public static void main(String[] args) {
        /*
        Task 2
        Создайте строки:
        "Java"
        "is"
        "a"
        "powerful"
        "language"
        Склейте эти строки двумя разными способами, чтобы получить строку: "Java is a powerful language".
        Выведите на экран получившуюся строку и её длину.

        */
        String a = "Java";
        String b = "is";
        String c = "a";
        String d = "powerful";
        String e = "language";

        String concatStr = a + " " + b + " " + c + " " + d  + " " + e;
        String concatStr1 = String.join(" ",a, b, c, d, e);

        System.out.printf("\"%s\" string has %d symbol length\n", concatStr1, concatStr1.length());

        /*
        Task 2.2
        Замените в результирующей строке слово "powerful" на "super".
        Опционально Создайте переменную типа boolean с ответом на вопрос: содержит ли строка подстроку "age"?
        Выведите на экран значение этой переменной.
         */
        String replaceStr = concatStr1.replace("powerful", "super");
        Boolean hasAge = concatStr1.contains("age");

        System.out.println(hasAge);
    }

}
