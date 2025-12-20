package utility;

public class CustomUnCheckedException extends RuntimeException {
	// for unchecked exception at compile time such as ArithMatic exception, ClasNotFound ,ArrayOutOfIndex
	public CustomUnCheckedException() {
		super();
		
	}
	
    public CustomUnCheckedException(String message) {
		super(message);
	}

    public CustomUnCheckedException(String message,Throwable cause) {
		super(message);
	}
}
