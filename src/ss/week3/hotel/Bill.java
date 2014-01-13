package ss.week3.hotel;

import java.io.PrintStream;

public class Bill{
	private PrintStream outStream;
	private float sum;
	
	//@ requires outStream != null;
	public Bill(PrintStream outStream){
		this.outStream = outStream;
		this.outStream.flush();
	}
	
	public void close(){
		ss.week3.Format.printLine(outStream, "total:", getSum());
//		outStream.append(String.format("totaal: %1.2f \n", getSum()));
	}
	
	public float getSum(){
		return sum;
	}
	
	public void newItem(Item item){
		sum += item.getPrice();
		
		ss.week3.Format.printLine(outStream, item.toString(), item.getPrice());
//		outStream.append(item.toString() + "\n");
	}
	
	public interface Item{
		public double getPrice();
		
		public String toString();
	}
}