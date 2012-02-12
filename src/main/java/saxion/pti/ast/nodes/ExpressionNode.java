package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class ExpressionNode extends AbstractNode {

	private Integer type = null;

	private AbstractNode left;
	
	private AbstractNode right;

	private AbstractNode value;

	public ExpressionNode(AbstractNode value) {
		super();
		this.setValue(value);
	}
	
	public ExpressionNode(AbstractNode value, Integer type, AbstractNode right) {
		super();
		this.setValue(value);
		
		this.type = type;
		this.right = right;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the right
	 */
	public AbstractNode getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(AbstractNode right) {
		this.right = right;
	}

	/**
	 * @return the value
	 */
	public AbstractNode getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(AbstractNode value) {
		this.value = value;
	}

	/**
	 * @return the left
	 */
	public AbstractNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(AbstractNode left) {
		this.left = left;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
