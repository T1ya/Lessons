public class Overflow {
    public static void main(String[] args) {
        //hint. Overflow is the same as clock face: when we add 1 to 12 we get 1, when we substract from 1 we get 12
        //byte = -128...127
        byte byteWar = 127;
        //overflow! Get -128 )
        byteWar ++;
        System.out.println(byteWar);
        //short = -32768...32767
        short shortWar = 32767;
        shortWar ++;
        System.out.println(shortWar);
        shortWar --;
        System.out.println(shortWar);
        //N.B.: если числитель меньше знаменателя, то остаток от деления всегда будет равен числителю
        double result = 9%231321;
        System.out.println(result);

        //форматированный вывод - команда System.out.printf()
        //место, куда вставляем значение переменной, помечаем значком %
        // %d - целое число (digit)
        // %f - число с плавающей точкой (float)
            // %.2f - указывает количество знаков после запятой (форматирует float)
        // %s - строка (string)
        // %n - перевод каретки
        // примерный вид - System.out.printf("Hi, I am %s, %d years old, my weight is %f", name, 18, 56.5)

        System.out.printf("Hi, I am %s, %d years old, my weight is .%.2f%n", "Lisa", 18, 56.5);

        //printf автоматически НЕ добавляет символ перевода каретки, а println  - добавляет
        //
        System.out.println("Hello");
        System.out.printf("World");
        System.out.printf("...woops");

        //сниппеты для выводов - sout для println, souf - printf
    }
}
