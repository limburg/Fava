package saxion.pti.ast;

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
	private BuildTree tree = null;

	public VisitTree(BuildTree buildTree) {
		this.tree = buildTree;

	}

	/**
	 * Start het bezoeken.
	 */
	public void start() {
		tree.getRootNode().accept(this);
	}

	/**
	 * WhileNode
	 * 
	 * @param whileNode
	 * @param statement
	 */
	public void visit(WhileNode whileNode) {
		System.out.println("While");

		// Bezoek statement
		if (whileNode.getStatement() != null)
			whileNode.getStatement().accept(this);

		// Bezoek variabelen
		for (VariableNode<?> v : whileNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : whileNode.getCode())
			n.accept(this);
	}

	/**
	 * VariableNode
	 */
	public void visit(VariableNode<?> varNode) {
		System.out.println("Var");

		// Bezoek expressie
		varNode.getExpression().accept(this);
	}

	public void visit(StaticValueNode<?> statValueNode) {
		System.out.println("StatVar");
	}

	public void visit(AssignmentNode assignmentNode) {
		System.out.println("Assign");

	}

	public void visit(CallNode callNode) {
		System.out.println("Call");

	}

	public void visit(CallVarNode callVarNode) {
		System.out.println("CallVar");

	}

	public void visit(ExpressionNode expressionNode) {
		System.out.print("expr ");

		// Bezoek rechts van de expressie.
		if (expressionNode.getRight() != null) {
			expressionNode.getRight().accept(this);
		} else {
			System.out.println("");
		}

	}

	public void visit(FunctionNode functionNode) {
		System.out.println("Func");

		// Bezoek variabelen
		for (VariableNode<?> v : functionNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : functionNode.getCode())
			n.accept(this);

		if (functionNode.getReturnStatement() != null)
			functionNode.getReturnStatement().accept(this);
	}

	public void visit(IfNode ifNode) {
		System.out.println("If");

		// Bezoek statement
		if (ifNode.getStatement() != null)
			ifNode.getStatement().accept(this);

		// Bezoek variabelen
		for (VariableNode<?> v : ifNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : ifNode.getCode())
			n.accept(this);
	}

	public void visit(PrintNode printNode) {
		System.out.println("Print");

	}

	public void visit(ProcedureNode procedureNode) {
		System.out.println("Proc");

		// Bezoek variabelen
		for (VariableNode<?> v : procedureNode.getVariables())
			v.accept(this);

		// Bezoek code
		for (AbstractNode n : procedureNode.getCode())
			n.accept(this);

	}

	public void visit(ProgramNode programNode) {
		System.out.println("Program");

		// Bezoek globale vars
		for (VariableNode<?> v : programNode.getVariables())
			v.accept(this);

		// Bezoek procs/funcs
		for (AbstractNode n : programNode.getChilds())
			n.accept(this);
	}
}
