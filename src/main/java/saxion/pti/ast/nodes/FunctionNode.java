package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Functie declaratie
 * 
 * @author Joost Limburg
 * 
 */
public class FunctionNode extends AbstractParamNode {

	// Het result type
	private Class<?> returnType;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param name
	 *            De naam van de functie
	 * @param returnType
	 *            Het type welk de functie teruggeeft
	 * @param parameters
	 *            De parameters die de functie ontvangt.
	 */
	public FunctionNode(AbstractScopeNode parent, String name,
			Class<?> returnType, LinkedList<VariableNode> parameters) {
		super(parent, name, returnType, parameters);
		this.returnType = returnType;
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
	 * @param returnType
	 *            the returnType to set
	 */
	public void setReturnType(Class<?> returnType) {
		this.returnType = returnType;
	}
}
