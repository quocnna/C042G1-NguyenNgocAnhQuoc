package examination.exception;

public class NotFoundProductException extends Exception {
    public NotFoundProductException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
