package saxion.pti.ast;

import java.util.LinkedList;

import org.apache.log4j.Logger;

import saxion.pti.ast.nodes.AbstractNode;
import saxion.pti.ast.nodes.AssignmentNode;
import saxion.pti.ast.nodes.CallNode;
import saxion.pti.ast.nodes.CallVarNode;
import saxion.pti.ast.nodes.ExpressionNode;
import saxion.pti.ast.nodes.FunctionNode;
import saxion.pti.ast.nodes.IfNode;
import saxion.pti.ast.nodes.PrintNode;
import saxion.pti.ast.nodes.ProcedureNode;
import saxion.pti.ast.nodes.ProgramNode;
import saxion.pti.ast.nodes.StaticValueNode;
import saxion.pti.ast.nodes.VariableNode;
import saxion.pti.ast.nodes.WhileNode;

/**
 * Bezoekt de boom en print jasmin functies uit.
 * 
 * @author Joost Limburg.
 * 
 */
public class VisitTree {
	private static final Logger LOGGER = Logger.getLogger(VisitTree.class);

	private BuildTree tree = null;

	private LinkedList<String> jasminCode;

	public VisitTree(BuildTree buildTree) {
		this.tree = buildTree;
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
	private void addCode(String code) {
		LOGGER.info("Code: " + code);
		jasminCode.add(code);
	}

	/**
	 * WhileNode
	 * 
	 * @param whileNode
	 * @param statement
	 */
	public void visit(WhileNode whileNode) {
		// TODO

		System.out.println("While");

		// Bezoek statement
		if (whileNode.getStatement() != null)
			whileNode.getStatement().accept(this);

		// Bezoek variabelen
		for (VariableNode v : whileNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : whileNode.getCode())
			n.accept(this);
	}

	/**
	 * VariableNode
	 */
	public void visit(VariableNode varNode) {
		// TODO

		// Bezoek expressie
		varNode.getExpression().accept(this);
	}

	public void visit(StaticValueNode<?> statValueNode) {
		// TODO
		System.out.println("StatVar");
	}

	public void visit(AssignmentNode assignmentNode) {
		// TODO
		System.out.println("Assign");

	}

	public void visit(CallNode callNode) {
		// TODO
		System.out.println("Call");

	}

	public void visit(CallVarNode callVarNode) {
		// TODO
		System.out.println("CallVar");

	}

	public void visit(ExpressionNode expressionNode) {
		// TODO
		if (expressionNode.getValue() instanceof ExpressionNode) {
			// De expressie bevat een onderliggende expressie, bezoek deze
			expressionNode.getValue().accept(this);
		} else if (expressionNode.getValue() instanceof StaticValueNode<?>) {
			// De expressie is een static value, push het op de stack.
			StaticValueNode<?> statValue = (StaticValueNode<?>) expressionNode
					.getValue();
			if (statValue.getValue() instanceof String)
				addCode("  ldc \"" + statValue.getValue() + "\"");
			else
				addCode("  ldc " + statValue.getValue());

		}

		// Bezoek rechts van de expressie.
		if (expressionNode.getRight() != null) {
			expressionNode.getRight().accept(this);
		}
	}

	public void visit(FunctionNode functionNode) {
		// TODO
		String methodeDecl = ".method static " + functionNode.getName() + "(";

		for (VariableNode v : functionNode.getParameters()) {
			if (v.getType().equals(String.class)) {
				methodeDecl += "Ljava/lang/String;";
			} else {
				// Voor integer en boolean
				methodeDecl += "I";
			}
		}

		methodeDecl += ")I";
		addCode(methodeDecl);

		addCode("  .limit stack 16");
		addCode("  .limit locals " + functionNode.getVariables().size());

		// Bezoek variabelen
		for (VariableNode v : functionNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : functionNode.getCode())
			n.accept(this);

		if (functionNode.getReturnStatement() != null)
			functionNode.getReturnStatement().accept(this);

		addCode(".end method");
	}

	public void visit(IfNode ifNode) {
		// TODO
		System.out.println("If");

		// Bezoek statement
		if (ifNode.getStatement() != null)
			ifNode.getStatement().accept(this);

		// Bezoek variabelen
		for (VariableNode v : ifNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : ifNode.getCode())
			n.accept(this);
	}

	public void visit(PrintNode printNode) {
		// TODO
		System.out.println("Print");

	}

	public void visit(ProcedureNode procedureNode) {
		// TODO
		System.out.println("Proc");

		// Bezoek variabelen
		for (VariableNode v : procedureNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : procedureNode.getCode())
			n.accept(this);

	}

	public void visit(ProgramNode programNode) {
		// TODO

		addCode(".class public Test");
		addCode(".super java/lang/Object");
		addCode("");
		addCode(".method public static print(Ljava/lang/String;)V");
		addCode("  .limit locals 5");
		addCode("  .limit stack 5");
		addCode("  aload 0");
		addCode("   getstatic java/lang/System/out Ljava/io/PrintStream;");
		addCode("  swap");
		addCode("  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
		addCode("  return");
		addCode(".end method");

		// Bezoek globale vars
		for (VariableNode v : programNode.getVariables())
			v.accept(this);

		// Bezoek procs/funcs
		for (AbstractNode n : programNode.getChilds())
			n.accept(this);
	}
}
