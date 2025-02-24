public class Task04 {
    /*
    Task 4 * (Опционально)
    Напишите программу на Java, которая преобразует ваше имя, записанное маленькими буквами, в верхний регистр.

    Для каждой буквы имени создайте отдельную переменную типа char, инициализированную соответствующей буквой в нижнем регистре.

    Затем преобразуйте каждую букву в верхний регистр, используя только арифметические операции (без использования библиотечных функций), и выведите результат.
     */
    public static void main(String[] args) {
        char ch1 = 'i';
        char ch2 = 'l';
        char ch3 = 'y';
        char ch4 = 'a';
        //trick is that in ASCII Table big letters stands before low for 32 cells, so...
        ch1 -= 32;
        ch2 -= 32;
        ch3 -= 32;
        ch4 -= 32;
        System.out.printf("My BIG name is %c%c%c%c", ch1, ch2, ch3, ch4);
    }
}
