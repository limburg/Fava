package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class IfNode extends AbstractScopeNode implements IStackNode,
		IStatementNode {
	private ExpressionNode statement;

	private Integer stackNumber = null;

	public IfNode(AbstractScopeNode parent) {
		super(parent);
	}

	public IfNode(AbstractScopeNode parent, ExpressionNode statement) {
		super(parent);
		this.statement = statement;
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
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}

	@Override
	public Integer getStackNumber() {
		return stackNumber;
	}

	@Override
	public void setStackNumber(Integer stackNumber) {
		this.stackNumber = stackNumber;
	}
}
