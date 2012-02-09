package saxion.pti.ast;

import java.util.LinkedList;

import saxion.pti.ast.nodes.AbstractNode;
import saxion.pti.ast.nodes.VariableNode;
import saxion.pti.generated.sym;

/**
 * Omhelst standaard functies om een simpel en overzichtelijke AST te creeren.
 * 
 * @author Joost Limburg
 * 
 */
public class BuildTree extends AbstractBuildTree {
	/**
	 * Creert een variabele node
	 * 
	 * @param type
	 * @param name
	 * @param e
	 * @return
	 */
	private VariableNode<?> createVariableNode(Integer type, String name,
			AbstractNode e) {
		VariableNode<?> newVariable = null;

		if (type == sym.SYM_INT) {
			newVariable = new VariableNode<Integer>(name);
		} else if (type == sym.SYM_STRING) {
			newVariable = new VariableNode<String>(name);
		} else if (type == sym.SYM_BOOLEAN) {
			newVariable = new VariableNode<Boolean>(name);
		} else {
			new Exception("unknown type for variable " + name);
		}

		newVariable.setExpression(e);

		return newVariable;

	}

	/**
	 * Voegt een regel toe aan de huidige AbstractScopeNode op de stack.
	 * 
	 * @param rule De regel die toegevoegd wordt.
	 */
	public void addCode(AbstractNode line)
	{
		getCurrentNode().addCode(line);
	}
	
	/**
	 * Voegt een lijst met variabelen toe aan de huidge AbstractScopeNode op de
	 * stack.
	 * 
	 * @param type
	 * @param n
	 * @param e
	 * @throws Exception
	 */
	public void addVariables(Integer type, LinkedList<String> n, AbstractNode e)
			throws Exception {
		// Voeg iedere var afzonderlijk toe:
		for (String name : n) {
			debugMsg("Adding variable: " + name);
			// Check of var al toegevoegd is:
			if (!getCurrentNode().hasVariable(name)) {
				getCurrentNode().addVariable(createVariableNode(type, name, e));
			} else {
				throw new Exception("duplicate variable defined: " + name);
			}
		}
	}

	/**
	 * Maakt een parameter variabelnode aan.
	 * 
	 * @param t
	 * @param param
	 * @return
	 */
	public VariableNode<?> createParameter(Integer t, String param) {
		return createVariableNode(t, param, null);
	}
}
