import java.util.Random;

public class for_loop {
    public static void main(String[] args) {

        Random r = new Random();
        int[] arr = new int[r.nextInt(5,16)];

        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(101);
            if (i == 0) min = arr[i];
            if (arr[i] < min) min = arr[i];
            System.out.println(arr[i]);
        }
        System.out.println("Min value = " + min);
    }

}
