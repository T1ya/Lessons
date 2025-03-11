public class GenericApp {
    public static void main(String[] args) {
        GenericBox <String> genericBox = new GenericBox<>("Hello");
        //now we can use any type methods without casting!
        System.out.println(genericBox.getValue());
        System.out.println(genericBox.getValue().toLowerCase());
        System.out.println(genericBox.getValue().toUpperCase());
        genericBox.setValue("World");
        // and with wrapper Integer we can use genetic safely!
        GenericBox<Integer> intBox = new GenericBox<>(5);
        System.out.println(intBox);

        GenericBox<Integer> intBox1 = new GenericBox<>(125);
        System.out.println(intBox1);

        int sum = intBox1.getValue() + intBox.getValue();
        System.out.println("Sum = " + sum);
    }
}
