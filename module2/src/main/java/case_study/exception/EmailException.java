package case_study.exception;

public class EmailException extends Exception {
    public EmailException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
