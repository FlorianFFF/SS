package ss.week3.test;

import ss.week3.hotel.Bill;

public class BillTest{
	
	public Bill rekening;
	/** Number of errors. */
	private int errors;
	/** Notice belonging to test method. */
	private boolean isPrinted;
	/** Indication that an errors was found in test method. */
	private String description;
	
	public int runTest(){
		setUp();
		testBegintoestand();
		addItems();
		
		if(errors == 0){
			System.out.println("    OK");
		}
		return errors;
	}
	
	public void setUp(){
		rekening = new Bill(System.out);
	}
	
	public void testBegintoestand(){
		beginTest("Begintoestand");
		assertEquals("rekening.()", rekening.getSum(), 0.0);
	}
	
	
	public void addItems(){
		beginTest("Testen van 2 Items die aan rekening toegevoegd worden: ");
		rekening.newItem(new Bill.Item(){
			public String toString(){
				return String.format("heel duur: %1.2f \n", getPrice());
			}
			
			@Override
			public double getPrice(){
				// TODO Auto-generated method stub
				return 58329.12;
			}
		});
		assertEquals("rekening.getTotaal()", "58329.12", rekening.getSum());
		
		rekening.newItem(new Bill.Item(){
			public String toString(){
				return String.format("niet duur: %1.2f \n", getPrice());
			}
			
			@Override
			public double getPrice(){
				return 0;
			}
		});
		assertEquals("rekening.getTotaal()", "58324.65", rekening.getSum());
		
	}
	
	/**
	 * Fixes the status for the testmethod's description.
	 * 
	 * @param text
	 *            The description to be printed
	 */
	private void beginTest(String text){
		description = text;
		// the description hasn't been printed yet
		isPrinted = false;
	}
	
	/**
	 * Tests if the resulting value of a tested expression equals the
	 * expected (correct) value. This implementation prints both values,
	 * with an indication of what was tested, to the standard output. The
	 * implementation does not actually do the comparison.
	 */
	private void assertEquals(String text, Object expected, Object result){
		boolean equal;
		// tests equality between expected and result
		// accounting for null
		if(expected == null){
			equal = result == null;
		}else{
			equal = result != null && expected.equals(result);
		}
		if(!equal){
			// prints the description if necessary
			if(!isPrinted){
				System.out.println("    Test: " + description);
				// now the description is printed
				isPrinted = true;
			}
			System.out.println("        " + text);
			System.out.println("            Expected:  " + expected);
			System.out.println("            Result: " + result);
			errors++;
		}
	}
	
	public static void main(String[] args){
		new BillTest().runTest();
	}
}
