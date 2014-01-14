package ss.week5;
/**
 * Domme Strategie klasse
 * @author FlorianF
 *
 */
public class NaiveStrategy implements Strategy {
	
	private final String NAAM = "Domme";
	
	public String getName() {
		return NAAM;
	}

	public int determineMove(Board b, Mark m) {
		boolean[] leeg = new boolean[Board.DIM*Board.DIM];
		int i,random;
		for (i=0; i<(Board.DIM*Board.DIM); i++) {
			leeg[i] = b.isEmptyField(i);
		}
		random = 0 + (int)(Math.random() * ((Board.DIM*Board.DIM))); 
		while (!leeg[random]) {
			random = 0 + (int)(Math.random() * ((Board.DIM*Board.DIM)));
		}
		return random;
	}
}
