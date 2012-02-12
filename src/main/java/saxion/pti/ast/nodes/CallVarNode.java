package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class CallVarNode extends AbstractNode {
	private String name;

	private Integer arrayNum = null;

	public CallVarNode(String name, Integer arrayNum) {
		this.setName(name);
		this.setArrayNum(arrayNum);
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
