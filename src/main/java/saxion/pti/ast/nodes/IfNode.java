package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * If constructie
 * @author Joost Limburg
 *
 */
public class IfNode extends AbstractScopeNode implements IStackNode,
		IStatementNode {
	// Expressie die getest moet worden
	private ExpressionNode statement;

	// Label generator nummer
	private Integer stackNumber = null;

	/**
	 * Constructor.
	 * 
	 * @param parent De parent.
	 */
	public IfNode(AbstractScopeNode parent) {
		super(parent);
	}

	/**
	 * Constructor.
	 * @param parent
	 * @param statement
	 */
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
