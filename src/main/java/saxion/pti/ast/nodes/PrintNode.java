package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class PrintNode extends AbstractNode {
	private ExpressionNode expression;

	public PrintNode(AbstractScopeNode parent, ExpressionNode expression) {
		super(parent);
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
	
	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
