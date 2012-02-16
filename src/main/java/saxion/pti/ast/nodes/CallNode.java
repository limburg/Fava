package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Node welk een functie/procedure aanroep behelst, met bijkomende parameters
 * van type expressie.
 * 
 * @author Joost Limburg
 * 
 */
public class CallNode extends AbstractNode {
	// Naam van de functie/procedure die aangeroepen wordt.
	private String name;

	// Meegegeven parameters (van type expressie)
	private LinkedList<ExpressionNode> parameters = new LinkedList<ExpressionNode>();

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            De parent
	 * @param name
	 *            De naam van de procedure/functie die aangeroepen wordt.
	 * @param parameters
	 *            De parameters die meegegeven zijn.
	 * @throws Exception
	 */
	public CallNode(AbstractScopeNode parent, String name,
			LinkedList<ExpressionNode> parameters) throws Exception {
		super(parent);
		this.setParameters(parameters);
		this.setName(name);
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
	 * @return the parameters
	 */
	public LinkedList<ExpressionNode> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	public void setParameters(LinkedList<ExpressionNode> parameters) {
		this.parameters = parameters;
	}

	@Override
	public void accept(AbstractVisitTree tree) {
		tree.visit(this);
	}
}
