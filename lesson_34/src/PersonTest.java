import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;
    String startEmail = "johnTest@gmail.com";
    String startPassword = "Qwerty01@%";

    @BeforeEach
    void setUp() {
        person = new Person(startEmail, startPassword);
    }

    @ParameterizedTest
    @ValueSource(strings = {"welcome@gmail.com","boo@2312","nogebatorXXX@mail.ru"})
    void testValidEmailSet(String validEmail) {
        person.setEmail(validEmail);
        assertEquals(validEmail, person.getEmail());
    }


}