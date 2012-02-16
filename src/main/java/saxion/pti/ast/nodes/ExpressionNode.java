package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class ExpressionNode extends AbstractNode {
	private Class<?> type;

	private Integer symbol = null;

	private AbstractNode left;

	private AbstractNode right;

	private AbstractNode value;

	public ExpressionNode(AbstractScopeNode parent, AbstractNode value)
			throws Exception {
		super(parent);
		this.setValue(value);
		determineType();
	}

	public ExpressionNode(AbstractScopeNode parent, AbstractNode value,
			Integer symbol, ExpressionNode right) throws Exception {
		super(parent);
		this.setValue(value);

		this.symbol = symbol;
		this.right = right;

		if (right != null)
			right.setLeft(this);
		determineType();
	}

	/**
	 * Determineer het type (int, str, bool etc) van de expressie
	 * 
	 * @throws Exception
	 */
	private void determineType() throws Exception {
		// Determineer type van expressie.
		if (value instanceof StaticValueNode) {
			type = ((StaticValueNode<?>) value).getValue().getClass();
		} else if (value instanceof CallVarNode) {
			type = getParent().getVariable(((CallVarNode) value).getName())
					.getType();
		} else if (value instanceof CallNode) {
			// Moet worden bepaald in de visitor.
		} else if (value instanceof ExpressionNode) {
			type = ((ExpressionNode) value).getType();
		} else {
			throw new Exception("invalid type of expression."
					+ value.getClass());
		}

		if (right != null && right instanceof ExpressionNode) {
			if (type != null
					&& !type.equals(((ExpressionNode) right).getType())) {
				throw new Exception(
						"incompatible assignment types in one expression("
								+ type + ", "
								+ ((ExpressionNode) right).getType() + ")");
			}

		}
	}

	/**
	 * @return the symbol
	 */
	public Integer getSymbol() {
		return symbol;
	}

	/**
	 * @param type
	 *            the symbol to set
	 */
	public void setSymbol(Integer symbol) {
		this.symbol = symbol;
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
	 * @param left
	 *            the left to set
	 */
	public void setLeft(AbstractNode left) {
		this.left = left;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}

	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Class<?> type) {
		this.type = type;
	}
}
