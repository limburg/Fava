package saxion.pti.ast.nodes;

import saxion.pti.ast.VisitTree;

/**
 * Bij het aanmaken van een variabele wordt deze -eind- node aangemaakt.
 * @author Joost Limburg
 *
 * @param <T> Type variabele (String, int, bool..)
 */
public class VariableNode<T> extends AbstractNode{
	private String name = "";
	
	private int arraySize = 0;
	
	private ExpressionNode expression;
	
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
	public ExpressionNode getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
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
	 * @param arraySize the arraySize to set
	 */
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public boolean isArray()
	{
		return arraySize > 0;
	}

	@Override
	public void accept(VisitTree tree) {
		tree.visit(this);
	}
}
