package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.AbstractVisitTree;

public class CallNode extends AbstractNode {
	private String name;

	private LinkedList<ExpressionNode> parameters = new LinkedList<ExpressionNode>();

	public CallNode(String name, LinkedList<ExpressionNode> parameters) {
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
