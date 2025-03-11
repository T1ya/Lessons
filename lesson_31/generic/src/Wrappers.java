public class Wrappers {
    public static void main(String[] args) {
        // ссылочный тип данных, расширяющий возможности примитива, называют Враппером

        Integer maxVal = Integer.MAX_VALUE;
        System.out.println("Max value = " + maxVal);
        System.out.println("Min value = " + Integer.MIN_VALUE);

        //есть поддержка null (int не поддерживал)
        maxVal = null;

        //приведение типов. Автоупаковка и автораспаковка
        Integer wrapperInt = 5; //Автоупаковка примитива int в ссылочный тип integer
        System.out.println("Wrapper int = " + wrapperInt);
        int primitiveInt = wrapperInt; //Автораспаковка - ссылочный тип integer автоматически преобразуется к примитиву int
        System.out.println("Primitive int = " + primitiveInt);
        // так как это не примиив в чистом виде, он позволяет использовать дженерики! (см GenericApp)

        //сравнение объектов - сравнивает ССЫЛКИ на объект в памяти
        Integer a = 127;    //создан объект с адресом памяти @2ааа2, диапазон 1 байт(-128, 127).
        Integer b = 127;    //новый объект не создаётся, работаем со ссылкой на уже существующий @2ааа2
        System.out.println("127 == 127: " + (a == b));    //true

        Integer c = 128;    //мы вышли за диапазон в 1 байт! Адрес памяти  - например, @3ссс1
        Integer d = 128;    //тоже вышли за диапазон,создаётся новый объект @2асс4
        System.out.println("128 == 128: " + (c == d));    //false!
        // мораль. Сравнение через ==  лучше не использовать) используем equals!
        System.out.println("128 == 128: " + (c.equals(d)));
    }
}
