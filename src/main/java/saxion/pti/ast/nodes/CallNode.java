package saxion.pti.ast.nodes;

import java.util.LinkedList;

public class CallNode extends AbstractNode {
	private String name;

	private LinkedList<AbstractNode> parameters = new LinkedList<AbstractNode>();

	public CallNode(String name, LinkedList<AbstractNode> parameters) {
		this.setParameters(parameters);
		this.setName(name);
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
	public LinkedList<AbstractNode> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(LinkedList<AbstractNode> parameters) {
		this.parameters = parameters;
	}

}
