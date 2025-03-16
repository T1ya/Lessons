public class Person {
    public String email;
    public String password;
    private static final String SYMBOLS = "\"!%$@&*()[],.-\"";
    private static final int PASS_MIN_LENGTH = 8;

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
        //@ check
        int indexAt = email.indexOf('@');   //mail has @
        int lastAt = email.lastIndexOf('@');    //mail has only 1 @
        if (indexAt == -1 || indexAt != lastAt) return false;
        //@. check
        int dotAfterAt = email.indexOf('.', indexAt + 1);
        if (dotAfterAt == -1) return false;

        //after dot there is 2 or more symbols
        int lastDotIndex = email.indexOf('.');
        if (lastDotIndex >= email.length() - 2) return false;

        //special symbols check
        for (char c : email.toCharArray()) {
            boolean isPass = Character.isAlphabetic(c)
                    || Character.isDigit(c)
                    || c == '-'
                    || c == '.'
                    || c == '_'
                    || c == '@';
            if (!isPass) return false;
        }

        // before @ should be at least 1 symbol
        // 1-st symbol should be letter
        if (Character.isLetter(email.charAt(0))) return true;

        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (passwordIsValid(password)) this.password = password;
    }

    private boolean passwordIsValid(String password) {
        //проверка на длину пароля в 8 символов. И на null
        if (password == null || password.length() < PASS_MIN_LENGTH)
        {
            System.out.println("Oшибка - длина пароля должна быть больше 8 символов.");
            return false;
        }

        boolean hasDigit = false;//Должна быть мин 1 цифра
        boolean hasLowerCase = false;//Должна быть мин 1 маленькая буква -> Character.isLowerCase()
        boolean hasUpperCase = false;//Должна быть мин 1 большая буква
        boolean hasSymbol = false;//Должна быть мин 1 специальный символ: "!%$@&*()[],.-"

        for(char c: password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isLowerCase(c)) hasLowerCase = true;
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (SYMBOLS.indexOf(c) != -1) hasSymbol = true; //символы я вынес в константу SYMBOLS
           //пароль валиден? нет смысла продолжать проверку
           if (hasDigit && hasLowerCase && hasUpperCase && hasSymbol){
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
        return "Person{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
