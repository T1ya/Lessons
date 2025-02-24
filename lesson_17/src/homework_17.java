import java.util.Random;

public class homework_17 {
    public static void main(String[] args) {
        //Task1
        String str = "hello";
        //Task2
        int[] array = {1, 4, 3, 6, 7};
        //Task4
        Random r = new Random();
        int[] taskFourArray = new int[50];
        for (int i = 0; i < taskFourArray.length; i++) {
            taskFourArray[i] = r.nextInt(100) + 1;
        }
        //Task5
        String[] stringArray = {"Bob", "Sam", "Eddie", "Albrecht von Vallenstein", "Joe"};

        System.out.println("==== Task1");
        printStringLength(str);

        System.out.println("==== Task2");
        inverseArray(array);
        inverseArray(array, 2);

        System.out.println("==== Task3");
        raiseToPwr(0);
        raiseToPwr(3);
        raiseToPwr(-3);

        System.out.println("==== Task4");
        showSimpleNumbers(taskFourArray);

        System.out.println("==== Task5");
        showLongestString(stringArray);
    }

    /*
    Task 1
    Написать метод, принимающий на вход строку.
    Метод должен вывести на экран число, соответсвующее количеству символов в строке.
    Например: Если в метод пришла строка "hello" - метод должен вывести число 5 (так как в строке hello 5 символов)
    */
    public static void printStringLength(String str) {
        System.out.println(str.length());
    }

    /*
    Task 2
    Написать метод, принимающий массив целых чисел и распечатывающий массив в обратной последовательности.

    {1, 4, 3, 6, 7} -> распечатывает [7, 6, 3, 4, 1]
    Copy
    Перегрузить метод, если в него приходит массив + индекс, то часть массива слева до этого индекса распечатывается в обычном порядке, а начиная с этого индекса в обратном:

    {1, 4, 3, 6, 7} + индекс 2 - > распечатывает [1, 4, 7, 6, 3]
     */
    public static void inverseArray(int[] arr) {
        System.out.print("[");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + (i != 0 ? ", " : "]\n"));
        }
    }

    public static void inverseArray(int[] arr, int index) {
        //check for valid index
        if (index < 0 || index >= arr.length) {
            System.out.println("Error: Index out of array!");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == index) break;  //time 4 reverse!
            System.out.print(arr[i] + ", ");
        }
        for (int i = arr.length - 1; i >= index; i--) {
            System.out.print(arr[i] + (i != index ? ", " : "]\n"));
        }
    }

    /*
    Task 3
    Написать метод, принимающий на вход целое число. Метод должен вывести на экран 2 в степени это Число

    Например: Если в метод пришло число 3 - метод должен вывести число 8 (так как 2 в степени 3 = 8)

    класс Math для нахождения степени числа использовать нельзя ;)

    P.S. А почему вы решили, что число может прийти только положительное? ;)
     */
    public static void raiseToPwr(int pwr) {
        double num = 1;
        if (pwr > 0) {
            for (int i = 1; i <= pwr; i++) {
                num *= 2;
            }
            //output as integer for positive pwr
            System.out.println((int) num);
        } else if (pwr < 0) {
            for (int i = -1; i >= pwr; i--) {
                num /= 2;
            }
            //"double" output for doubles...
            System.out.println(num);
        }
        //and digit for 0 pwr
        else System.out.println((int) num);
    }

    /*
    Task 4 * (Опционально)
    Заполните массив 50 случайными числами от 1 до 100. Программа должна найти, и вывести на экран все простые числа.
    Посчитайте сколько получилось таких чисел в массиве.

    Простое число - число, которое делится на цело только на 1 и само себя.

    Пример простых чисел: 3, 5, 7, 11, 13 и т.д.
     */
    public static void showSimpleNumbers(int[] arr) {
        //would be MUCH easier with Math lib and use of other 'boolean' and 'int' methods...
        System.out.print("Simple numbers are: ");
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            //simple numbers are: 1
            //or have divider from 2 to its square root..
            boolean hasDivider = false;
            int num = arr[i];

            //find for the square root
            int squareRoot = 0;
            for (int j = 0; j * j <= num; j++) {
                squareRoot = j;
            }

            //check if  divider exists
            for (int j = 2; j <= squareRoot; j++) {
                if (num % j == 0) {
                    hasDivider = true;
                    break;
                }
            }
            //and show simple numbers
            if (num == 1 || !hasDivider) {
                System.out.print(num + " ");
                total++;
            }
        }
        System.out.println(". Total simple numbers: " + total);
    }

    /*
    Task 5 * (Опционально)
    Написать метод, который принимает массив строк. Вывести на экран все символы самой длинной строки из массива.
     */
    public static void showLongestString(String[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Error - array is empty");
            return;
        }
        //get longest string
        String longestStr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > longestStr.length()) {
                longestStr = arr[i];
            }
        }
        //output
        System.out.println("Longest string is \"" + longestStr + "\".");
        System.out.print("Symbols are: ");
        for (int i = 0; i < longestStr.length(); i++) {
            System.out.print(longestStr.charAt(i) + " ");
        }
    }
}
