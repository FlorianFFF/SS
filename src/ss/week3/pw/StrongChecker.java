package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	
	/**
	* @ensure dat voorstel voldoet aan de eisen voor een wachtwoord.
	*/
	public boolean acceptable(String voorstel) {
		if (super.acceptable(voorstel)) {
			return streng(voorstel);			
		} else {
			return false;
		}
	}
	
	public boolean streng(String voorstel) {
		int lengte = voorstel.length();
		char firstchar = voorstel.charAt(0);
		char lastchar = voorstel.charAt(lengte-1);
		if (Character.isLetter(firstchar) && Character.isDigit(lastchar)) {
			return true;
		} else {
			return false;
		}
	}
}