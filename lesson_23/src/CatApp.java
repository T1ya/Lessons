public class CatApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Kitty", 4,2.455);
        cat.sayMeow();


        cat.setAge(123); //no-go
        System.out.println(cat.toString());
        cat.setAge(2);
        System.out.println(cat.toString());
    }
}
