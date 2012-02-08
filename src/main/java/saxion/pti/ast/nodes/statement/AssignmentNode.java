package saxion.pti.ast.nodes.statement;

import saxion.pti.ast.nodes.Node;
import saxion.pti.ast.nodes.VariableNode;

public class AssignmentNode extends Node{
	private VariableNode variableNode;
	
	private ExpressionNode expressionNode;
	
	public AssignmentNode(Node parentNode, VariableNode variableNode, ExpressionNode expressionNode) {
		super(parentNode);
		this.variableNode = variableNode;
		this.expressionNode = expressionNode;
	}

	/**
	 * @return the variableNode
	 */
	public VariableNode getVariableNode() {
		return variableNode;
	}

	/**
	 * @return the expressionNode
	 */
	public ExpressionNode getExpressionNode() {
		return expressionNode;
	}
}
