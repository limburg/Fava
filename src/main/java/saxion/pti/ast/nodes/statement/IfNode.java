package saxion.pti.ast.nodes.statement;

import saxion.pti.ast.nodes.AbstractNodeWithVars;
import saxion.pti.ast.nodes.Node;

/**
 * If statement node, welke zijn eigen local variables heeft.
 * 
 * @author Joost Limburg
 * 
 */
public class IfNode extends AbstractNodeWithVars {

	public IfNode(Node parentNode) {
		super(parentNode);
	}

}
