package ss.week3.hotel;

import java.io.PrintStream;

public class Bill {
	private final PrintStream outStream;

	public Bill(PrintStream outStream) {
		this.outStream = outStream;
	}

	public void close() {
	}

	public double getSum() {
		return 0.0;
	}

	public void newItem(Item item) {
	}

	public interface Item {
	}
}