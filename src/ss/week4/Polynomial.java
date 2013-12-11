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
	public Function derivative(Function function){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		String result = "f(x) = ";
		
		for(int i = parts.length - 1; i >= 0; i--){
			int factor = parts.length - i - 1;
			
			if(i == 0) result += parts[factor];
			else if(i == 1) result += parts[factor] + "x";
			else result += parts[factor] + "x^" + i;
			
			if(i != 0) result += " + ";
		}
		
		return result;
	}
	
	public static void main(String[] args){
		Polynomial polynomial = new Polynomial(1, 6, 3);
		System.out.println(polynomial);
		System.out.println(polynomial.apply(2));
	}
}
