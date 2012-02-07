package saxion.pti.ast.nodes.statement;

import saxion.pti.ast.nodes.Node;
import saxion.pti.ast.nodes.VariableNode;

public class AssignmentNode extends Node{
	private VariableNode variableNode;
	
	public AssignmentNode(VariableNode variableNode, Node parentNode) {
		super(parentNode);
	}

	/**
	 * @return the variableNode
	 */
	public VariableNode getVariableNode() {
		return variableNode;
	}
}
