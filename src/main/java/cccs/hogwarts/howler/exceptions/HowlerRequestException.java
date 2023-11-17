package cccs.hogwarts.howler.exceptions;

import org.apache.http.HttpStatus;

public class HowlerRequestException extends HowlerException {
    private final int statusCode;
    private final String reason;

    public HowlerRequestException(int statusCode, String reason) {
        super(String.format("Howler api request failed with status code %s. Response: %s.", statusCode,
                reason));

        this.statusCode = statusCode;
        this.reason = reason;
    }

    public boolean isBadRequest() {
        return HttpStatus.SC_BAD_REQUEST == this.statusCode;
    }

    public boolean isNotFound() {
        return HttpStatus.SC_NOT_FOUND == this.statusCode;
    }
}
