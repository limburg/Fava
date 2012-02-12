package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class IfNode extends AbstractParamNode implements IStackNode{
	private ExpressionNode statement;
	
	private Integer stackNumber = null;
	
	public IfNode(ExpressionNode statement) {
		super("if/else", null);
	}

	/**
	 * @return the statement
	 */
	public ExpressionNode getStatement() {
		return statement;
	}

	/**
	 * @param statement the statement to set
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
