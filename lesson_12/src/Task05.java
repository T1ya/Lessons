public class Task05 {
    public static void main(String[] args) {
        /*Task 5
        Явное преобразование double в int
        Напишите программу, которая:

        Объявляет переменную double с именем myDouble и присваивает ей значение 5.99.
        Преобразует myDouble в int с помощью явного преобразования и сохраняет результат в переменную int с именем myInt.
        Выводит значение myInt на экран.
         */
        double myDouble = 5.99;
        int myInt = (int) myDouble;

        System.out.println("Значение myInt: " + myInt);
    }
}
