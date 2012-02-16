package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

public class ProgramNode extends AbstractScopeNode {
	public ProgramNode() {
		super(null);
	}

	public AbstractParamNode getProcOrFunc(String name) {
		for (AbstractNode procFunc : getChilds()) {
			if (procFunc instanceof AbstractParamNode
					&& ((AbstractParamNode) procFunc).getName().equals(name)) {
				return (AbstractParamNode) procFunc;
			}

		}

		return null;
	}

	public boolean hasProcOrFunc(String name) {
		return getProcOrFunc(name) != null;
	}

	@Override
	public void accept(AbstractVisitTree abstractVisitTree) {
		abstractVisitTree.visit(this);
	}

}
