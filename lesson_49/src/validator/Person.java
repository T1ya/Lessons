package validator;

public class Person {
    public String email;
    public String password;

    public Person(String password, String email) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password cannot be null");
        }
        setPassword(password);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try {
            PersonValidator.validateEmail(email);
            ConsoleUI.printSuccess("Email \"" + email + "\" has been checked successfully");
            this.email = email;
        } catch (EmailValidateException e) {
            ConsoleUI.printError("Email \"" + email + "\" has been denied (" + e.getMessage()+ ")");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            PersonValidator.validatePassword(password);
            ConsoleUI.printSuccess("Password checked successfully");
            this.password = password;
        }
        catch (PasswordValidateException e) {
            ConsoleUI.printError("Password has been denied (" + e.getMessage()+ ")");
        }
    }

    @Override
    public String toString() {
        return "Person{" + "email='" + email + '\'' + ", password='********'}";
    }
}