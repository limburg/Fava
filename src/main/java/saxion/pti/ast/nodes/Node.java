package saxion.pti.ast.nodes;

import saxion.pti.ast.types.Type;

/**
 * Abstract class voor alle nodes.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class Node {
	private Type<?> type;

	private Node parentNode;
	
	/**
	 * Constructor
	 */
	public Node(Node parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * @return the type
	 */
	public Type<?> getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Type<?> type) {
		this.type = type;
	}
	
	public Node getParentNode()
	{
		return parentNode;
	}
}
