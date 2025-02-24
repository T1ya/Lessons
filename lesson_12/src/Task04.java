public class Task04 {
    public static void main(String[] args) {
        /*Task 4
        Неявное преобразование int в double
        Напишите программу, которая:

        Объявляет переменную типа int и присваивает ей значение 10.
        Присваивает значение этой переменной в переменную типа double с именем myDouble.
        Выводит значение myDouble на экран.
         */
        int myInt = 10;
        double myDouble = myInt;

        System.out.println("Значение myDouble: " + myDouble);
    }
}
