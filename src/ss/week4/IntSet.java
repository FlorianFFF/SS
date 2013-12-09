package ss.week4;

public class IntSet{
	private static final int NUM_ELEMENTS = 1000;
	
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
		if(value < 0 || value >= NUM_ELEMENTS) throw new IllegalArgumentException("out of bounds");
		if(!isIn[value]) throw new IllegalArgumentException("already in set");
		
		isIn[value] = true;
	}
	
	public void removeInt(int value){
		if(value < 0 || value >= NUM_ELEMENTS) throw new IllegalArgumentException("out of bounds");
		
		isIn[value] = false;
	}
	
	public boolean hasInt(int value){
		if(value < 0 || value >= NUM_ELEMENTS) throw new IllegalArgumentException("out of bounds");
		
		return isIn[value];
	}
}
