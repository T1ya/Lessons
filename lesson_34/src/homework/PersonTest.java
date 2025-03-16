package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PersonTest {
    String startEmail = "johnTest@gmail.com";
    String startPassword = "Qwerty01@%";

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
        Person person = new Person(startPassword, startEmail);
        person.setEmail(invalidEmail);
        Assertions.assertEquals(startEmail, person.getEmail(), "Error for email " + invalidEmail);
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
        Person person = new Person(startPassword, startEmail);
        person.setEmail(validEmail);
        Assertions.assertEquals(validEmail, person.getEmail(), "Error for email " + validEmail);
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
    void invalidPassTest(String invalidPassword) {
        Person person = new Person(startPassword, startEmail);
        person.setPassword(invalidPassword);
        Assertions.assertEquals(startPassword, person.getPassword(), "Error for the password " + invalidPassword);
    }

    @ValueSource(strings = {
            "Qwerty01@%",                 // валидный пароль с различными символами             // минимально возможный короткий пароль
            "Short@12",                   // минимально возможный короткий пароль
            "I@mLongAndVALIDpasswOrD123", // длинный валидный пароль
    })
    @ParameterizedTest
    void validPassTest(String validPassword) {
        Person person = new Person(startPassword, startEmail);
        person.setPassword(validPassword);
        Assertions.assertEquals(validPassword, person.getPassword(), "Error for the password " + validPassword);
    }

}