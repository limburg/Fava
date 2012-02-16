package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Een aanroep van een variabele in een expressie.
 * 
 * @author Joost Limburg
 * 
 */
public class CallVarNode extends AbstractNode {
	// Variabele naam waarvan de waarde opgehaald moet worden.
	private String name;

	// Array nummer in de variabele.
	private Integer arrayNum = null;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param name
	 *            Naam van de variabele
	 * @param arrayNum
	 *            Nummer in de array, als het een array is.
	 * @throws Exception
	 */
	public CallVarNode(AbstractScopeNode parent, String name, Integer arrayNum)
			throws Exception {
		super(parent);
		this.setName(name);
		this.setArrayNum(arrayNum);

		// Variabele bestaat (nog) niet, dus dat mag niet!
		if (!getParent().hasVariable(name)) {
			throw new Exception("Variable " + name
					+ " not yet declared when called.");
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}

	/**
	 * Is array?
	 */
	public boolean isArrayAssignment() {
		return arrayNum != null;
	}

	/**
	 * @return the arrayNum
	 */
	public Integer getArrayNum() {
		return arrayNum;
	}

	/**
	 * @param arrayNum
	 *            the arrayNum to set
	 */
	public void setArrayNum(Integer arrayNum) {
		this.arrayNum = arrayNum;
	}
}
