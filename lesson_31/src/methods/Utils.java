package methods;

import homework.MyList;

public class Utils {
    public static <T> void swap(T[] array, int idx1, int idx2) {
        T temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }

    public static <T> T getFirstElement(MyList<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    // а так можно задать ограничение на типы параметров дженерика
    public static <T extends Number> int sumElements(T... elements) {
        int sum = 0;
        for (T el : elements) {
            sum += el.intValue();
        }
        return sum;
    }

    // ? Wildcard - неизвестный тип
    // т.н. ограничение сверху LowerBound - принимает любой тип, являющийся наследником Number
    public static double getSum(MyList<? extends Number> list) {
        double sum = 0;
           for (int i = 0; i < list.size(); i++) {
                sum+= list.get(i).doubleValue();
           }
        return sum;
    }

    // ограничение сверху UpperBound -
    // работаем с неизвестным типом - либо классом Integer, либо его родителем!
    public static void addNumbers(MyList<? super Integer> list,int num) {
        for (int i = 0; i <= num; i++ ) list.add(num);
    }
}
