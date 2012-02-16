package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * While constructie.
 * 
 * @author Joost Limburg.
 * 
 */
public class WhileNode extends AbstractScopeNode implements IStackNode,
		IStatementNode {
	// Expressie waarmee getest wordt
	private ExpressionNode statement;

	// Uniek labelnummer.
	private Integer stackNumber = null;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 */
	public WhileNode(AbstractScopeNode parent) {
		super(parent);
	}

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param statement
	 *            De expressie waarop getest wordt
	 */
	public WhileNode(AbstractScopeNode parent, ExpressionNode statement) {
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
