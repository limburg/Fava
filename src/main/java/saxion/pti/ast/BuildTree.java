package saxion.pti.ast;

import java.util.Iterator;
import java.util.LinkedList;

import saxion.pti.ast.nodes.AbstractNodeWithVars;
import saxion.pti.ast.nodes.Node;
import saxion.pti.ast.nodes.VariableNode;
import saxion.pti.ast.nodes.scope.ProcedureNode;
import saxion.pti.ast.nodes.scope.ProgramNode;
import saxion.pti.ast.nodes.statement.AssignmentNode;
import saxion.pti.ast.nodes.statement.ExpressionNode;
import saxion.pti.ast.types.Factor;
import saxion.pti.ast.types.Type;

/**
 * Helper met alle javacode. Maakt het debuggen van toegevoegde
 * javafunctionaliteit aan CUP overzichtelijker en houdt de CUP bestanden
 * schoon.
 * 
 * @author Joost Limburg
 * 
 */
public class BuildTree extends AbstractBuildTree {
	public BuildTree() {

	}

	/**
	 * Vult de huidige node met variabele declaraties. Kan alleen bij Program en
	 * Procedure parent nodes.
	 * 
	 * @param t_id
	 * @param id_l
	 * @throws Exception
	 */
	public void addVariableDeclarations(Type<?> t_id, LinkedList<String> id_l)
			throws Exception {

		VariableNode n;
		Iterator<String> li = id_l.iterator();
		while (li.hasNext()) {
			n = new VariableNode(t_id, (li.next()));
			((AbstractNodeWithVars) getCurrentNode()).addDeclaration(n);
			debugMsg("Added variableDeclaration (" + n.getName() + ")");
		}

	}

	/**
	 * Creert een nieuwe node en voegt deze toe aan de parentNode. Kan alleen
	 * bij Program en Procedure parent nodes.
	 * 
	 * @param p_id
	 * @return
	 * @throws Exception
	 */
	public ProcedureNode createNewProcedure(String p_id, LinkedList<Node> params)
			throws Exception {

		debugMsg("Procedure Heading: " + p_id);

		ProcedureNode newProcNode = new ProcedureNode(p_id, getCurrentNode());
		((ProgramNode) getCurrentNode()).addProcedure(newProcNode);

		for (Node v : params) {
			debugMsg("Adding param " + ((VariableNode) v).getName());
			newProcNode.addParameter(((VariableNode) v));
		}

		return newProcNode;
	}

	/**
	 * Creert een assignment node en geeft deze terug.
	 * 
	 * @param variable
	 * @return
	 * @throws Exception
	 */
	public AssignmentNode createAssignment(String variable, ExpressionNode eNode) throws Exception {
		AssignmentNode assignmentNode = null;

		debugMsg("Assignment Statement");
		if (!((AbstractNodeWithVars) getCurrentNode()).hasDeclaration(variable)) {
			throw new Exception("Variable " + variable
					+ " not declared at this position.");
		} else {
			assignmentNode = new AssignmentNode(getCurrentNode(),
					((AbstractNodeWithVars) getCurrentNode())
							.getDeclaration(variable),eNode
					);
		}

		return assignmentNode;
	}

	/**
	 * Geeft een lijst met factoren terug.
	 * 
	 * @param e
	 *            Eerste factor
	 * @param o
	 *            Tweede factor
	 * @param t
	 *            Subfactoren
	 * @return lijst met factoren
	 */
	public LinkedList<Factor<?>> createFactorList(Factor<?> e, Factor<?> o,
			LinkedList<Factor<?>> t) {
		LinkedList<Factor<?>> newList = new LinkedList<Factor<?>>();

		if (e != null)
			newList.add(e);

		if (o != null)
			newList.add(o);

		if (t != null)
			newList.addAll(t);
		return newList;
	}
}
