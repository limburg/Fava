package saxion.pti.ast;

import org.apache.log4j.Logger;

import saxion.pti.ast.nodes.AbstractScopeNode;
import saxion.pti.ast.nodes.ProgramNode;

public abstract class AbstractBuildTree {
	// Logging
	static final Logger LOGGER = Logger.getLogger(BuildTree.class);

	protected ProgramNode rootNode;

	protected AbstractScopeNode currentNode;

	// Current diepte in de tree
	private int depth = 0;

	// Debug switch
	private boolean debug = true;

	public AbstractBuildTree() {
		rootNode = new ProgramNode();
		currentNode = rootNode;
	}

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

	public void pushNode(AbstractScopeNode node) {
		depth++;
		currentNode = node;
	}

	public void popNode() {
		if (currentNode.getParent() != null) {
			depth--;
			currentNode = (AbstractScopeNode) currentNode.getParent();
		}
	}

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

}
