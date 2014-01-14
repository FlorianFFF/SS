package ss.week5;
/**
 * Strategie interface
 * @author FlorianF
 *
 */
public interface Strategy {
	/**
	 * Geeft de naam van de strategie terug.
	 * @return String naam
	 */
	public String getName();
	/**
	 * Bepaal de zet van de bijbehorende strategie
	 * @param b het bord waarop de keuze wordt gemaakt
	 * @param m het kruisje of rondje van de kant van de strategie
	 * @return index voor het bord
	 */
	public int determineMove(Board b, Mark m);
}
