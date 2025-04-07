package validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static validator.PersonValidator.validateEmail;
import static validator.PersonValidator.validatePassword;

class PersonValidatorTest {
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
        assertThrows(EmailValidateException.class, () -> {
            validateEmail(invalidEmail);
        });
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
        assertThrows(PasswordValidateException.class, ()->{
            validatePassword(invalidPassword);
        });
    }

    @ValueSource(strings = {
            "Qwerty01@%",                 // валидный пароль с различными символами             // минимально возможный короткий пароль
            "Short@12",                   // минимально возможный короткий пароль
            "I@mLongAndVALIDpasswOrD123", // длинный валидный пароль
    })

    @ParameterizedTest
    void validPasswordTest(String validPassword) {
        assertDoesNotThrow(()->validatePassword(validPassword), "valid password throws no exceptions");
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
        assertDoesNotThrow(()->validateEmail(validEmail), "valid email throws no exceptions");
    }
}