public class methodsExample {
    public static void main(String[] args) {
        int temp = 55;
        changeMe(temp);

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        printArray(numbers);
        changeMe(numbers);
        printArray(numbers);

        int[] link2 = numbers;
        link2[2] = -100000;
        printArray(numbers);

        //numbers = null;
        //printArray(numbers);

        link2[9] = 0;
        printArray(link2);

        String myStr = "hello";
        changeMe(myStr);
        System.out.println(myStr); //string in java are immutable!
    }


    public static void changeMe(int x) {
        x = 100;
    }

    //overload
    public static void changeMe(int[] array) {
        array[0] = 1000;
    }

    public static void changeMe(String str) {
        str += "!!!";
        System.out.println(str);
    }

    // Метод "красиво" выводящий все элементы массива ЦЕЛЫХ ЧИСЕЛ
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) { // перебираю индексы массива
            System.out.print(array[i] + (i != array.length - 1 ? ", " : "]\n"));
        }
    }
}
