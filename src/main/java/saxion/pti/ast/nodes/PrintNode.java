package saxion.pti.ast.nodes;

public class PrintNode extends AbstractNode {
	private ExpressionNode expression;

	public PrintNode(ExpressionNode expression) {
		this.expression = expression;
	}

	/**
	 * @return the expression
	 */
	public ExpressionNode getExpression() {
		return expression;
	}

	/**
	 * @param expression
	 *            the expression to set
	 */
	public void setExpression(ExpressionNode expression) {
		this.expression = expression;
	}
}
