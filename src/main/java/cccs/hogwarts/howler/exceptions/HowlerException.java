package cccs.hogwarts.howler.exceptions;

public class HowlerException extends RuntimeException {
    public HowlerException(String message) {
        super(message);
    }

    public HowlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public HowlerException(Throwable cause) {
        super(cause);
    }

    public HowlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStrackTrace) {
        super(message, cause, enableSuppression, writableStrackTrace);
    }
}
