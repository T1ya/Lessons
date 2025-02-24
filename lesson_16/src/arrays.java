import java.util.Random;

public class arrays {
    public static void main(String[] args) {
        int[] num = new int[10];
        Random r = new Random();
        int i = 0;
        while (i < num.length) {
            num[i] = r.nextInt(101);
            i++;
        }
        //find max
        i = 1;
        int max = num[i];
        while (i < num.length){
            if (num[i] > max){
                max = num[i];
            }
            i++;
        }
        System.out.println("Max = " + max);
    }
}
