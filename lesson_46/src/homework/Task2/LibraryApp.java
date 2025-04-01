package homework.Task2;

import java.util.List;
import java.util.Optional;

public class LibraryApp {
    static Library library = new Library();

    static {
        library.addBook(new Book("Одиссея", "Гомер"));
        library.addBook(new Book("1984", "Дж. Оруэлл"));
        library.addBook(new Book("Оно", "Стивен Кинг"));
    }

    public static void main(String[] args) {

        findBookByTitle("оно").ifPresentOrElse(
                book -> System.out.println("Книга найдена: " + book),
                () -> System.out.println("Книга не найдена")
        );
        findBookByTitle("Троя").ifPresentOrElse(
                book -> System.out.println("Книга найдена: " + book),
                () -> System.out.println("Книга не найдена")
        );

    }

    static Optional<Book> findBookByTitle(String title) {
        List<Book> books = library.getBooks();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }
}
