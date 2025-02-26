package homework;

public class TestMagicArray {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        System.out.println("В numbers ячеек: " + numbers.length);

        // [1, 3,  5, 4, 100]
        // add(100), remove(5) - [1, 3,  4, 100]. add(1000) - [1, 3,  4, 1000]

        MagicArray magic = new MagicArray();

        System.out.println(magic.toString());

        magic.add(5);
        magic.add(20);
        magic.add(0);
        magic.add(100);
        magic.add(6, 7, 8);
        magic.add(10, 20, 30);

        System.out.println("В массиве сейчас элементов: " + magic.size());

        String arrayToString = magic.toString();
        System.out.println("arrayToString: " + arrayToString);
        System.out.print("Внутренний массив: ");
        magic.test();

        System.out.println("\n================");
        int value = magic.get(0);
        System.out.println("magic.get(0): " + value);

//        System.out.println("magic.get(15): " + magic.get(15));
//        System.out.println("magic.get(-1): " + magic.get(-1));
//        System.out.println("magic.get(30): " + magic.get(30));

        int oldValue = magic.remove(3);
        System.out.println("magic.remove(3): " + oldValue);
        System.out.println(magic.toString());
        System.out.println("size: " + magic.size());
//        System.out.print("Внутренний массив: ");
//        magic.test();
        // System.out.println(magic.remove(20));

        System.out.println("\n================");
        System.out.println("magic.indexOf(20): " + magic.indexOf(20));

        int index = magic.indexOf(500);
        System.out.println("magic.indexOf(500): " + index);

        if (index >= 0) {
            System.out.println("Значение было найдено");
        } else {
            System.out.println("Вернулся отрицательный индекс. Такое значения в массиве нет");
        }

        // Homework

        // Тест конструктора, принимающего обычный массив
        int[] initialArray = {1, 2, 3, 4, 5, 2, 6, 2};

        MagicArray magicArray = new MagicArray(initialArray);   // принимаем валидный массив
        System.out.println("MagicArray for {1, 2, 3, 4, 5, 2, 6, 2}: " + magicArray);
        MagicArray magicArrayWithNull = new MagicArray(null); // принимаем битый массив
        System.out.println("MagicArray for null (created default): " + magicArrayWithNull);

        // Тест индекса последнего вхождения
        int lastIndexOf100 = magicArray.lastIndexOf(100);   // такого элемента нет
        System.out.println("Index of last occurrence of 100 (not found): " + lastIndexOf100);
        int lastIndexOf2 = magicArray.lastIndexOf(2);   // а такой элемент есть
        System.out.println("Index of last occurrence of 2: " + lastIndexOf2);


        // Тест удаления элемента по значению:
        boolean removedNotFound = magicArray.removeByValue(100); // такого элемента нет
        System.out.println("Removed occurrence of 100 (not found): " + removedNotFound);
        System.out.println("MagicArray after trying to remove 100: " + magicArray);

        boolean removed = magicArray.removeByValue(2);  // а такой элемент есть
        System.out.println("Removed first occurrence of 2: " + removed);
        System.out.println("MagicArray after removing first occurrence of 2: " + magicArray);

    }
}
