package ss.week5;

/**
 * Klasse die Speler uitbreidt om een ComputerSpeler toe te voegen.
 * @author FlorianF
 *
 */

public class ComputerPlayer extends Player {
	Strategy strategie;
    
	/**
     * Constructor voor een Speler object.
     * @require naam != null 
     *          mark == Bord.XX | Bord.OO
     * @ensure  this.getNaam() == naam
     *          this.getMark() == mark
     */

	public ComputerPlayer(Mark mark, Strategy strategie) {
		super(strategie.getName(), mark);
		this.strategie = strategie;
	}
	
	public ComputerPlayer(Mark mark) {
		super(new NaiveStrategy().getName(), mark);
		strategie = new NaiveStrategy();
	}
	/**
	 * Opvragen strategie
	 * @return this.strategie
	 */
	public Strategy getStrategie() {
		return strategie;
	}
	/**
	 * Verander de strategie
	 * @param strategie
	 */
	public void setStrategie(Strategy strategie) {
		this.strategie = strategie;
	}
	/**
	 * Bepaal de zet van de speler/computer
     * @require bord != null && s != null)
     * @ensure  bord.isVakje(result) && bord.isLeegVakje(result)
     * @param   bord het spelersbord
     * @return  keuze van het vakje van deze Speler
     */

	@Override
	public int determineMove(Board bord) {
		return strategie.determineMove(bord, getMark());
	}
}
