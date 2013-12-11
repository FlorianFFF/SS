package ss.week4;

public class Polynomial implements Function{
	private int parts[];
	
	public Polynomial(int... parts){
		this.parts = parts;
	}
	
	@Override
	public int apply(int value){
		int result = 0;
		
		for(int i = 0; i < parts.length; i++){
			result += parts[i] * Math.pow(value, parts.length - i - 1);
		}
		
		return result;
	}
	
	@Override
	public Function derivative(){
		int[] newParts = new int[parts.length - 1];
		
		for(int i = 0; i < newParts.length; i++){
			newParts[i] = parts[i] * (newParts.length - i);
		}
		
		if(newParts.length == 0) return new Constant(0);
		if(newParts.length == 1) return new Constant(newParts[0]);
		
		return new Polynomial(newParts);
	}
	
	@Override
	public String toString(){
		String result = "f(x) = ";
		
		for(int i = 0; i < parts.length; i++){
			if(i == parts.length - 1) result += parts[i];
			else if(i == parts.length - 2) result += parts[i] + "x";
			else result += parts[i] + "x^" + (parts.length - i - 1);
			
			if(i != parts.length - 1) result += " + ";
		}
		
		return result;
	}
	
	public static void main(String[] args){
		Polynomial polynomial = new Polynomial(7, 6, 6, 2);
		System.out.println(polynomial);
		System.out.println(polynomial.apply(2));
		
		Function derivative = polynomial.derivative();
		System.out.println(derivative);
	}
}
