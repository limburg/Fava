package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Node die een variabele bevat waar een waarde wordt gezet d.m.v. een
 * expressie.
 * 
 * @author Joost Limburg
 * 
 */
public class AssignmentNode extends AbstractNode {
	// Variabele naam welke gezet wordt.
	private String variable;

	// De expressie welke de nieuwe waarde bepaalt van de variabele.
	private AbstractNode expression;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param varName
	 *            De variabele welke gezet moet worden.
	 * @param expression
	 *            De expressie waarmee de waarde bepaalt wordt.
	 */
	public AssignmentNode(AbstractScopeNode parent, String varName,
			AbstractNode expression) {
		super(parent);
		this.variable = varName;
		this.expression = expression;
	}

	/**
	 * @return the variable
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * @param variable
	 *            the variable to set
	 */
	public void setVariable(String variable) {
		this.variable = variable;
	}

	/**
	 * @return the expression
	 */
	public AbstractNode getExpression() {
		return expression;
	}

	/**
	 * @param expression
	 *            the expression to set
	 */
	public void setExpression(AbstractNode expression) {
		this.expression = expression;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
