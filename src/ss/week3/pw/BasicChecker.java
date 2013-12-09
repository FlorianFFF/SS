package ss.week3.pw;

public class BasicChecker implements Checker {
	
	/**
	* @ensure dat voorstel voldoet aan de eisen voor een wachtwoord.
	*/
	public boolean acceptable(String voorstel) {
		return(!voorstel.contains(" ") && (voorstel.length() >= 6));
	}
	
	public String generatePass() {
		return "wachtwoord1";
	}	
}