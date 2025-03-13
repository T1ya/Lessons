import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        MyList<String> myStrings = new MyArrayList<>();
        myStrings.addAll("Hello","World","Java");

        Iterator<String> iterator = myStrings.iterator();
        while (iterator.hasNext()) {
            String curStr = iterator.next();
            System.out.println(curStr);
        }
        // цикл foreach
        MyList<Integer> myNums = new MyArrayList<>();
        myNums.addAll(1,2,3,4,5,6);

        for (Integer n: myNums) {
            System.out.println(n.intValue()*2);
        }

        int[] arrayNums = {10,20,30,40,50};
        for (int n: arrayNums) {
            System.out.println(n*2);
        }
    }
}
