package mx.ihsa.fluent;

public class CalculoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public CalculoException() {
		super();
	}

	public CalculoException(String message) {
		super(message);
	}

	public CalculoException(Throwable cause) {
		super(cause);
	}

	public CalculoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
