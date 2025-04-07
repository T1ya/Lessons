package validator;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    String firstEmail = "example@gmail.com";
    String firstPassword = "Qwerty123@";
    Person person;

    @BeforeEach
    void init() {
        person = new Person(firstPassword, firstEmail);
    }

    @ValueSource(strings = {
                    "e@d.c", // слишком короткий адрес
                    "exampledomain.com", // нет собаки
                    "example@@domain.com", // две собаки
                    "example@domain", // нет точки
                    "example@..domain", // две точки после собаки
                    "example..@domain", // две точки перед собакой
                    "example@.com", // точка сразу после собаки
                    "@domain.com", // нет символов перед собакой
                    "ex.@domaincom", // нет буквы перед собакой
                    "example@domain.subdomain.com.", // точка в конце домена
                    "example@domain,com", // неверный символ ',' вместо '.'
                    "example@domain.c", // короткое доменное расширение
                    "exa mple@domain.com", // Пробел внутри email
                    "example@domain.123", // Неверное доменное расширение (цифры))
    })

    @ParameterizedTest
    void invalidEmailTest(String invalidEmail) {
        person.setEmail(invalidEmail);
        assertNotEquals(person.getEmail(),invalidEmail,"invalid email should not be set");
    }
    @ValueSource(strings = {
            "example@domain.com", //обычный домен com
            "example@domain.eu", //обычный домен eu
            "example@d.eu", //обычный короткий домен
            "ex@d.eu", //минимально допустимый домен
            "example@domain.subdomain.com" //многоуровневый домен
    })

    @ParameterizedTest
    void validEmailTest(String validEmail) {
        person.setEmail(validEmail);
        assertEquals(person.getEmail(),validEmail,"valid emails should be set");
    }
    @ValueSource(strings = {
            "Password123",   // нет спецсимволов
            "12345678",      // только цифры
            "password01@",   // нет заглавных букв
            "PASSWORD01@",   // нет строчных букв
            "Passw+rd",      // недопустимый символ "+"
            "Ab1@",          // слишком короткий (меньше 8 символов)
            "OnlyLetters",   // нет цифр и спецсимволов
    })

    @ParameterizedTest
    void invalidPasswordTest(String invalidPassword) {
        person.setPassword(invalidPassword);
        assertNotEquals(person.getPassword(),invalidPassword,"invalid passwords should not be set");
    }

    @ValueSource(strings = {
            "Qwerty01@%",                 // валидный пароль с различными символами             // минимально возможный короткий пароль
            "Short@12",                   // минимально возможный короткий пароль
            "I@mLongAndVALIDpasswOrD123", // длинный валидный пароль
    })
    @ParameterizedTest
    void validPasswordTest(String validPassword) {
        person.setPassword(validPassword);
        assertEquals(validPassword, person.getPassword(), "valid passwords should be set");
    }
}