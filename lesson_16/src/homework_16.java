import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class homework_16 {
    public static void main(String[] args) {
        /*
        Task 1
        Найдите произведение всех чисел от 1 до 15 включительно.

        Результат выведите на экран
         */
        System.out.println("===== Task01");
        int i = 1;
        long mult = i;  //get overflow to int, so we need long instead
        while (i < 16) {
            mult *= i;
            i++;
        }
        System.out.println("произведение всех чисел от 1 до 15 включительно: " + mult);

        /*
        Task 2
        Используйте цикл while для решения задачи:

        Распечатайте 10 строк: "Task1", "Task2", ..., "Task10".
         */
        System.out.println("===== Task02");
        i = 1;
        while (i < 11) {
            System.out.println("Task" + i++);
        }
        /*
        Task 3 *(Опционально)
        Напишите программу, которая просит пользователя ввести слово "hello".
        Если пользователь вводит правильное слово, программа благодарит его и завершает работу.
        Если вводится неправильное слово, программа продолжает запрашивать ввод, пока не будет введено правильное слово.

        Дополнительно: Подсчитайте количество попыток, потребовавшихся для ввода правильного слова, и выведите это количество на экран.
         */
        System.out.println("===== Task03");
        Scanner scanner = new Scanner(System.in);
        String word = "hello";
        String userInput = " ";
        int guess = 0;
        System.out.println("Please enter \"hello\"");
        while (!word.equals(userInput)) {
            userInput = scanner.nextLine();
            //not necessary, but I try to make task a bit easier for user...
            userInput = userInput.trim().toLowerCase();
            guess++;
        }
        System.out.println("Congrats! You have made it with only " + guess + " attempts!");

        /*
        Task 4 * (Опционально)
        Программа запрашивает у пользователя ввод произвольного числа. Вывести сумму цифр этого числа.
        Пример:
        567432 -> 5+6+7+4+3+2 -> 27
         */
        System.out.println("===== Task04");
        System.out.println("Please enter a number: ");
        //user input check - we need a number
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number: ");
            scanner.next(); //clear scanner
        }
        //save the value as a string
        userInput = scanner.next();

        i = 0;
        int sum = 0;
        //output set...
        System.out.printf("%s -> ", userInput);
        while (i < userInput.length()) {
            //more output set
            String sign = (i == userInput.length() - 1) ? " -> " : " + ";
            System.out.printf("%c%s", userInput.charAt(i), sign);
            //need to set char to its real value, not its ASCII code
            sum += Character.getNumericValue(userInput.charAt(i));
            i++;
        }
        System.out.println(sum);

        /*
        Массивы
        Task 5
        Создать массив целых чисел произвольной длины от 5 до 15. Заполнить массив случайными значениями от -50 до 50.

        Вывести на экран:

        Минимальное значение в массиве
        Максимальное значение в массиве
        Среднее арифметическое всех значений в массиве
         */
        System.out.println("===== Task05");
        Random r = new Random();
        //get random size for the array. Also can use it in while cycles
        int arrLength = r.nextInt(11) + 5;
        int[] myArr = new int[arrLength];
        //fill the array
        i = 0;
        while (i < arrLength) {
            myArr[i] = r.nextInt(101) - 50;
            i++;
        }
        //and calculate values
        i = 0;
        int min = myArr[i];
        int max = myArr[i];
        sum = 0;
        while (i < arrLength) {
            if (myArr[i] > max) max = myArr[i];
            if (myArr[i] < min) min = myArr[i];
            sum += myArr[i];
            i++;
        }
        double average = (double) sum / arrLength;
        System.out.println("Min array value: " + min);
        System.out.println("Max array value: " + max);
        System.out.println("Average array value: " + average);

        /*
        Task 6
        Дан массив целых чисел. Поменять местами элементы с максимальным и минимальным значениями.
        Пример:
        { 5, 6, -25, 0, 31, -15 } -> { 5, 6, 31, 0, -25, -15 }
         */
        System.out.println("===== Task06");
        int[] minMaxArray = {3, 2, -1, 23, 55, 2, 123, 7};
        //print original array
        System.out.printf("%s -> ", Arrays.toString(minMaxArray));
        //search for the min and max elements
        i = 0;
        int maxVal = minMaxArray[0];
        int minVal = minMaxArray[0];
        int maxIndex = 0;
        int minIndex = 0;
        while (i < minMaxArray.length) {
            if (minMaxArray[i] > maxVal) {
                maxVal = minMaxArray[i];
                maxIndex = i;
            }
            if (minMaxArray[i] < minVal) {
                minVal = minMaxArray[i];
                minIndex = i;
            }
            i++;
        }
        //change values
        minMaxArray[maxIndex] = minVal;
        minMaxArray[minIndex] = maxVal;
        //print changed array
        System.out.println(Arrays.toString(minMaxArray));
    }
}
