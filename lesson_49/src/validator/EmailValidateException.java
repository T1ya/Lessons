package validator;

//extends Exceptions для проверяемых исключений
    //extends RuntimeExceptions для непроверяемых исключений
public class EmailValidateException extends Exception{
    /*
    getMessage() - выводит короткое сообщение об исключении
    getCause() - возвращает причину исключения
    toString() - строковое представление исключения
    printStringTrace() - выводит трассировку исключения
     */

    public EmailValidateException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Email validate exception " + super.getMessage();
    }
}
