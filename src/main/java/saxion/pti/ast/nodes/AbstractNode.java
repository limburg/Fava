package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Abstract class voor alle nodes.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractNode {
	// De parent
	private AbstractScopeNode parent;

	// De kids
	private LinkedList<AbstractScopeNode> childs = new LinkedList<AbstractScopeNode>();

	/**
	 * Constructor welke een parent accepteert. Iedere node heeft een parent,
	 * dus verplicht.
	 * 
	 * @param parent
	 */
	public AbstractNode(AbstractScopeNode parent) {
		this.parent = parent;
	}

	/**
	 * Visitor voor prettyprinting Jasmin code
	 */
	public abstract void accept(AbstractVisitTree abstractVisitTree);

	/**
	 * @return the childs
	 */
	public LinkedList<AbstractScopeNode> getChilds() {
		return childs;
	}

	/**
	 * Add childs
	 */
	public void addChild(AbstractScopeNode child) {
		this.childs.add(child);
	}

	/**
	 * @return the parent
	 */
	public AbstractScopeNode getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(AbstractScopeNode parent) {
		this.parent = parent;
	}
}
