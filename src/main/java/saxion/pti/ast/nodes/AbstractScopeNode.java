package saxion.pti.ast.nodes;

import java.util.LinkedList;

/**
 * Abstracte node welke code en variabelen kan bevatten.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractScopeNode extends AbstractNode {
	// Lokale variabelen (of als het ProgramNode is: globale).
	protected LinkedList<VariableNode> variables = new LinkedList<VariableNode>();

	// Lokale programmeerregels in de scope.
	protected LinkedList<AbstractNode> code = new LinkedList<AbstractNode>();

	// Return statement (optional)
	protected ExpressionNode returnStatement;

	public AbstractScopeNode(AbstractScopeNode parent) {
		super(parent);
	}

	public LinkedList<AbstractNode> getCode() {
		return code;
	}

	public LinkedList<VariableNode> getVariables() {
		return variables;
	}

	public void addVariable(VariableNode variable) {
		variables.add(variable);
	}

	public void addCode(AbstractNode line) {
		code.add(line);
	}

	public boolean hasVariable(String name) {
		// Check variablen
		for (VariableNode var : variables) {
			if (var.getName().equalsIgnoreCase(name))
				return true;
		}

		if (getParent() != null)
			return ((AbstractScopeNode) getParent()).hasVariable(name);
		else
			return false;
	}

	public VariableNode getVariable(String name) {
		for (VariableNode var : variables) {
			if (var.getName().equals(name)) {
				return var;
			}
		}

		if (getParent() != null) {
			return ((AbstractScopeNode) getParent()).getVariable(name);
		} else {
			return null;
		}
	}

	public ExpressionNode getReturnStatement() {

		return returnStatement;
	}

	public void setReturnStatement(ExpressionNode expr) {
		this.returnStatement = expr;

	}
}
