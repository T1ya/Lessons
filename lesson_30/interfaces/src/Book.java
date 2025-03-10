
//имплементация от интерфейса (или реализация интерфейса) - implements
//при имплементации интерфейса класс обязан реализовать все его абстрактные методы
public class Book implements Printable{
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public void print() {
        System.out.printf("Book: \"%s,\" author %s\n",title, author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void defaultMethod() {
        System.out.println("Buy book online!");
    }
}
