package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Statische waarde (nummer,string, etc).
 * 
 * @author Joost
 * 
 * @param <T>
 *            De type van de waarde (generic)
 */
public class StaticValueNode<T> extends AbstractNode {
	// De value van de node.
	private T value;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param value
	 *            De waarde
	 */
	public StaticValueNode(AbstractScopeNode parent, T value) {
		super(parent);
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
