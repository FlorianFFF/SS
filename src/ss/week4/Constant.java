package ss.week4;

public class Constant implements Function{
	private int constant;
	
	public Constant(int constant){
		this.constant = constant;
	}
	
	@Override
	public double apply(double value){
		return constant;
	}
	
	@Override
	public Function derivative(){
		return new Constant(0);
	}
	
	public String toString(){
		return "f(x) = " + constant;
	}
}
