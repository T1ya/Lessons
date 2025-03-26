import java.util.Comparator;

public class CarModelComparator implements Comparator <Car> {
    public static void main(String[] args) {

    }

    @Override
    public int compare(Car o1, Car o2) {
        String model1 = o1.getModel();
        String model2 = o2.getModel();
        //String уже имеет реализацию метода Comparable - CompareTo
        return model1.compareTo(model2);
    }
}
