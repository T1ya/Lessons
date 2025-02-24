import java.util.Random;

public class Task01 {
    public static void main(String[] args) {
        int money = 100;
        Random r = new Random();
        int grade = r.nextInt(1,6);

        switch (grade) {
            case(5):
                money += 20;
                break;
            case(4):
                money += 10;
                break;
            case(2):
                money -= 20;
                break;
            case(1):
                money = 0;
                break;
        }

        System.out.printf("Kid grade is %d and he has %d money", grade, money);
    }


}
