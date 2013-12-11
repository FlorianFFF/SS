package ss.week4;

public class IntSet{
	private static final int NUM_ELEMENTS = 10;
	
	private boolean[] isIn;
	
	public IntSet(){
		isIn = new boolean[NUM_ELEMENTS];
	}
	
	public IntSet union(IntSet other){
		IntSet result = new IntSet();
		
		for(int i = 0; i < NUM_ELEMENTS; i++){
			if(hasInt(i) || other.hasInt(i)) result.addInt(i);
		}
		
		return result;
	}
	
	public void addInt(int value){
		if(value < 0) throw new IllegalArgumentException("out of bounds");
		if(value >= isIn.length) resize(value + 1);
		
		isIn[value] = true;
	}
	
	public void removeInt(int value){
		if(value < 0 || value >= isIn.length) throw new IllegalArgumentException("out of bounds");
		
		isIn[value] = false;
	}
	
	public boolean hasInt(int value){
		if(value < 0 || value >= isIn.length) throw new IllegalArgumentException("out of bounds");
		
		return isIn[value];
	}
	
	private void resize(int newSize){
		System.arraycopy(new boolean[newSize], 0, isIn, 0, isIn.length);
		
		isIn = new boolean[newSize];
	}
	
	public static void main(String[] args){
		IntSet intSet = new IntSet();
		intSet.addInt(15);
		
		System.out.println(intSet.hasInt(15));
	}
}
