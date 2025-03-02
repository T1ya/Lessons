package homework;

import java.util.Arrays;

public class MagicArrayIncaps {
    // делаем свойства private
    private int[] array;
    private int cursor; // по умолчанию = 0
    // добавлять для свойств геттеры и сеттеры отдельно я не буду, так как доступ извне к ним давать не следует.

    // Методы, расширяющие функционал массива
    //конструкторы всегда будут public, иначе новый экземпляр класса не создать
    public MagicArrayIncaps() {
        this.array = new int[10]; // [0, 0...0]
    }

    public MagicArrayIncaps(int[] array) {
        //  Todo Homework
        if (array == null || array.length == 0) {
            // проверка переданного массива. В случае если передан пустой массив, создадим массив по умолчанию
            this.array = new int[11];
            this.cursor = 0;
        } else {
            // Создаем новый массив с помощью метода add.
            // А чтобы избежать операции расширения массива, сделаем его сразу вдвое больше
            this.array = new int[array.length*2];
            // Копируем элементы
            this.add(array);
            // актуализируем курсор.
            this.cursor = array.length;
        }
    }
    // методы класса будут инкапсулированы по следующей логике:
    // public будут только те методы, которые обеспечивают минимально необходимый интерфейс для работы с классом извне.

    // Добавление в массив одного элемента
    public void add(int value) {

        // Проверка! Есть ли свободное место во внутреннем массиве
        // Если места нет - нужно добавить место

        if (cursor == array.length) {
            // Расширить внутренний массив перед добавлением нового значения
            expandArray();
        }

        array[cursor] = value;
        cursor++;
    }

    // Динамическое расширение массива
    private void expandArray() {
        System.out.println("Расширяем внутренний массив! Курсор = " + cursor);
        /*
        1. Создать новый массив бОльшего размера (в 2 раза больше)
        2. Переписать в новый массив все значения из старого (до курсора)
        3. Перебросить ссылку
         */

        // Shift + Alt + стрелки вверх / вниз | Mac: Shift + Opt + Стрелка

        // 1
        int[] newArray = new int[array.length * 2];

        // 2
        for (int i = 0; i < cursor; i++) {
            newArray[i] = array[i];
        }

        // 3. Перебрасываем ссылку. Переменная array хранит ссылку на "новый" массив
        array = newArray;
    }

    // Добавление в массив нескольких элементов
    public void add(int... numbers) {
        // с numbers я могу обращаться точно также, как со ссылкой на массив int
//        System.out.println("Принял несколько int: " + numbers.length);
//        System.out.println(Arrays.toString(numbers));
//        System.out.println("У каждого инта есть индекс, как в массиве: " + numbers[0]);

        // перебираю все значение. Для каждого вызываю метод add()
        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }


    // Возвращает строковое представление массива - делаем public
    // [5, 20, 45]
    public String toString() {

        if (cursor == 0) return "[]";

        String result = "[";
        for (int i = 0; i < cursor; i++) {
            result += array[i] + (i < cursor - 1 ? ", " : "]");
        }

        return result;
    }

    // Текущее кол-во элементов в массиве - возвращает размер, безопасен, можно делать public
    public int size() {
        return cursor;
    }

    // Возвращает значение по индексу - тоже безопасен и может быть доступен вне класса
    public int get(int index) {
        // Проконтролировать входящий индекс!

        if (index >= 0 && index < cursor) {
            return array[index];
        }

        // Fixme Указать место в коде с ошибкой / проблей

        // Код, если индекс не корректный
        // Хорошего решения нет
        return -2_147_483_647;
        // Todo Поправить обработку некорректного индекса
    }

    // Удалить элемент по индексу
    public int remove(int index) {
        /*
        1. Проверка индекса на валидность
        2. Удалить значение по индексу
        3. Передвинуть курсор (т.к. кол-во элементов уменьшилось)
        4. Вернуть старое значение
         */

        if (index >= 0 && index < cursor) {
            // Логика удаления
            int value = array[index]; // запомнить старое значение

            // Перебираем элементы начиная с индекса и перезаписываем значением из ячейки справа
            for (int i = index; i < cursor - 1; i++) { // граница перебора индексов
                array[i] = array[i + 1];
            }

            cursor--;

            return value; // вернуть старое значение

        } else {
            // Индекс не валидный
            // Todo поправить возвращаемое значение
            return -2_147_483_647;
        }

    }

    // Поиск по значению - public, интерфейсный метод
    // {1, 100, 5, 24, 0, 5} -> indexOf(5) = 2; indexOf(50) = -1;
    public int indexOf(int value) {
        // Перебираю все значимые элементы.
        // Если элемент равен искомому - вернуть индекс такого элемента
        // Если перебрал все элементы =- не нашел совпадений - вернуть -1

        for (int i = 0; i < cursor; i++) {
            if (array[i] == value) {
                // Значения совпали. Возвращаю индекс
                return i;
            }
        }

        // Сюда мы попадем, если ни одно значение в массиве не совпало
        return  -1;
    }

    // Индекс последнего вхождения- public, интерфейсный метод
    // {1, 100, 5, 100, 24, 0, 100} -> lastIndexOf(100) -> 6
    public int lastIndexOf(int value) {
        // Todo Homework
        // проходим цикл с конца и возвращаем индекс первого найденного элемента
        for (int i = cursor - 1; i >= 0; i--) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Удаление элемента по значению - public, должен быть доступен извне. Позволяет БЕЗОПАСНО удалить элемент массива
    public boolean removeByValue(int value) {
        // Todo Homework
        // тут можно использовать indexOf или lastIndexOf...
        // чтобы удалить первый найденный элемент в массиве, я использую indexOf
        // а вот если бы мне нужно было удалить ВСЕ элементы по значению - я бы взял lastIndexOf в цикле
        // (так удобнее удалять без проблем со смещением).
        int index = indexOf(value);
        if (index != -1) {
            //remove у нас уже реализован.
            remove(index);
            return true;
        }
        return false;
    }

    // Массив, состоящий из элементов магического массива - public интерфейсный метод
    public int[] toArray() {
        int[] result = new int[cursor];
        for (int i = 0; i < cursor; i++) {
            result[i] = array[i];
        }
        return result;
    }

    // тестовый метод, распечатывает массив - пока оставим public
    public void test() {
        System.out.println(Arrays.toString(array));
    }

}

