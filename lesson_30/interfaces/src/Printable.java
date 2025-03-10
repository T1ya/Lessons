//в отличие от класса, который содержит и атрибуты и поведение объекта,
//интерфейс содержит только поведение

public interface Printable {
    //интерфейс - это совокупность абстрактных методов, задающих поведение объекта.

    //все методы интерфейса неявно и по умолчанию являются публичными и абстракными
    void print();
    //кроме методов по умолчанию - они обязаны иметь реализацию
    default void defaultMethod() {
        System.out.println("Subscribe!");
    }

    // могут быть и статические методы
    public static void testStaticMethod(String str) {
        System.out.println("Static " + str);
    }
}
