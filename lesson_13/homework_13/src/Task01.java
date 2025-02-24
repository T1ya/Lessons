import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        /*Task 1
        Напишите программу, которая будет просить у пользователя ввести его имя с клавиатуры.
        Используя Scanner, сохраните имя в переменную типа String.
        Выведите на экран количество символов в имени пользователя.
        Создайте две переменные типа char: одна должна хранить первый символ имени, другая — последний.
        Выведите на экран десятичный код (код символа в десятичной системе счисления) первого и последнего символа имени.
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        char firstChar = name.charAt(0);
        char lastChar = name.charAt(name.length() - 1);

        System.out.printf("Your name has %d chars", name.length());
        System.out.printf("\nFirst char code: %d", ((int) firstChar));
        System.out.printf("\nLast char code: %d", ((int) lastChar));
    }
}
