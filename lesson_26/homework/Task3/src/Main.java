import java.util.Scanner;

public class Main {
    static String makePhraseShort(String str) {
        String words[] = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word: words) {
            // без этой проверки кидает ошибку на строку с начальным пробелом...
            if (!word.isEmpty()){
                char firstLetter = Character.toUpperCase(word.charAt(0));
                result.append(firstLetter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some long phrase... ");
        String phrase = scanner.nextLine();

        System.out.println(makePhraseShort(phrase));
    }
}
