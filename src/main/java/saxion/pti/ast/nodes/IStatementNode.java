package saxion.pti.ast.nodes;

/**
 * Nodes die gebruik maken van een statement (expressie vergelijking)
 * implementeren deze interface
 * 
 * @author Joost Limburg
 * 
 */
public interface IStatementNode {
	/**
	 * Geef de expressie terug die getest moet worden
	 * 
	 * @return de expressie.
	 */
	public ExpressionNode getStatement();
}
