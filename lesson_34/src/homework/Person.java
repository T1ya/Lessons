package homework;

public class Person {
    public String email;
    public String password;
    private static final String SYMBOLS = "\"!%$@&*()[],\"";
    private static final int PASS_MIN_LENGTH = 8;
    private static final int EMAIL_MIN_LENGTH = 6;

    public Person(String password, String email) {
        setPassword(password);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        }
    }

    private boolean isEmailValid(String email) {
        //проверка на длину email
        if (email == null || email.length() < EMAIL_MIN_LENGTH) return false;
        // Проверка '@'
        int indexAt = email.indexOf('@'); // Есть только один символ '@'
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) return false;
        // Перед '@' должна быть минимум одна буква
        if (!Character.isLetter(email.charAt(0))) return false;
        // После '@' должна быть минимум одна буква
        if (!Character.isLetter(email.charAt(indexAt + 1))) return false;
        // Проверка доменной части
        int dotAfterAt = email.lastIndexOf('.');
        if (dotAfterAt == -1 || dotAfterAt >= email.length() - 2) return false;
        // Проверка двух точек подряд
        if (email.contains("..")) return false;

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            //проверка на валидность символов
            boolean isPass = Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '.' || c == '_' || c == '@';
            if (!isPass) return false;
            //после последнего символа '.' должны идти только буквы
            if (i > dotAfterAt && !Character.isAlphabetic(c)) return false;
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (passwordIsValid(password)) this.password = password;
    }

    private boolean passwordIsValid(String password) {
        //проверка на длину пароля в 8 символов. И на null
        if (password == null || password.length() < PASS_MIN_LENGTH) {
            System.out.println("Oшибка - длина пароля должна быть больше 8 символов.");
            return false;
        }

        boolean hasDigit = false;//Должна быть мин 1 цифра
        boolean hasLowerCase = false;//Должна быть мин 1 маленькая буква -> Character.isLowerCase()
        boolean hasUpperCase = false;//Должна быть мин 1 большая буква
        boolean hasSymbol = false;//Должна быть мин 1 специальный символ: "!%$@&*()[],.-"

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isLowerCase(c)) hasLowerCase = true;
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (SYMBOLS.indexOf(c) != -1) hasSymbol = true; //символы я вынес в константу SYMBOLS
            //пароль валиден? нет смысла продолжать проверку
            if (hasDigit && hasLowerCase && hasUpperCase && hasSymbol) {
                return true;
            }
        }
        //добавим вывод для неверного пароля
        StringBuilder sb = new StringBuilder("Ошибка - пароль должен содержать как минимум");
        if (!hasDigit) sb.append(" одну цифру;");
        if (!hasLowerCase) sb.append(" одну строчную букву;");
        if (!hasUpperCase) sb.append(" одну заглавную букву;");
        if (!hasSymbol) sb.append(" один спецсимвол: ").append(SYMBOLS);
        sb.append(".");
        System.out.println(sb.toString());
        return false;
    }

    @Override
    public String toString() {
        return "Person{" + "email='" + email + '\'' + ", password='" + password + '\'' + '}';
    }
}