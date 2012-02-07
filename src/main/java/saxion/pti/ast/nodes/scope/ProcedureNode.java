package saxion.pti.ast.nodes.scope;

import java.util.LinkedList;

import saxion.pti.ast.nodes.AbstractNodeWithVars;
import saxion.pti.ast.nodes.INamedNode;
import saxion.pti.ast.nodes.Node;
import saxion.pti.ast.nodes.VariableNode;

/**
 * Sub-node welke procedures omvat.
 * 
 * @author Joost Limburg
 * 
 */
public class ProcedureNode extends AbstractNodeWithVars implements INamedNode {
	// Naam van de procedure
	private String name;

	// Bevat parameters, gesorteerd op wanneer is toegevoegd
	private LinkedList<VariableNode> parameters = new LinkedList<VariableNode>();

	/**
	 * Constructor.
	 * 
	 * @param parentNode
	 *            Node mag alleen van type ProgramNode zijn, functies/procedures
	 *            in procedures/functies is niet toegestaan.
	 * @throws Exception
	 *             Gooit een exceptie als de procedure niet in het
	 *             programmablock is gedifinieert.
	 */
	public ProcedureNode(String name, Node parentNode) throws Exception {
		super(parentNode);
		if (parentNode instanceof ProgramNode) {
			this.name = name;
		} else {
			throw new Exception(
					"Procedure declared at wrong stage of the program.");
		}

	}

	/**
	 * Voegt een parameter toe aan de procedure.
	 * 
	 * @param newDeclaration
	 * @throws Exception
	 *             Gooit een exception als de parameter al voorkomt in de stack.
	 */
	public void addParameter(VariableNode newParameter) throws Exception {
		if (hasParameter(newParameter)) {
			throw new Exception("Declaration " + newParameter.getName()
					+ " already defined in procedure parameters.");
		} else {
			parameters.add(newParameter);
		}
	}

	/**
	 * Checkt of de parameter al bestaat.
	 * 
	 * @param newParameter
	 * @return
	 */
	public boolean hasParameter(VariableNode newParameter) {
		for (VariableNode v : parameters)
			if (v.getName().equals(newParameter.getName()))
				return true;
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

}
