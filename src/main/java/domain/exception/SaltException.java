package domain.exception;

public class SaltException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String reason;
    private String message;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SaltException() {
    }

    public SaltException(String message) {
        super(message);
        this.message = message;
    }

    public SaltException(Integer code, String reason, String message) {
        super(message);
        this.code = code;
        this.reason = reason;
        this.message = message;
    }

    public SaltException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

    public SaltException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    @Override
    public String toString(){
        return "{code: "+code+", reason: \""+reason+"\", message: \""+message+"\"}";
    }
}

