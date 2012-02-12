package saxion.pti.ast;

import java.util.LinkedList;

import saxion.pti.ast.nodes.AbstractNode;
import saxion.pti.ast.nodes.ExpressionNode;
import saxion.pti.ast.nodes.FunctionNode;
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
	private VariableNode createVariableNode(Integer type, String name,
			ExpressionNode e, Integer arraySize) {
		VariableNode newVariable = null;

		if (type == sym.SYM_INT) {
			newVariable = new VariableNode(name, Integer.class, arraySize);
		} else if (type == sym.SYM_STRING) {
			newVariable = new VariableNode(name, String.class, arraySize);
		} else if (type == sym.SYM_BOOLEAN) {
			newVariable = new VariableNode(name, Boolean.class, arraySize);
		} else {
			new Exception("unknown type for variable " + name);
		}

		newVariable.setParent(getCurrentNode());
		newVariable.setExpression(e);

		return newVariable;

	}

	/**
	 * Voegt een regel toe aan de huidige AbstractScopeNode op de stack.
	 * 
	 * @param rule
	 *            De regel die toegevoegd wordt.
	 */
	public void addCode(AbstractNode line) {
		line.setParent(getCurrentNode());
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
	public void addVariables(Integer type, LinkedList<String> n,
			ExpressionNode e, Integer arraySize) throws Exception {
		// Voeg iedere var afzonderlijk toe:
		for (String name : n) {
			debugMsg("Adding variable: " + name);
			// Check of var al toegevoegd is:
			if (!getCurrentNode().hasVariable(name)) {
				getCurrentNode().addVariable(
						createVariableNode(type, name, e, arraySize));
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
	public VariableNode createParameter(Integer t, String param,
			Integer arraySize) {
		return createVariableNode(t, param, null, arraySize);
	}

	/**
	 * Voegt een return statement toe aan een function op de stack.
	 */
	public void addReturnStatement(ExpressionNode expr) {
		if (getCurrentNode() instanceof FunctionNode) {
			expr.setParent(getCurrentNode());
			getCurrentNode().setReturnStatement(expr);
		}
	}

	/**
	 * Creert een nieuwe functionNode.
	 * 
	 * @param id
	 * @param t
	 * @param params
	 * @return
	 */
	public FunctionNode createFunctionNode(String id, Integer t,
			LinkedList<VariableNode> params) {
		FunctionNode f = null;
		if (t == sym.SYM_INT) {
			f = new FunctionNode(id, Integer.class, params);
		} else if (t == sym.SYM_STRING) {
			f = new FunctionNode(id, String.class, params);
		} else if (t == sym.SYM_BOOLEAN) {
			f = new FunctionNode(id, Boolean.class, params);
		} else {
			new Exception("unknown returntype for function " + id);
		}

		f.setParent(getCurrentNode());
		return f;
	}
}
