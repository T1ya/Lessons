package persons;

import java.util.Calendar;

public class Person {
    public String email;
    public String password;

    public Person(String password, String email) {
        this.password = password;
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
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
