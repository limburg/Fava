package saxion.pti.ast.nodes;

/**
 * Bij het aanmaken van een variabele wordt deze -eind- node aangemaakt.
 * @author Joost Limburg
 *
 * @param <T> Type variabele (String, int, bool..)
 */
public class VariableNode<T> extends AbstractNode{
	private String name = "";
	
	private int arraySize = 0;
	
	private AbstractNode expression;
	
	public VariableNode(String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the expression
	 */
	public AbstractNode getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(AbstractNode expression) {
		this.expression = expression;
	}

	/**
	 * @return the arraySize
	 */
	public int getArraySize() {
		return arraySize;
	}

	/**
	 * @param arraySize the arraySize to set
	 */
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public boolean isArray()
	{
		return arraySize > 0;
	}
}
