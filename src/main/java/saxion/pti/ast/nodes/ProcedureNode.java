package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.VisitTree;

public class ProcedureNode  extends AbstractParamNode{

	public ProcedureNode(String name, LinkedList<VariableNode<?>> parameters) {
		super(name, parameters);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(VisitTree tree) {
		tree.visit(this);
	}
}
