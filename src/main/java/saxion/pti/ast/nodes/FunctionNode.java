package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

public class FunctionNode  extends AbstractParamNode {
	private Class<?> returnType;
	
	public FunctionNode(String name, Class<?> returnType , LinkedList<VariableNode> parameters) {
		super(name, parameters);
		this.setReturnType(returnType);
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}

	/**
	 * @return the returnType
	 */
	public Class<?> getReturnType() {
		return returnType;
	}

	/**
	 * @param returnType the returnType to set
	 */
	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}
}
