package homework;

public class Task4 {
    public void printMessage(final String message) {
        // message = "Yay " + message; // выдаст ошибку, так параметр, переданный как final не может быть изменён внутри метода
        System.out.println(message);
    }
}
