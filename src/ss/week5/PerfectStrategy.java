package ss.week5;

public class PerfectStrategy implements Strategy {
	public static final String NAAM = "Perfecte";
	private Mark tegenstander;
	private int iteratie = 0;

	public String getName() {
		return NAAM;
	}

	public int determineMove(Board b, Mark m) {
		int zet = -1;
		tegenstander = m == Mark.XX ? Mark.OO : Mark.XX;
		Board bcopy = b;
		iteratie++;
		for(int i=0; i<Board.DIM*Board.DIM && zet==-1; i++) {
			if (bcopy.isEmptyField(i)) {
				bcopy.setField(i, m); //probeer gewoon een vakje
				if (bcopy.isWinner(m)) { //toevallig daarmee gewonnen?
					zet = i; //klaar met bepaaldzet!
				} else { //simuleer verloop
					bcopy.setField(new SmartStrategy().determineMove(bcopy, tegenstander), tegenstander); //simuleer een slimme tegenzet
					if (!bcopy.isWinner(tegenstander)) {
						System.out.println(iteratie);
						zet = determineMove(bcopy,m);
					}
				}
			}
		}
		return zet;
	}
}
