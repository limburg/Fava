package saxion.pti.ast.nodes;

import saxion.pti.ast.VisitTree;

public class WhileNode extends AbstractParamNode {
	private ExpressionNode statement;

	public WhileNode(ExpressionNode statement) {
		super("while", null);
	}

	/**
	 * @return the statement
	 */
	public ExpressionNode getStatement() {
		return statement;
	}

	/**
	 * @param statement
	 *            the statement to set
	 */
	public void setStatement(ExpressionNode statement) {
		this.statement = statement;
	}

	@Override
	public void accept(VisitTree tree) {
		tree.visit(this);
	}

}
