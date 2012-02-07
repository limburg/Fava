package saxion.pti.ast.nodes.scope;

import java.util.LinkedList;

import saxion.pti.ast.nodes.AbstractNodeWithVars;
import saxion.pti.ast.nodes.INamedNode;
import saxion.pti.ast.nodes.VariableNode;

/**
 * Root node van de AST
 * @author Joost Limburg
 *
 */
public class ProgramNode extends AbstractNodeWithVars implements INamedNode {
	// Bevat globale variabelen.
	private LinkedList<VariableNode> variableScope = new LinkedList<VariableNode>();
	
	// Bekende procedures.
	private LinkedList<ProcedureNode> procedureNodes = new LinkedList<ProcedureNode>();

	/**
	 * Constructor.
	 * 
	 * @param parentNode
	 *            Node mag alleen van type ProgramNode zijn, functies/procedures
	 *            in procedures/functies is niet toegestaan.
	 */
	public ProgramNode() {
		super(null);
	}

	public void addDeclaration(VariableNode newDeclaration) throws Exception {
		if (hasDeclaration(newDeclaration.getName())) {
			throw new Exception("Declaration " + newDeclaration.getName()
					+ " already defined in global scope.");
		} else {
			variableScope.add(newDeclaration);
		}
	}

	public boolean hasDeclaration(String declerationName) {
		return (getDeclaration(declerationName) != null);
	}

	/**
	 * Voeg procedures toe
	 * 
	 * @param newProcedure
	 * @throws Exception
	 *             Wordt gegooit als de procedure al bestaat.
	 */
	public void addProcedure(ProcedureNode newProcedure) throws Exception {
		if (hasProcedure(newProcedure)) {
			throw new Exception("Procedure " + newProcedure.getName()
					+ " already defined.");
		} else {
			procedureNodes.add(newProcedure);
		}
	}

	/**
	 * Checkt of de procedure al bestaat
	 * 
	 * @param newDeclaration
	 * @return
	 */
	public boolean hasProcedure(ProcedureNode newProcedure) {
		for (ProcedureNode v : procedureNodes)
			if (v.getName().equals(newProcedure.getName()))
				return true;
		return false;
	}

	public VariableNode getDeclaration(String declerationName) {
		for (VariableNode v : variableScope) {
			if (v.getName().equals(declerationName))
				return v;
		}
		return null;
	}

	@Override
	public String getName() {
		return "<root>";
	}
}
