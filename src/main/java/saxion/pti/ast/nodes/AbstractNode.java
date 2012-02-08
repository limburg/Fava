package saxion.pti.ast.nodes;

import java.util.LinkedList;

/**
 * Abstract class voor alle nodes.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractNode {

	private AbstractNode parent;

	private LinkedList<AbstractNode> childs = new LinkedList<AbstractNode>();

	public AbstractNode() {

	}

	/**
	 * @return the childs
	 */
	public LinkedList<AbstractNode> getChilds() {
		return childs;
	}

	/**
	 * Add childs
	 */
	public void addChild(AbstractNode child) {
		this.childs.add(child);
	}

	/**
	 * @return the parent
	 */
	public AbstractNode getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(AbstractNode parent) {
		this.parent = parent;
	}
}
