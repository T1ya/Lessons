package homework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static Random rand = new Random();
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkList = new LinkedList<>();
        for (int i = 0; i < 5001; i++) {
            arrList.add(rand.nextInt(1001));
            linkList.add(rand.nextInt(1001));
        }

        System.out.println("Arrays and Linked lists performance test (milliseconds)");
        System.out.println("1.\tGet all List values speed:");
        System.out.printf("\tArrayList:\t%d ms\n", getListValues(arrList));
        System.out.printf("\tLinkedList:\t%d ms\n", getListValues(linkList));

        System.out.println("2.\tInsert new values by index speed:");
        System.out.printf("\tArrayList:\t%d ms\n", insertByIndex(arrList));
        System.out.printf("\tLinkedList:\t%d ms\n", insertByIndex(linkList));

        System.out.println("3.\tDelete elements by index speed:");
        System.out.printf("\tArrayList:\t%d ms\n", deleteByIndex(arrList));
        System.out.printf("\tLinkedList:\t%d ms\n", deleteByIndex(linkList));

        System.out.println("4.\tDelete elements by value speed:");
        System.out.printf("\tArrayList:\t%d ms\n", deleteByValue(arrList));
        System.out.printf("\tLinkedList:\t%d ms\n", deleteByValue(linkList));

        System.out.println("5.\tTotal tests time:");
        System.out.printf("\tArrayList:\t%d ms\n", totalTestTime(arrList));
        System.out.printf("\tLinkedList:\t%d ms\n", totalTestTime(linkList));

    }

    private static long getListValues(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        Integer value;
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long insertByIndex(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            list.add(rand.nextInt(list.size()), rand.nextInt(1001));
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long deleteByIndex(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            list.remove(rand.nextInt(list.size()));
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long deleteByValue(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int randomVal = rand.nextInt(10001);
            list.remove((Integer) randomVal);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long totalTestTime(List<Integer> list) {
        return getListValues(list) +
        insertByIndex(list) +
        deleteByIndex(list) +
        deleteByValue(list);
    }

}
