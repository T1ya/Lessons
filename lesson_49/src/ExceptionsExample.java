import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionsExample {
    public static void main(String[] args) {
        // ошибки компиляции - отслеживаются программой

        // int a = "hello";
        // int b = 1

        // ошибки выполнения (Runtime) - не отслеживает...
        //int[] arr = {1,3,4,5};
        //        arr[100] = 3;

        // и для этого мы используем Exceptions
            /*
            исключения в Java - это объект определённого класса, наследуемого от мастер-класса Throwable, который сигнализирует о том, что произошла аварийная ситуация

            а обработка ошибок - это возможность предусмотреть появление ошибок определённого класса и обработать с помощью кода

            try{
                код, который может вызвать исключение
           }
           catch(Exception ex1){
                //код для обработки исключения
                //код, который будет выполнен при возникновении объекта определённого класса
           }
           catch(Exception ex2){
                //второй код. Похоже на switch без проскальзывания
           }
           finally {
                //этот код выполнится в любом случае
           }
             */
        int[] arr = {1, 3, 4, 5};
        try {
            arr[10] = 10;
            System.out.println("Трай появится");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Кетч появится: " + exception.getMessage());
        }

        try {
            System.out.println("Трай2 появится");
            arr[2] = 10;
            System.out.println("Трай2 не появится!");
        } catch (ArrayIndexOutOfBoundsException exception) {
            // а без ошибок блок кетч не вызывается
            System.out.println("Кетч не появится: " + exception.getMessage());
        }


        try {
            arr[10] = 100;
        } catch (ArrayIndexOutOfBoundsException ex) {
            //если найдёт ошибку - обработает её и прекратит работу. до следующего кетча дело не дойдёт
            System.out.println("Ошибка индекса - " + ex.getMessage());
        } catch (Exception ex2) {
            //в самом конце - если до него вдруг дойдёт - продолжит работу, но выведет в консоль общее сообщение об ошибке
            ex2.printStackTrace();
        }


        // После трай кетч программа продолжает работу, а не крашится
        System.out.println("Resume work");
        System.out.println("===============================");
        // Проверяемые и непроверяемые исключения

        // Проверяемые (checked exceptions) - наличие таких исключений вы обязаны проверить и обработать
        // хотя бы через try-catch

        // Непроверяемые исключения - наличие их появлений мы не обязаны предусматривать и обрабатывать в коде
        //
        String result = getUrlString();
        System.out.println("Result: " + result);

        try {
            String result2 = getUrlString2();   //так нельзя, нужно завернуть в обрабоку ошибок
        } catch (MalformedURLException e) {
            System.out.println("Неверный формат URL2 " + e.getMessage());
        }
//        String result2 = getUrlString2();   //так нельзя, нужно завернуть в обрабоку ошибок

    }

    private static String getUrlString() {
        URL myUrl = null;

        try {
            myUrl = new URL("htt://example.com");  // обязаны написать try-catch
        } catch (MalformedURLException e) {
            System.out.println("Неверный формат URL " + e.getMessage());
            return "https://google.com";
        }
        return myUrl.toString();
    }
    //throws - в сигнатуре метода говорим, что метод может вызвать исключение
    private static String getUrlString2() throws MalformedURLException {
        URL myUrl = new URL("htt://example.com");
        return myUrl.toString();
    }

}
