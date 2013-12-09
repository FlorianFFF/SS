package ss.week4;

public class Polynomial implements Function{
	private int parts[];
	
	public Polynomial(int parts[]){
		this.parts = parts;
	}
	
	@Override
	public int apply(int value){
		// TODO Auto-generated method stub
		return 0;
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
		Polynomial polynomial = new Polynomial(new int[]{1, 6, 3, 4, 11});
		System.out.println(polynomial);
	}
}
