package saxion.pti.ast;

import org.apache.log4j.Logger;

import saxion.pti.ast.nodes.INamedNode;
import saxion.pti.ast.nodes.Node;
import saxion.pti.ast.nodes.scope.ProgramNode;

/**
 * Abstracte class die de standaard functies behelst van de BuildTree. We willen
 * alleen de CUP functies zien in de BuildTree.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractBuildTree {
	// Logging
	static final Logger LOGGER = Logger.getLogger(BuildTree.class);

	// Root node
	private ProgramNode rootNode = new ProgramNode();

	// Current node:
	private Node currentNode = rootNode;

	// Current diepte in de tree
	private int depth = 0;

	// Debug switch
	private boolean debug = true;

	/**
	 * Teruggeven van de node waarin we zitten:
	 * 
	 * @return Node currentNode
	 */
	public Node getCurrentNode() {
		return currentNode;
	}

	/**
	 * PUSH de huidige context naar currentNode
	 * 
	 * @param currentNode
	 */
	public void pushNode(Node currentNode) {
		this.currentNode = currentNode;

		debugMsg("-> PUSH node (" + ((INamedNode) currentNode).getName() + ")");

		depth++;

	}

	/**
	 * POP de huidige node en zet de parent als context.
	 */
	public void popNode() {
		// niet verder dan de root node poppen.
		if (currentNode.getParentNode() != null && depth > 0) {
			depth--;

			debugMsg("<- POP node  (" + ((INamedNode) currentNode).getName()
					+ ")");
			this.currentNode = currentNode.getParentNode();
		}
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
	 * Geef debug messages door
	 * 
	 * @param debugMessage
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
	 * Geeft de root node terug. Handig voor het opzoeken van procedures &
	 * functions.
	 * 
	 * @return programNode De rootnode
	 */
	public ProgramNode getRootNode() {
		return rootNode;
	}
}
