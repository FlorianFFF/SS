package ss.week4;

import java.util.Arrays;

public class IntShizzle{
	public static int numNegElements(int[] elements){
		int negElements = 0;
		
		for(int value : elements){
			if(value < 0) negElements++;
		}
		
		return negElements;
	}
	
	public static void reverseElements(int[] elements){
		for(int i = 0; i < elements.length / 2; i++){
			int temp = elements[i];
			int reverseIndex = elements.length - i - 1;
			elements[i] = elements[reverseIndex];
			elements[reverseIndex] = temp;
		}
	}
	
	public static void main(String[] args){
		int[] ints = new int[]{1, 3, 4, -4, 6, -6, -19};
		reverseElements(ints);
		
		System.out.println(Arrays.toString(ints));
	}
}
