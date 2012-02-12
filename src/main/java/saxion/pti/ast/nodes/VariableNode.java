package saxion.pti.ast.nodes;

import saxion.pti.ast.VisitTree;

/**
 * Bij het aanmaken van een variabele wordt deze -eind- node aangemaakt.
 * 
 * @author Joost Limburg
 * 
 * @param <T>
 *            Type variabele (String, int, bool..)
 */
public class VariableNode extends AbstractNode {
	// Generic opslaan
	private Class<?> type = null;

	private String name = "";

	private Integer arraySize = null;

	private ExpressionNode expression;

	public VariableNode(String name, Class<?> type, Integer arraySize) {
		this.setName(name);
		this.type = type;

		if (arraySize != null)
			this.arraySize = arraySize;
	}

	/**
	 * Geef de generic terug
	 */
	public Class<?> getType() {
		return type;
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
	 * @return the expression
	 */
	public ExpressionNode getExpression() {
		return expression;
	}

	/**
	 * @param expression
	 *            the expression to set
	 */
	public void setExpression(ExpressionNode expression) {
		this.expression = expression;
	}

	/**
	 * @return the arraySize
	 */
	public int getArraySize() {
		return arraySize;
	}

	/**
	 * @param arraySize
	 *            the arraySize to set
	 */
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public boolean isArray() {
		return arraySize != null;
	}

	@Override
	public void accept(VisitTree tree) {
		tree.visit(this);
	}
}
