package persons;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import transport.Bus;
import transport.BusDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    @BeforeEach //метод, помеченный такой аннотацией, будет выполнятся перед каждым тестовым методом
    void setUp() {
        System.out.println("Before each!");
    }

    //аннотация Тест указывает, что метод является тестовым
    //так фреймворк понимает, что этот метод нужно запустить во время выполнения тестов
    @Test
    public void testAddition() {
        System.out.println("Test addition");
        int result = Calculator.add(2,5);

        //методы проверки утверждений
        Assertions.assertEquals(7,result);  //проверяет два значения на равенство
        Assertions.assertNotEquals(0, result);  // на неравенство
        Assertions.assertTrue(result>=2);
        //статический импорт - статические методы можно использовать без обращения к статическому классу
        assertFalse(result >25);
        assertNull(null);
    }
    // метод считается пройденым, если в нём нет НИ ОДНОГО ложного утверждения. Даже есл метод пустой
    @Test
    public void testEmpty() {
        System.out.println("Test empty");
    }

    @Disabled //тест запускаться не будет
    void brokenTest() {
        System.out.println("I'm broken!");
    }

    @AfterAll   //выполнится последним
    public static void lastMethod() {
        System.out.println("After all");
    }

    // параметризированные тесты

    @ParameterizedTest  //их аннотация
    @ValueSource(strings = {"apple", "banana","cherry", "dope"})    //источник параметров
    void testFruits(String fruit) {
        // тест будет запущен несколько раз
        // в параметр будут подставлены все значения VS по очереди
        // все вызовы считается отдельными вызовами метода - перед каждым вызовом будет вызван например BeforeEach
        System.out.println("Current value - " + fruit);
        assertNotNull(fruit);
        //assertTrue(fruit.length() > 4);
    }

    //а со статикой у них проблемы - параметризированные тесты статику не обновляют
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void testStatic(int value) {
        System.out.println("Static goes!");
        Bus bus = new Bus(new BusDriver("Bob","123"), 10);
        System.out.println(bus);
    }

    //источник данных CSV
    //источник данных CSV file

    //источник данных - метод
    @ParameterizedTest
    @MethodSource("testDataFruits")
    void testMethodSourseFruit(String fruit) {
        System.out.println("Stream fruit - " + fruit);
    }

    static Stream<String> testDataFruits() {
        return Stream.of("apple", "banana","cherry", "dope");
    }

    @ParameterizedTest
    @MethodSource("testDataArgs")
    void testSourceArgs(int value, int expected, boolean isEqual) {
        System.out.println(value + "|" + expected + "|" + isEqual);
        int result = value*value;
        assertEquals(expected,result);
    }

    static Stream<Arguments> testDataArgs() {
        return Stream.of(
                Arguments.of(4,16,true)
        );
    }

    @ParameterizedTest
    @MethodSource("testPersonData")
    void testMethodSourcePerson(Person person, String email) {
        System.out.println("Current person - " + person);
        System.out.println("Email - " + email);
    }

    static Stream<Arguments> testPersonData() {
        Person person = new Person("123As#comSd", "12asd3As@.com");
        Person enchanter = new Person("123As#comSd", "ENCH3As@.com");
        Person tim = new Person("123As#comSd", "TimTheEnchanter@.com");
        return Stream.of(Arguments.of(person));
    }
}

