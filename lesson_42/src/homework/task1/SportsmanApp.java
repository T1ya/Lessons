package homework.task1;

import java.util.Arrays;
import java.util.Comparator;

public class SportsmanApp {
    public static void main(String[] args) {
        Sportsman[] sportsmen = new Sportsman[6];
        sportsmen[0] = new Sportsman("Bob",16, 9.8);
        sportsmen[1] = new Sportsman("Jack",16, 8.2);
        sportsmen[2] = new Sportsman("Dan",19, 7.0);
        sportsmen[3] = new Sportsman("Anna",19, 9.8);
        sportsmen[4] = new Sportsman("Louis",21, 8.8);
        sportsmen[5] = new Sportsman("Bob",18, 10.0);

        printSportsman(sportsmen, "Default order:");
        Arrays.sort(sportsmen);
        printSportsman(sportsmen, "Sort by name:");

        SportsmanAgeCompare ageCompare = new SportsmanAgeCompare();
        Arrays.sort(sportsmen, ageCompare);
        printSportsman(sportsmen, "Sort by age:");

        Arrays.sort(sportsmen, (s1,s2)->Double.compare(s1.getScore(),s2.getScore()));
        printSportsman(sportsmen, "Sort by score:");
    }

    public static void printSportsman(Sportsman[] ppl, String msg) {
        System.out.println(msg);
        System.out.println("===============");
        for (Sportsman s: ppl) {
            System.out.println(s);
        }
        System.out.println("===============");
    }
}
