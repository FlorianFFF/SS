package ss.week4;

public class IntShizzle{
	public static int numNegElements(int[] elements){
		int negElements = 0;
		
		for(int value : elements){
			if(value < 0) negElements++;
		}
		
		return negElements;
	}
}
