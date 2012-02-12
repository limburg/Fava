package saxion.pti.ast;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import saxion.pti.ast.nodes.AbstractNode;
import saxion.pti.ast.nodes.AbstractParamNode;
import saxion.pti.ast.nodes.AssignmentNode;
import saxion.pti.ast.nodes.CallNode;
import saxion.pti.ast.nodes.CallVarNode;
import saxion.pti.ast.nodes.ExpressionNode;
import saxion.pti.ast.nodes.FunctionNode;
import saxion.pti.ast.nodes.IStackNode;
import saxion.pti.ast.nodes.IfNode;
import saxion.pti.ast.nodes.PrintNode;
import saxion.pti.ast.nodes.ProcedureNode;
import saxion.pti.ast.nodes.ProgramNode;
import saxion.pti.ast.nodes.StaticValueNode;
import saxion.pti.ast.nodes.VariableNode;
import saxion.pti.ast.nodes.WhileNode;

/**
 * Behelst standaard functies voor de visitTree. Zodat de visitTree
 * overzichtelijk blijft.
 * 
 * @author Joost Limburg
 * 
 */
public abstract class AbstractVisitTree {
	// Logger
	private static final Logger LOGGER = Logger.getLogger(VisitTree.class);

	// Programma naam
	private String programName = "";

	// AST
	private BuildTree tree = null;

	// Code voor Jasmin
	private LinkedList<String> jasminCode;

	/**
	 * Default Constructo.
	 * 
	 * @param buildTree
	 *            De AST die geparsed is met flex/cup.
	 * @param programName
	 *            De naam van het programma.
	 */
	public AbstractVisitTree(BuildTree buildTree, String programName) {
		this.tree = buildTree;
		this.setProgramName(programName);
		jasminCode = new LinkedList<String>();

	}

	/**
	 * Start het bezoeken.
	 */
	public void start() {
		LOGGER.info("Started translating");
		tree.getRootNode().accept(this);
		LOGGER.info("Finished translating");
	}

	/**
	 * Voeg code toe
	 */
	protected void addCode(String code) {
		// TODO: Temp uitgecomment: LOGGER.info("Code: " + code);
		System.out.println(code);
		jasminCode.add(code);
	}

	/**
	 * Functie die code genereert met stack items als while/if's
	 * 
	 * @param code
	 */
	protected void executeStackCode(LinkedList<AbstractNode> code) {
		Integer stackCount = 0;
		for (AbstractNode n : code) {
			// Als het gaat om een if of while, increase de stack voor de
			// labelnamen.
			if (n instanceof IStackNode) {
				((IStackNode) n).setStackNumber(stackCount);
				stackCount++;
			}
			n.accept(this);
		}
	}

	/**
	 * Bezoek de variabelen en geef ze een stacknummer
	 * 
	 * @param variables
	 */
	protected void visitVariableNodes(LinkedList<VariableNode> variables) {
		Integer stackCount = 0;
		for (VariableNode v : variables) {
			v.setStackNumber(stackCount);
			stackCount++;
			v.accept(this);
		}
	}

	/**
	 * Voegt code toe voor een procedure of function.
	 * 
	 * @param node
	 */
	protected void programBlock(AbstractParamNode node) {
		// TODO
		String methodeDecl = ".method private " + node.getName() + "(";
		Integer stack = 0;

		// Main is public, de rest private
		if (node.getName().equals("main")) {
			methodeDecl = ".method public main(";
		}

		// Parameters
		for (VariableNode v : node.getParameters()) {
			v.setStackNumber(stack);
			stack++;

			// Kijk of het om array gaat.
			if (v.isArray())
				methodeDecl += "[";

			// Zet de type
			if (v.getType().equals(String.class)) {
				methodeDecl += "Ljava/lang/String;";
			} else {
				// Voor integer en boolean
				methodeDecl += "I";
			}
		}

		// Return type
		if (node instanceof FunctionNode) {
			methodeDecl += ")";
			if (((FunctionNode) node).getReturnType().isArray())
				methodeDecl += "[";

			if (((FunctionNode) node).getReturnType().equals(String.class)) {
				methodeDecl += "Ljava/lang/String;";
			} else {
				methodeDecl += "I";
			}
		} else {
			methodeDecl += ")V";
		}

		// Voeg declaratie code toe
		addCode(methodeDecl);
		addCode("  .limit stack 16");
		addCode("  .limit locals "
				+ (1 + node.getVariables().size() + node.getParameters().size()));

		// Bezoek variabelen
		visitVariableNodes(node.getVariables());

		// Bezoek code
		executeStackCode(node.getCode());

		// Return statement, als we die hebben:
		if (node instanceof FunctionNode) {
			if (((FunctionNode) node).getReturnStatement() != null) {
				((FunctionNode) node).getReturnStatement().accept(this);
			}
		}

		// Einde methode
		addCode("  return");
		addCode(".end method");
		addCode("");
	}

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param programName
	 *            the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * Abstracte accept methodes
	 */

	/**
	 * Bezoek een program node
	 * 
	 * @param programNode
	 */
	public abstract void visit(ProgramNode programNode);

	/**
	 * Bezoek een assignment node
	 * 
	 * @param assignmentNode
	 */
	public abstract void visit(AssignmentNode assignmentNode);

	/**
	 * Bezoek een call node
	 * 
	 * @param callNode
	 */
	public abstract void visit(CallNode callNode);

	/**
	 * Bezoek een CallVariabele node
	 * 
	 * @param callVarNode
	 */
	public abstract void visit(CallVarNode callVarNode);

	/**
	 * Bezoek een expressie node
	 * 
	 * @param expressionNode
	 */
	public abstract void visit(ExpressionNode expressionNode);

	/**
	 * Bezoek een function node
	 * 
	 * @param functionNode
	 */
	public abstract void visit(FunctionNode functionNode);

	/**
	 * Bezoek een visit node
	 * 
	 * @param ifNode
	 */
	public abstract void visit(IfNode ifNode);

	/**
	 * Bezoek een print node
	 * 
	 * @param printNode
	 */
	public abstract void visit(PrintNode printNode);

	/**
	 * Bezoek een procedure node
	 * 
	 * @param procedureNode
	 */
	public abstract void visit(ProcedureNode procedureNode);

	/**
	 * Bezoek een static value node
	 * 
	 * @param staticValueNode
	 */
	public abstract void visit(StaticValueNode<?> staticValueNode);

	/**
	 * Bezoek een variable node
	 * 
	 * @param variableNode
	 */
	public abstract void visit(VariableNode variableNode);

	/**
	 * Bezoek een while node
	 * 
	 * @param whileNode
	 */
	public abstract void visit(WhileNode whileNode);

}
