package ss.week6;

public class TooFewArgumentsException extends Exception{
	private static final long serialVersionUID = 3443848876327473668L;
	
	public TooFewArgumentsException(String message){
		super(message);
	}
}
