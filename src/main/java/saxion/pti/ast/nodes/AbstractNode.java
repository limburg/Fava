package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.VisitTree;

/**
 * Abstract class voor alle nodes.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractNode {
	protected boolean visited = false;

	private AbstractNode parent;

	private LinkedList<AbstractNode> childs = new LinkedList<AbstractNode>();

	public AbstractNode() {

	}

	/**
	 * Visitor voor prettyprinting Jasmin code
	 */
	public abstract void accept(VisitTree tree);

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

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}
}
