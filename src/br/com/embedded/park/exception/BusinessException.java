package br.com.embedded.park.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;

	public BusinessException() {
    }

    public BusinessException(String arg0) {
        super(arg0);
    }
    public BusinessException(String msg, Throwable error) {
        super(msg, error);
    }
	
}
