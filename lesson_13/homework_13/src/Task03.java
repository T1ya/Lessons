import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        /*
        Task 3* (Опционально)
        Попросите пользователя ввести строку чётной длины с клавиатуры.
        Распечатайте два средних символа строки.
        Например:

        Для строки "string" результат будет "ri".
        Для строки "code" результат будет "od".
        Для строки "Practice" результат будет "ct".
         */
        Scanner scanner = new Scanner(System.in);

        String userInput = "";
        System.out.println("Please enter a string that has even length: ");
        //check for correct length for user input
        while (true)
        {
            userInput = scanner.nextLine();
            int userLength = userInput.length();

            if (userLength % 2 == 0 && userLength != 0) {
                break;
            } else {
                System.out.printf("Your string has %d symbols. Please enter string that has even length:\n",userLength);
            }
        }
        //get middle symbols
        char firstSymbol = userInput.charAt(userInput.length()/2 - 1);
        char secondSymbol = userInput.charAt(userInput.length()/2);
        //output
        System.out.printf("The two middle characters are: %c%c%n",firstSymbol,secondSymbol);

    }
}
