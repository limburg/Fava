package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Print functie node
 * 
 * @author Joost Limburg
 * 
 */
public class PrintNode extends AbstractNode {
	// De expressie die geprint moet worden
	private ExpressionNode expression;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param expression
	 *            De expressie die geprint moet wordena
	 */
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
