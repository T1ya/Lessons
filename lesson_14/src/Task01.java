import java.util.Locale;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        //Locale отвечает за разнообразные региональные настройки, в том числе и за используемый разделитель
        // Данные с разделителем запятая
        String data = "123,3 44,3";
        Scanner scanner = new Scanner(data);


        // Изменение локали сканера на российскую, где используется запятая как десятичный разделитель
        scanner.useLocale(Locale.FRANCE); // Можно использовать Locale.FRANCE или Locale.GERMANY

        System.out.println(scanner.nextDouble());
        System.out.println(scanner.nextDouble());
        //Locale можно изменить для конкретного сканера, не меняя настройки во всей системе
        //Для разделителя точки можем использовать English или US
        String text = "456.78 789.01";
        Scanner sc = new Scanner(text);
        sc.useLocale(Locale.ENGLISH);

        System.out.println(sc.nextDouble());
        System.out.println(sc.nextDouble());

    }

}
