package saxion.pti.ast.nodes;

public class StaticValueNode<T>  extends AbstractNode {
	private T value;
	
	public StaticValueNode(T value)
	{
		super();
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
}
