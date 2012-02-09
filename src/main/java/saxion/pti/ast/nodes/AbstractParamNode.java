package saxion.pti.ast.nodes;

import java.util.LinkedList;

/**
 * Abstract class voor nodes met parameters.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractParamNode extends AbstractScopeNode {
	// Func/Proc naam
	private String name;

	private LinkedList<VariableNode<?>> parameters;

	public AbstractParamNode(String name, LinkedList<VariableNode<?>> parameters) {
		this.name = name;
		this.parameters = parameters;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the parameters
	 */
	public LinkedList<VariableNode<?>> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(LinkedList<VariableNode<?>> parameters) {
		this.parameters = parameters;
	}

}
