package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class WhileNode extends AbstractParamNode implements IStackNode {
	private ExpressionNode statement;

	private Integer stackNumber = null;

	public WhileNode(AbstractScopeNode parent) {
		super(parent, "while", null);
	}
	
	public WhileNode(AbstractScopeNode parent, ExpressionNode statement) {
		super(parent, "while", null);
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
	public boolean isGlobal() {
		return stackNumber == null;
	}

	@Override
	public void setStackNumber(Integer stackNumber) {
		this.stackNumber = stackNumber;
	}
}
