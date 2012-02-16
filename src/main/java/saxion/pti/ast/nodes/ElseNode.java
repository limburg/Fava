package saxion.pti.ast.nodes;

/**
 * Else aanroep. In feite (code technisch) gezien gelijk aan een ifnode
 * 
 * @author Joost Limburg
 * 
 */
public class ElseNode extends IfNode {
	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param statement
	 *            De test-expressie
	 */
	public ElseNode(AbstractScopeNode parent, ExpressionNode statement) {
		super(parent, statement);
	}

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 */
	public ElseNode(AbstractScopeNode parent) {
		super(parent, null);
	}
}
