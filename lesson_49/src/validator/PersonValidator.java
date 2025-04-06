package validator;

public class PersonValidator {
    private static final int EMAIL_MIN_LENGTH = 8;

    public static void validateEmail(String email) throws EmailValidateException {
        //throw - ключевое слово, используется для выброса объектов исключения

        //проверка на длину email
        if (email == null || email.length() < EMAIL_MIN_LENGTH) throw new EmailValidateException("Short email");
        // Проверка '@'
        int indexAt = email.indexOf('@'); // Есть только один символ '@'
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) throw new EmailValidateException("Symbol @ error");
        // Перед '@' должна быть минимум одна буква
        if (!Character.isLetter(email.charAt(0))) throw new EmailValidateException("Should be letter before @");
        // После '@' должна быть минимум одна буква
        if (!Character.isLetter(email.charAt(indexAt + 1))) throw new EmailValidateException("Should be letter after @");
        // Проверка доменной части
        int dotAfterAt = email.lastIndexOf('.');
        if (dotAfterAt == -1 || dotAfterAt >= email.length() - 2) throw new EmailValidateException("Wrong domain name");
        // Проверка двух точек подряд
        if (email.contains("..")) throw new EmailValidateException("Two dots error");

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            //проверка на валидность символов
            boolean isPass = Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '.' || c == '_' || c == '@';
            if (!isPass) throw new EmailValidateException("Invalid symbols in address");
            //после последнего символа '.' должны идти только буквы
            if (i > dotAfterAt && !Character.isAlphabetic(c)) throw new EmailValidateException("Invalid symbols after dot");
        }
    }
}
