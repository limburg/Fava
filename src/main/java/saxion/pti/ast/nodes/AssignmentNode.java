package saxion.pti.ast.nodes;

public class AssignmentNode extends AbstractNode {
	private String variable;
	
	private AbstractNode expression;
	
	public AssignmentNode(String varName, AbstractNode expression) {
		super();
	}

	/**
	 * @return the variable
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * @param variable the variable to set
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
	 * @param expression the expression to set
	 */
	public void setExpression(AbstractNode expression) {
		this.expression = expression;
	}

}
