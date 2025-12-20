package utility;

public class CustomCheckedException extends Exception {
// for checked exception at compile time such as IOException, SQLException 
	public CustomCheckedException() {
		super();
		
	}
	
    public CustomCheckedException(String message) {
		super(message);
	}

    public CustomCheckedException(String message,Throwable cause) {
		super(message);
	}
}
