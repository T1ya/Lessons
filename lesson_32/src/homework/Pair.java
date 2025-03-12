package homework;

public class Pair<T> implements PairInterface<T> {
    private T firstElement;
    private T secondElement;

    public Pair(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }


    @Override
    public T getFirst() {
        return firstElement;
    }

    @Override
    public T getSecond() {
        return secondElement;
    }

    @Override
    public void setFirst(T value) {
        firstElement = value;
    }

    @Override
    public void setSecond(T value) {
        secondElement = value;
    }

    @Override
    public void swap() {
        T temp = firstElement;
        firstElement = secondElement;
        secondElement = temp;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstElement=" + firstElement +
                ", secondElement=" + secondElement +
                '}';
    }
}
