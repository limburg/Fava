package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.nodes.scope.ProgramNode;


/**
 * Interface die aangeeft dat de node een variablescope heeft.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractNodeWithVars extends Node {
	public AbstractNodeWithVars(Node parentNode) {
		super(parentNode);
	}

	// Bevat locale variabelen.
	private LinkedList<VariableNode> variableScope = new LinkedList<VariableNode>();
	
	/**
	 * Voegt een declaratie toe aan de scope.
	 * 
	 * @param newDeclaration
	 * @throws Exception Als de locale of globale scope deze declaratie al heeft, gooi een exception. 
	 */
	public void addDeclaration(VariableNode newDeclaration) throws Exception {
		if (hasDeclaration(newDeclaration.getName())) {
			throw new Exception("Declaration " + newDeclaration.getName()
					+ " already defined in local scope.");
		} else {
			// Finally:
			variableScope.add(newDeclaration);
		}
	}
	
	/**
	 * Kijkt of de declaratie in de locale scope zit.
	 * @param newDeclaration
	 * @return
	 */
	public boolean hasDeclaration(String declerationName) {

		// Zit de declaratie in onze local declerations:
		if (getDeclaration(declerationName) != null)
			return true;

		// Zo niet, check de parent of hij het heeft:
		if (getParentNode() != null)
			return ((ProgramNode) getParentNode()).hasDeclaration(declerationName);
		else
			return false;
	}
	
	/**
	 * Haalt het declaratieobject met opgegeven naam op.
	 * @param declerationname
	 * @return
	 */
	public VariableNode getDeclaration(String declerationName) {
		for (VariableNode v : variableScope) {
			if (v.getName().equals(declerationName))
				return v;
		}
		return null;
	}
}
