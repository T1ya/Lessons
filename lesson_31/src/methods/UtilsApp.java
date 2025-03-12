package methods;

import homework.MyArrayList;
import homework.MyList;

import java.util.Arrays;

public class UtilsApp {
    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(ints));
        Utils.swap(ints, 1,9);
        System.out.println(Arrays.toString(ints));

        String[] strings = {"do", "re", "mi", "fa", "sol", "la", "si"};
        MyList<String> myStrings = new MyArrayList<>(strings);

        System.out.println(Utils.getFirstElement(myStrings));

        int sum = Utils.sumElements(ints);
        System.out.println("Sum = " + sum);

        //int sum = Utils.sumElements(strings); //не сработает. Типобезопасность! ))

    }
}
