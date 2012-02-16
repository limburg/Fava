package saxion.pti.ast.nodes;

public class ElseNode extends IfNode {

	public ElseNode(AbstractScopeNode parent, ExpressionNode statement) {
		super(parent, statement);
	}

	public ElseNode(AbstractScopeNode parent) {
		super(parent, null);
	}
}
