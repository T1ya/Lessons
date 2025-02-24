public class homework_18 {
    public static void main(String[] args) {
        System.out.println("==== Task01");
        int[] firstArr = {0, 1, 2, 3, 4, 5, 6};
        int[] secondArr = {0, 1, 2};
        copyOfArray(firstArr, 3);
        int[] task1Array3 = copyOfArray(secondArr, 5);

        System.out.println("==== Task02");
        String[] myStrings = {"Lizzy", "Bob", "Jack", "Tom", "Asshurbannaphal", "Eddie"};
        String[] newString = getMinMaxString(myStrings);

        System.out.println("==== Task03");
        int[] bigArr = {0, 13, -25, 11, 31, 55, 98, 11, 5};
        int[] simpleArr = makeSimpleArr(bigArr);

    }

    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ((i == arr.length-1)?"}\n":", "));
        }
    }

    public static void printArray(String[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ((i == arr.length-1)?"}\n":", "));
        }
    }
    /*
    Task 1
    Написать метод со следующим функционалом:

    На вход метод принимает массив целых чисел и число - длину нового массива.
    Метод должен создать и распечатать массив заданной в параметрах длинны.
    В начало массива должны быть скопированы элементы из входящего массива:

    {0, 1, 2, 3, 4, 5, 6} -> copyOfArray(array, 3) -> вывод на печать {0, 1, 2}
    Copy
    {0, 1, 2} -> copyOfArray(array, 5) -> вывод на печать {0, 1, 2, 0, 0}
    Copy
    Arrays.copyOf() использовать нельзя. Суть задачи - написать собственную реализацию этого метода
     */
    public static int[] copyOfArray(int[] arr, int length) {
        int[] result = new int[length];
        for (int i = 0; i < length && i < arr.length; i++) {
            result[i] = arr[i];
        }
        printArray(result);
        return result;
    }

    /*
    Task 2
    Написать метод, принимающий на вход массив строк. Метод должен вернуть массив, состоящий из самой короткой и самой длинной строки изначального массива.
     */
    public static String[] getMinMaxString(String[] arr) {
        if (arr == null || arr.length == 0) return null;
        String[] result = new String[2];
        //initialize
        String notNull = getNonNullString(arr);
        if (notNull != null) {
            result[0] = notNull; //for min
            result[1] = notNull; //for max
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != null && result[0].length() > arr[i].length()) result[0] = arr[i];
                if (arr[i] != null && result[1].length() < arr[i].length()) result[1] = arr[i];
            }
            return result;
        }
        return null;
    }

    private static String getNonNullString(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) return arr[i];
        }
        return null;
    }


    /*
    Task 3 * (Опционально)
    Написать метод, принимающий на вход массив целых чисел.
    Метод должен вернуть массив, состоящий только из простых чисел, присутствующих в изначальном массиве

    вход -> {0, 13, -25, 11, 31, 55, 98, 11, 5} -> выход {13, 11, 31, 11, 5}
     */

    public static int[] makeSimpleArr(int[] arr) {
        //1 - try to find new array's length
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isSimple(arr[i])){
                count++;
            }
        }
        //2 - make new array with length we have found
        int[] simpleArr = new int[count];
        //3 - fill array wit simple numbers
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isSimple(arr[i])){
                simpleArr[j++] = arr[i];
            }
        }
        return simpleArr;
    }

    public static boolean isSimple(int num) {
        // less than 2 check
        if (num < 2) {
            return false;
        }
        // 2 and 3 check
        else if (num == 2 || num == 3) {
            return true;
        }
        //low range numbers check
        else if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        //big range numbers check
        else {
            for (int i = 5; i*i < num; i+=6) {
                if (num%i == 0 || num%(i+2) == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
