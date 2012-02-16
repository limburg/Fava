package saxion.pti.ast.nodes;

/**
 * Nodes die gebruik maken van de labelgenerator implementeren deze interface.
 * 
 * @author Joost Limburg
 * 
 */
public interface IStackNode {
	/**
	 * Het gegenereerde unieke labelnummer
	 * 
	 * @return uniek nummer in de scope/over het programma
	 */
	public Integer getStackNumber();

	/**
	 * Zet de gegenereerde labelnummer
	 * 
	 * @param stackNumber
	 *            Nummer
	 */
	public void setStackNumber(Integer stackNumber);
}
