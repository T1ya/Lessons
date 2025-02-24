import java.util.Random;
import java.util.Scanner;

public class homework_15 {
    public static void main(String[] args) {
        /*
        Task 1
        Запишите в 4 переменные случайные числа от 0 до 100.
        Выведите все 4 числа на экран.
        Программа должна определить максимальное из этих четырех чисел и вывести результат на экран.
        Output:
        Максимальное число: 33
         */
        System.out.println("===== Task01");
        Random r = new Random();
        int a = r.nextInt(101);
        int b = r.nextInt(101);
        int c = r.nextInt(101);
        int d = r.nextInt(101);

        //get max
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        System.out.printf("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
        System.out.println("Максимальное число: " + max);

        /*
        Task 2
        Напишите программу с использованием оператора switch:

        Программа просит пользователя ввести число от 1 до 7.
        Если число равно 1, выводим на консоль "Понедельник", 2 — "Вторник" и так далее. Если 6 или 7 — "Выходной".
         */
        System.out.println("===== Task02");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 7");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Понедельник");
                    break;
                case 2:
                    System.out.println("Вторник");
                    break;
                case 3:
                    System.out.println("Среда");
                    break;
                case 4:
                    System.out.println("Четверг");
                    break;
                case 5:
                    System.out.println("Пятница");
                    break;
                case 6:
                case 7:
                    System.out.println("Выходной");
                    break;
                }
        }
        else {
            System.out.println("Неверный тип данных - введите число от 1 до 7");
        }
        scanner.nextLine(); //clear new line symbol
        /*
        Task 3 (Повышенной сложности, опционально)
        Программа предлагает пользователю ввести четырехзначное число.
        Ввод осуществляется только в формате строки (String).
        Если введенное значение не является четырехзначным числом, должно выводиться сообщение об ошибке, и программа завершает работу.
        Проверить, является ли число "счастливым билетом". Для этого нужно сравнить сумму первых двух цифр с суммой последних двух цифр.
         */
        System.out.println("===== Task03");
        //already got scanner above, so...
        System.out.println("Введите четырёхзначное число: ");
        if (scanner.hasNextInt()) { //check for "number" type...
            String userInput = scanner.nextLine();
            if (userInput.length() == 4) {  //check string for 4-digits length
                int firstDigit = userInput.charAt(0) + userInput.charAt(1);
                int secondDigit = userInput.charAt(2) + userInput.charAt(3);
                //Test the luck!
                if (firstDigit == secondDigit)
                {
                    System.out.println("Поздравляем, у Вас счастливый билет!");
                }
                else {
                    System.out.println("Не повезло...");
                }
            }
            //length error message
            else {
                System.out.println("Ошибка - количество знаков не равно 4");
            }
        }
        //type error message
        else {
            System.out.println("Ошибка - нужно ввести число");
        }
        /*
        Task 4 * (Опционально)
        Используйте оператор switch для решения задачи:

        Ваш ребенок принес оценку за контрольную работу по математике. В школе 12-балльная система. Запишите в переменную случайное число от 0 до 12.

        Вы разрешаете ребенку смотреть телевизор не более 60 минут в день. На сегодня у него осталось 45 минут.

        Если оценка от 10 до 12 баллов: скажите ребенку, как вы рады, и добавьте к оставшемуся времени 1 час.
        Оценка от 7 до 9 баллов: похвалите ребенка и добавьте 45 минут.
        Оценка от 4 до 6 баллов: нейтрально отнеситесь и добавьте 15 минут.
        Оценка 3 балла: огорчитесь и вычтите 30 минут.
        Оценка меньше 3 баллов: запретите телевизор на сегодня.
        Выведите на экран оставшееся время для просмотра ТВ.

        P.S. Проконтролируйте, чтобы ребенок не смотрел ТВ больше 60 минут в день.
         */
        System.out.println("===== Task04");

        int tvTime = 45;
        int grade = r.nextInt(13);
        System.out.println("Оценка за контрольную: " + grade);
        switch (grade){
            case 3:
                System.out.println("Это не очень хорошо.");
                tvTime -= 30;
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("Это нормально.");
                tvTime += 15;
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("Ты молодец!");
                tvTime += 45;
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("Превосходно! Горжусь тобой!");
                tvTime += 60;
                break;
            default:
                System.out.println("Это очень плохо. Сегодня без телевизора!");
                tvTime = 0;
        }
        //TV time control - no more than 60 minutes! So I cut the time that exceed 1 hour
        if (tvTime > 60) tvTime = 60;
        //output
        System.out.printf("Время для просмотра телевизора на сегодня: %d минут.", tvTime);
    }
}
