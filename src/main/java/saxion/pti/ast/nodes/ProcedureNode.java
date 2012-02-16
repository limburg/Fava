package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Procedure declaratie.
 * 
 * @author Joost Limburg
 * 
 */
public class ProcedureNode extends AbstractParamNode {
	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param name
	 *            De naam van de procedure
	 * @param parameters
	 *            De parameters die die procedure gebruikt
	 */
	public ProcedureNode(AbstractScopeNode parent, String name,
			LinkedList<VariableNode> parameters) {
		super(parent, name, null, parameters);
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
