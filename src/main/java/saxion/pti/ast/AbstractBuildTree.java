package saxion.pti.ast;

import org.apache.log4j.Logger;

import saxion.pti.ast.nodes.AbstractParamNode;
import saxion.pti.ast.nodes.AbstractScopeNode;
import saxion.pti.ast.nodes.ElseNode;
import saxion.pti.ast.nodes.ProgramNode;

/**
 * Abstracte Boom Bouwer. Hierin staan standaard functies die we gebruiken, om
 * onze BuildTree class niet mee te bevuilen.
 * 
 * @author Joost Limburg.
 * 
 */
public abstract class AbstractBuildTree {
	// Logging
	static final Logger LOGGER = Logger.getLogger(BuildTree.class);

	// Root node
	protected ProgramNode rootNode;

	// Huidige node.
	protected AbstractScopeNode currentNode;

	// Current diepte in de tree
	private int depth = 0;

	// Max depth, voor info, verder geen toegevoegde waarde.
	private int maxDepth = 0;

	// Debug switch
	private boolean debug = true;

	/**
	 * Abstracte tree voor het bouwen van de AST.
	 */
	public AbstractBuildTree() {
		rootNode = new ProgramNode();
		currentNode = rootNode;
	}

	/**
	 * Weergeven van debug informatie
	 * 
	 * @param debugMessage
	 *            de debug informatie
	 */
	public void debugMsg(String debugMessage) {
		if (isDebug()) {
			// Mooi weergeven:
			String spaces = "";
			for (int i = 0; i < depth; i++) {
				spaces += "\t";
			}

			// Gebruik maken van de standaard logging facility:
			LOGGER.info(spaces + debugMessage);
		}
	}

	/**
	 * Geeft de rootNode terug.
	 */
	public ProgramNode getRootNode()
	{
		return rootNode;
	}
	
	/**
	 * Veranderd de huidige node naar de meegegeven node. De huidige node wordt
	 * automatisch parent van de meegegeven node en vice versa.
	 * 
	 * @param node
	 *            Nieuwe node.
	 */
	public void pushNode(AbstractScopeNode node) {
		if (node instanceof AbstractParamNode)
			debugMsg("--> Push to func/param ("
					+ ((AbstractParamNode) node).getName() + ")");
		else
			debugMsg("--> Push to " + node.getClass().getSimpleName());

		depth++;

		// Voeg parents/childs:
		node.setParent(currentNode);
		currentNode.addChild(node);

		// Voeg toe aan parent code-block als het niet de programnode is
		if (!( currentNode instanceof ProgramNode) && ! (currentNode instanceof ElseNode))
			currentNode.addCode(node);
		
		// Vervang huidige node:
		currentNode = node;

		// Maximale diepte bepalen
		if (depth > maxDepth)
			maxDepth = depth;
	}

	/**
	 * De huidige node wordt vervangen door de parent van de node.
	 */
	public void popNode() {
		if (currentNode.getParent() != null) {
			depth--;

			if (currentNode instanceof AbstractParamNode)
				debugMsg("<-- Pop from node ("
						+ ((AbstractParamNode) currentNode).getName() + ")");
			else
				debugMsg("<-- Pop from "
						+ currentNode.getClass().getSimpleName());

			currentNode = (AbstractScopeNode) currentNode.getParent();

		}
	}

	/**
	 * Geeft de huidige node terug.
	 * 
	 * @return huidige node.
	 */
	public AbstractScopeNode getCurrentNode() {
		return currentNode;
	}

	/**
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * @param debug
	 *            the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Maximale diepte in de boom.
	 * 
	 * @return maximale diepte.
	 */
	public int getMaxDepth() {
		// TODO Auto-generated method stub
		return maxDepth;
	}
}
