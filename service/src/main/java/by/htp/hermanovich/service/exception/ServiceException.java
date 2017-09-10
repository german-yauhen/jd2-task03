package by.htp.hermanovich.service.exception;

/**
 * This class sends exception to web module
 * Created by Hermanovich Yauheni
 */
public class ServiceException extends Exception {

    /**
     * Constructs a new exception with the specified detail message. The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ServiceException(String message) {
        super(message);
    }

    /**
     * This method constructs a new exception with the specified detail message and cause.
     * Note that the detail message associated with {@code e} is not automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param e   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     */
    public ServiceException(String message, Throwable e) {
        super(message, e);
    }
}
