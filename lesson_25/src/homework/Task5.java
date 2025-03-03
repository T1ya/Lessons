package homework;

import java.util.Random;

public class Task5 {
    // собака прыгает через все барьеры
    public static int dogGetBarriers(Dog dog, int[] barriers) {
        int result = 0;
        for (int i = 0; i < barriers.length; i++) {
            if (dog.jumpBarrier(barriers[i])) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        // массив собак
        Dog[] dogs = {
            new Dog("Rex", rand.nextInt(50) + 30),
            new Dog("Zak", rand.nextInt(50) + 30),
            new Dog("Colette", rand.nextInt(50) + 30),
            new Dog("Juna", rand.nextInt(50) + 30),
            new Dog("Luz", rand.nextInt(50) + 30)
        };
        // массив барьеров
        int[] barriers = new int[7];
        for (int i = 0; i < 7; i++) {
            barriers[i] = rand.nextInt(100) + 70;
        }
        // прыгаем всеми собаками через все барьеры
        for (Dog dog : dogs) {
            System.out.printf("%s can take %d barriers\n", dog.getName(), dogGetBarriers(dog, barriers));
        }
    }
}
