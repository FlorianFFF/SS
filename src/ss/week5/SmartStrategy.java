package ss.week5;
/**
 * Slimme strategie klasse
 * @author FlorianF
 *
 */
public class SmartStrategy implements Strategy {
	
	public static final String NAAM = "Slimme";
	private Mark tegenstander, zelf;

	public String getName() {
		return NAAM;
	}

	public int determineMove(Board b, Mark m) {
		int zet = -1;
		zelf = m;
		tegenstander = m == Mark.XX ? Mark.OO : Mark.XX;
		
		//Probeer het middelste vakje uit.
		if (b.isEmptyField((int)(double)Board.DIM*Board.DIM/2) && zet == -1) {
			zet = (int)(double)Board.DIM*Board.DIM/2;
		}
		//Vind winnend vakje
		if (zet == -1) {
			for (int i=0; i<(Board.DIM*Board.DIM) && zet==-1; i++) {
				zet = (b.isEmptyField(i) && winnend(i,b)) ? i : -1;
			}
		}
		//Vind vakje waarmee tegenstander wint
		if (zet == -1) {
			for (int i=0; i<(Board.DIM*Board.DIM) && zet==-1; i++) {
				zet = (b.isEmptyField(i) && verstandig(i,b)) ? i : -1;
			}
		}
		//Geen van bovenstaande gevallen, random vakje
		if (zet == -1) {
			zet = (new NaiveStrategy()).determineMove(b, m);
		}
		return zet;
	}
	
	
	//Wint de tegenstander niet met dit vakje?
	private boolean verstandig(int zet, Board b) {
		boolean result = false;
		Board copy = b.deepCopy();
		copy.setField(zet, tegenstander);
		if (copy.isWinner(tegenstander)) {
			result = true;
		}
		return result;
	}
	//Wint de computer met dit vakje?
	private boolean winnend(int zet, Board b) {
		boolean result = false;
		Board copy = b.deepCopy();
		copy.setField(zet, zelf);
		if (copy.isWinner(zelf)) {
			result = true;
		}
		return result;
	}
	
}
