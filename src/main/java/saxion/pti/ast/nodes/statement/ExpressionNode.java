package saxion.pti.ast.nodes.statement;

import java.util.LinkedList;

import saxion.pti.ast.nodes.Node;
import saxion.pti.ast.types.Factor;

/**
 * Simpele expressie
 * 
 * @author Joost Limburg
 * 
 */
public class ExpressionNode extends Node {
	// Statements die bij deze expressie horen
	private LinkedList<Factor<?>> expressionList = new LinkedList<Factor<?>>();

	public ExpressionNode(Node parentNode, LinkedList<Factor<?>> expressionList) {
		super(parentNode);
		addStatements(expressionList);
	}

	public void addStatements(LinkedList<Factor<?>> expressionList) {
		expressionList.addAll(expressionList);
	}

	public void addStatement(Factor<?> expression) {
		expressionList.add(expression);
	}
}
