package ss.week3;

import java.io.PrintStream;

public class Format{
	public static void printLine(PrintStream outStream, String text, double amount){
		outStream.printf("%s %15.2f\n", text, amount);
	}
}
