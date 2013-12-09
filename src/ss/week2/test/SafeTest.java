package ss.week2.test;
import ss.week2.hotel.*;

/** 
 * Testprogramma voor Safe en Wachtwoord.
 * @author Florian
 * @version $Revision: 1.0 $
 */

public class SafeTest {
    /** Number of errors. */
    private int errors;
    /** Notice belonging to test method. */
    private boolean isPrinted;
    /** Indication that an errors was found in test method. */
    private String description;
	
	/** Testvariabele voor een <tt>Safe</tt>-object. */
	public Safe kluis1;
	
	/** Testvariabele voor een <tt>Safe</tt>-object. */
	public Safe kluis2;
	
	
    public int runTest() {
        setUp();
        testActivatie();
		testOpen();
		testSluit();
		testDeactivate();
		testOpenDeactivated();

        return errors;
	}
    
    
    public void setUp() {
    	kluis1 = new Safe();
    	kluis2 = new Safe();    	
    }
    
    public void testActivatie() {
		beginTest("Methode isActive");
		assertEquals("kluis.isActive() init",false,kluis1.isActive());
		kluis1.activate(kluis1.getPassword().getPassword());
		assertEquals("kluis.activate(kluis1.getPassword().getPassword())", null, null);
		assertEquals("kluis.isActive() 2",true,kluis1.isActive());
		kluis1.activate("ww222");
		assertEquals("kluis.activate(ww222)", null, null);
		assertEquals("kluis.isActive() 3",true,kluis1.isActive());
    }
    
    public void testWachtwoord() {
		beginTest("Methode isOpen");
    	kluis1.open(kluis1.getPassword().getPassword());
    	kluis2.open("BEGIN2WOORD");
    	assertEquals("kluis1.isOpen()",true,kluis1.isOpen());
    	assertEquals("kluis2.isOpen()",false,kluis2.isOpen());
    	kluis1.close();
    	assertEquals("kluis1.isOpen()",false,kluis1.isOpen());
    }
	
		public void testOpen(){
		beginTest("Methode open");
		assertEquals("kluis1.Open()",false,kluis1.isOpen());
		kluis1.open("wachtw1");
		assertEquals("kluis1.open(wachtw1)", null, null);
		assertEquals("kluis1.isOpen()",false,kluis1.isOpen());
		kluis1.open(kluis1.getPassword().getPassword());
		assertEquals("kluis1.open(wachtw2)", null, null);
		assertEquals("kluis1.isOpen()",true,kluis1.isOpen());
	}
	
	public void testSluit(){
		beginTest("Methode closeen");
		assertEquals("kluis1.isOpen()",true,kluis1.isOpen());
		kluis1.close();
		assertEquals("kluis1.close()", null, null);
		assertEquals("kluis1.isOpen()",false,kluis1.isOpen());
	}
	
	public void testDeactivate(){
		beginTest("Methode deactiveren");
		assertEquals("kluis1.isActive()",true,kluis1.isActive());
		kluis1.deactivate();
		assertEquals("kluis1.deactivate()", null,null );
		assertEquals("kluis1.isActive()",false,kluis1.isActive());
	}
	
	public void testOpenDeactivated(){
		beginTest("Methode open als gedeactivated");
		assertEquals("kluis1.isActive()",false,kluis1.isActive());
		assertEquals("kluis1.isOpen()",false,kluis1.isOpen());
		kluis1.open("wachtw1");
		assertEquals("kluis1.open(wachtw1)",null,null);
		assertEquals("kluis1.isOpen()",false,kluis1.isOpen());
	}
	
	/**
     * Fixes the status for the testmethod's description.
     * @param text The description to be printed
     */
    private void beginTest(String text) {
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
    private void assertEquals(String text, Object expected, Object result) {
        boolean equal;
        // tests equality between expected and result
        // accounting for null
        if (expected == null) {
            equal = result == null;
        } else {
            equal = result != null && expected.equals(result);
        }
        if (!equal) {
            // prints the description if necessary
            if (!isPrinted) {
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
    
    public static void main(String[] args) {
		new SafeTest().runTest();
	}
}
