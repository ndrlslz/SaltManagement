package service.http;

public class PaaSResponseException extends RuntimeException {


	private static final long serialVersionUID = 6296410361119384984L;

	protected String message;

	protected int status;

	public PaaSResponseException(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

}
