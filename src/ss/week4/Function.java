package ss.week4;

public interface Function {
	public int apply(int value);
	public Function derivative(Function function);
	public String toString();
	
}
