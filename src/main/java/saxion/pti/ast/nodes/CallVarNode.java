package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class CallVarNode extends AbstractNode {

	private String name;

	private Integer arrayNum = null;

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
