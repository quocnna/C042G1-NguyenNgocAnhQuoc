package case_study.exception;

public class BirthdayException extends Exception {

    public BirthdayException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
