package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class AssignmentNode extends AbstractNode {
	private String variable;

	private AbstractNode expression;

	public AssignmentNode(AbstractScopeNode parent, String varName, AbstractNode expression) {
		super(parent);
		this.variable = varName;
		this.expression = expression;
	}

	/**
	 * @return the variable
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * @param variable
	 *            the variable to set
	 */
	public void setVariable(String variable) {
		this.variable = variable;
	}

	/**
	 * @return the expression
	 */
	public AbstractNode getExpression() {
		return expression;
	}

	/**
	 * @param expression
	 *            the expression to set
	 */
	public void setExpression(AbstractNode expression) {
		this.expression = expression;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
