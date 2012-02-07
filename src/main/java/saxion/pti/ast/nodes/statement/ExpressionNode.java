package saxion.pti.ast.nodes.statement;

import java.util.LinkedList;

import saxion.pti.ast.nodes.Node;

public class ExpressionNode extends Node {
	LinkedList<Node> statementList = new LinkedList<Node>();

	public ExpressionNode(Node parentNode) {
		super(parentNode);
	}

	public void addStatement(Node statement) {
		statementList.add(statement);
	}
}
