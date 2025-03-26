package homework.task1;

import java.util.Comparator;

public class SportsmanAgeCompare implements Comparator<Sportsman> {

    @Override
    public int compare(Sportsman s1, Sportsman s2) {
        return s1.getAge() - s2.getAge();
    }
}
