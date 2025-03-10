public class Application {
    public static void main(String[] args) {
        Book raven  = new Book("E.Poe", "Raven");
        raven.print();

        Magazine vogue = new Magazine("Vogue",131);
        vogue.print();

        Printable printable = vogue;
        Printable printable1 = new Book("B.Eckel", "Java Filosfy");
        printable1.print();

        // начиная с JDK 8 в Java используются методы по умолчанию (имеющие реализацию)
        printable.defaultMethod();
        // их можно переопределять
        raven.defaultMethod();
        // начиная с JDK 8 в Java доступны статические методы!
        Printable.testStaticMethod("tested!");
    }

}
