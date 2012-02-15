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

	private LinkedList<VariableNode> parameters = new LinkedList<VariableNode>();

	public AbstractParamNode(AbstractScopeNode parent, String name,
			LinkedList<VariableNode> parameters) {
		super(parent);
		this.name = name;

		if (parameters != null)
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

	public boolean hasVariable(String name) {
		// Check parameters
		for (VariableNode var : parameters) {
			if (var.getName().equalsIgnoreCase(name))
				return true;
		}

		return super.hasVariable(name);
	}

	/**
	 * Get variabele
	 */
	public VariableNode getVariable(String name) {
		// Check parameters
		for (VariableNode var : parameters) {
			if (var.getName().equalsIgnoreCase(name))
				return var;
		}

		return super.getVariable(name);
	}

	/**
	 * @return the parameters
	 */
	public LinkedList<VariableNode> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(LinkedList<VariableNode> parameters) {
		this.parameters = parameters;
	}

}
