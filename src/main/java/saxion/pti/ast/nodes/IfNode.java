package saxion.pti.ast.nodes;

public class IfNode extends AbstractParamNode {
	private ExpressionNode statement;
	
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

}
