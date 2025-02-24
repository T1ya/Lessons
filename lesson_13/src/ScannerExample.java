import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {

        //строка подготавливает программу для чтения данных из стандартного потока ввода от пользователя через клавиатуру
        Scanner scanner = new Scanner(System.in); //автоматически импортирует нужную библиотеку - см 1 строку, подтянулась автоматом
        System.out.println("Enter your name: ");
        // читает ВСЮ введённую пользователем строку до нажатия на Enter
        String name = scanner.nextLine();

        System.out.println("Hi, " + name);


        System.out.println("Enter your age ");
        //прочитать число тоже можно
        int age = scanner.nextInt();
        //а дальше будут проблемки -nextLine считывают токенами, не читая ничего кроме самого числа. Например, перевод каретки останется "в буфере"
        //поэтому ВСЕГДА после методов nextInt, nextDouble и т. д. следует вызывать nextLine, чтобы он дочитал строку до конца)
        scanner.nextLine();
        System.out.println("Great, your age is " + age);

        System.out.println("Your city - ");
        String city = scanner.nextLine();

        System.out.println("You live in, " + city);

    }
}
