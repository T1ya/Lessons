import java.security.KeyStore;
import java.util.Random;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        /*
        Task 1
        Дан текст Programming is fun.
        Напишите программу, которая проверяет, содержит ли эта строка слово “fun”, и выведите результат в виде булевой переменной.
        */
        System.out.println("===== Task01");
        String text = "Programming is fun";
        System.out.println(text.contains("fun"));

        /*
        Task 2
        Создайте две переменные типа int.

        В первую переменную запишите случайное значение от 0 до 50.
        Во вторую переменную случайное значение от 0 до 100.
        *(опционально) Во вторую переменную случайное значение от -20 до 30.
        Проверьте:
            равны ли переменные,
            не равны ли они,
            больше ли a, чем b,
            и меньше ли b, чем a.
            Выведите результат на экран.
         */
        System.out.println("\n===== Task02");
        //get random object..
        Random rand = new Random();
        // because of [x...y) rule I should add 1 to the right number
        int a = rand.nextInt(51);
        int b = rand.nextInt(-20, 31);
        //check and output
        System.out.printf("a = %d, b = %d\n", a, b); // a hint)
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b : " + (a > b));
        System.out.println("a < b : " + (a < b));

        /*
        Task 3
        Попросите пользователя ввести целое число с клавиатуры.
        Ваша программа должна вывести строку в формате:
        Число: 6 четное: true; кратно 3: true; четное и кратное 3: true
        Число: 3 четное: false; кратно 3: true; четное и кратное 3: false
        Copy
        Проверьте работу вашей программы, вводя разные числа. Убедитесь в правильности выдаваемой строки.
         */

        Scanner scanner = new Scanner(System.in);
        //user input
        System.out.println("Please enter a number: ");
        int num = scanner.nextInt();
        //conditions
        Boolean isEven = num % 2 == 0;
        Boolean toThree = num % 3 == 0;
        Boolean evenAndThree = (isEven && toThree);
        System.out.printf("Число: %d четное: %b; кратно 3: %b; четное и кратное 3: %b", num, isEven, toThree, evenAndThree);

        /*
        Task 4
        Дан следующий код. Вашей задачей является предсказать, какой вывод будет напечатан в консоли после выполнения программы.

        public class BooleanTest {
            public static void main(String[] args) {
                int a = 8;
                int b = 3;
                boolean result;

                result = (a + b) > 10;
                System.out.println("Result 1: " + result);

                result = (a - b) == 5;
                System.out.println("Result 2: " + result);

                result = (a * b) != 24;
                System.out.println("Result 3: " + result);

                result = (a / b) >= 2;
                System.out.println("Result 4: " + result);

                result = !(a % b == 2);
                System.out.println("Result 5: " + result);
            }
        }
        Предскажите, что будет выведено на консоль для Result 1 до Result 5. Объясните кратко свой ответ.
         */

        //Result 1: True, 8 + 3 = 11, 11 > 10 = True
        //Result 2: True,  8 - 3 = 5, 5  == 5 = True
        //Result 3: False, 8*3 = 24,  24 != 24 = False
        //Result 4: True, 8/3 = 2, 2 >= 2 = True
        //Result 5: False, 8%3 = 2, 2==2 = True, !True = False
    }
}
