package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

public class ProcedureNode extends AbstractParamNode {

	public ProcedureNode(AbstractScopeNode parent, String name, LinkedList<VariableNode> parameters) {
		super(parent, name, parameters);
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
