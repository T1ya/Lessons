package validator;

public class PersonValidator {
    private static final int PASS_MIN_LENGTH = 8;
    private static final int EMAIL_MIN_LENGTH = 6;
    private static final String SYMBOLS = "\"!%$@&*()[],\"";

    public static void validateEmail(String email) throws EmailValidateException {
        //throw - ключевое слово, используется для выброса объектов исключения

        //проверка на длину email
        if (email == null || email.length() < EMAIL_MIN_LENGTH) throw new EmailValidateException("short email");
        // Проверка '@'
        int indexAt = email.indexOf('@'); // Есть только один символ '@'
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) throw new EmailValidateException("symbol @ error");
        // Перед '@' должна быть минимум одна буква
        if (!Character.isLetter(email.charAt(0))) throw new EmailValidateException("should be letter before @");
        // После '@' должна быть минимум одна буква
        if (!Character.isLetter(email.charAt(indexAt + 1))) throw new EmailValidateException("should be letter after @");
        // Проверка доменной части
        int dotAfterAt = email.lastIndexOf('.');
        if (dotAfterAt == -1 || dotAfterAt >= email.length() - 2) throw new EmailValidateException("wrong domain name");
        // Проверка двух точек подряд
        if (email.contains("..")) throw new EmailValidateException("two dots error");
        // Проверка пробелов
        if (email.contains(" ")) throw new EmailValidateException("spaces are not allowed");

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            //проверка на валидность символов
            boolean isPass = Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '.' || c == '_' || c == '@';
            if (!isPass) throw new EmailValidateException("invalid symbols in address");
            //после последнего символа '.' должны идти только буквы
            if (i > dotAfterAt && !Character.isAlphabetic(c)) throw new EmailValidateException("invalid symbols after dot");
        }
    }
    /*
    Добавить в класс валидацию пароля.
    При провале валидации выбросить исключение: PasswordValidateException
     */

    public static void validatePassword(String password) throws PasswordValidateException {
        //проверка на длину пароля в 8 символов. И на null
        if (password == null || password.length() < PASS_MIN_LENGTH) {
            throw new PasswordValidateException("short or empty password");
        }
        //проверка на пробельные символы
        if (password.contains(" ")) throw new PasswordValidateException("spaces are not allowed");

        boolean hasDigit = false;//Должна быть мин 1 цифра
        boolean hasLowerCase = false;//Должна быть мин 1 маленькая буква -> Character.isLowerCase()
        boolean hasUpperCase = false;//Должна быть мин 1 большая буква
        boolean hasSymbol = false;//Должна быть мин 1 специальный символ: "!%$@&*()[],.-"

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isLowerCase(c)) hasLowerCase = true;
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (SYMBOLS.indexOf(c) != -1) hasSymbol = true; //символы я вынес в константу SYMBOLS
        }
        //добавим вывод для неверного пароля
        if (!hasDigit) throw new PasswordValidateException("no digits found");
        if (!hasLowerCase) throw new PasswordValidateException("no lower case letters found");
        if (!hasUpperCase) throw new PasswordValidateException("no upper case letters found");
        if (!hasSymbol) throw new PasswordValidateException("no special symbols found");
    }

}
