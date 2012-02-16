package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

public class FunctionNode  extends AbstractParamNode {
	
	public FunctionNode(AbstractScopeNode parent, String name, Class<?> returnType , LinkedList<VariableNode> parameters) {
		super(parent, name, returnType, parameters);
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
