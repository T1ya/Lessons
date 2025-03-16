import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


//второй способ - тесты могут выполняться по алфавитному порядку тестовых методов
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderedTestsByName {
    @Test

    void testA() {
        System.out.println("First test");
    }

    @Test
    void testC() {
        System.out.println("Second test");
    }

    @Test
    void testB() {
        System.out.println("Third test");
    }

    @Test
    void testX() {
        System.out.println("Random test");
    }
}
