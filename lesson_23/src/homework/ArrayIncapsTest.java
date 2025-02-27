package homework;

public class ArrayIncapsTest {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5};
        MagicArrayIncaps magic = new MagicArrayIncaps(arr);
        //magic.add(10);
        arr[3] = 1000;
        System.out.println(magic.toString());
    }
}
