package ss.week3.hotel;

import java.io.PrintStream;
import java.util.ArrayList;

public class Bill {
	private PrintStream outStream;
	private boolean output;
	private ArrayList<Bill.Item> items;
	
	public Bill(PrintStream outStream) {
		if(outStream!=null){
			output=true;
			this.outStream = outStream;
			this.outStream.flush();
		}
	}

	public void close() {
		if(output){
			outStream.append(String.format("totaal: %1.2f \n", getSum()));
		}
	}

	public double getSum() {
		double totaal = 0;
		for (int i=0; i < items.size(); i++) {
			totaal = totaal + items.get(i).getPrice();
		}
		return totaal;
	}

	public void newItem(Item item) {
		items.add(item);
		if(output){
			outStream.append(item.toString()+"\n");
		}
	}

	public interface Item {
		public double getPrice();
		public String toString();
	}
}