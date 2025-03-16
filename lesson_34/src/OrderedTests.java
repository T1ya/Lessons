import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//как задать порядок выполнения тестов?
//первый способ - OrderAnnotation
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)   // потом используем аннотацию Order у каждого теста
public class OrderedTests {

    @Test
    @Order(10)
    void test1() {
        System.out.println("First test");
    }
    @Order(20)
    @Test
    void test2() {
        System.out.println("Second test");
    }
    @Order(30)
    @Test
    void test3() {
        System.out.println("Third test");
    }

    @Test
    void randomTest() {
        System.out.println("Random test");
    }


}
