package bo.edu.ucb.sis213.uberk.util;

public class UberKException extends RuntimeException {
    public UberKException(String message) {
        super(message);
    }

    public UberKException(String message, Throwable cause) {
        super(message, cause);
    }
}
