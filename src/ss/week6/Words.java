package ss.week6;

import java.util.Scanner;

public class Words{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String input = null;
		
		while(true){
			input = getInputLine(scanner);
			if("end".equals(input)) break;
			else printWords(input);
		}
		
		System.out.println("End of programme");
	}
	
	private static void printWords(String input){
		String[] words = input.split(" ");
		
		for(int i = 0; i < words.length; i++){
			System.out.printf("Word %d: %s\n", i, words[i]);
		}
	}
	
	private static String getInputLine(Scanner scanner){
		String next = scanner.nextLine();
		System.out.printf("Line (or \"end\"): %s\n", next);
		return next;
	}
}
