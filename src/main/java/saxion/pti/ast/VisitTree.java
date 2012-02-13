package saxion.pti.ast;

import saxion.pti.ast.nodes.AbstractNode;
import saxion.pti.ast.nodes.AbstractScopeNode;
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
import saxion.pti.generated.sym;

/**
 * Bezoekt de boom en print jasmin functies uit.
 * 
 * @author Joost Limburg.
 * 
 */
public class VisitTree extends AbstractVisitTree {
	public VisitTree(BuildTree buildTree, String programName) {
		super(buildTree, programName);
	}

	/**
	 * WhileNode
	 * 
	 * @param whileNode
	 * @param statement
	 */
	public void visit(WhileNode whileNode) {
		addCode(" while" + whileNode.getStackNumber() + ":");

		// Bezoek statement
		if (whileNode.getStatement() != null) {
			whileNode.getStatement().accept(this);
		}
		// Bezoek variabelen
		visitVariableNodes(whileNode.getVariables());

		// Bezoek code
		executeStackCode(whileNode.getCode());
		addCode("  goto while" + whileNode.getStackNumber());
		addCode(" done" + whileNode.getStackNumber() + ":");
	}

	/**
	 * VariableNode
	 */
	public void visit(VariableNode varNode) {
		// TODO
		if (varNode.isGlobal()) {
			if (varNode.getType().equals(String.class)) {
				// TODO
			} else {
				// TODO
			}
		} else {
			if (varNode.getType().equals(String.class)) {
				varNode.getExpression().accept(this);
				addCode("  astore " + varNode.getStackNumber());
			} else {
				varNode.getExpression().accept(this);
				addCode("  istore " + varNode.getStackNumber());
			}
		}
	}

	public void visit(StaticValueNode<?> statValueNode) {
		if (statValueNode.getValue() instanceof String)
			addCode("  ldc \"" + statValueNode.getValue() + "\"");
		else if (statValueNode.getValue() instanceof Boolean)
			addCode("  ldc "
					+ (((Boolean) statValueNode.getValue()) == true ? 1 : 0));
		else
			addCode("  ldc " + statValueNode.getValue());
	}

	public void visit(AssignmentNode assignmentNode) {
		// TODO
		AbstractScopeNode scope = (AbstractScopeNode) assignmentNode
				.getParent();

		VariableNode varNode = scope.getVariable(assignmentNode.getVariable());

		if (varNode.isGlobal()) {
			if (varNode.getType().equals(String.class)) {
				// TODO
			} else {
				// TODO
			}
		} else {
			if (varNode.getType().equals(String.class)) {
				// TODO
				// addCode("  aload " + varNode.getStackNumber());
				assignmentNode.getExpression().accept(this);
				addCode("  astore " + varNode.getStackNumber());
			} else {
				// addCode("  iload " + varNode.getStackNumber());
				assignmentNode.getExpression().accept(this);
				addCode("  istore " + varNode.getStackNumber());
			}
		}

	}

	public void visit(CallNode callNode) {
		// Push stack
		addCode("  aload 0");

		// < voer hier values voor de params in >
		callNode.getParameters();
		String returnType = "";
		if (callNode.getParent() instanceof FunctionNode) {
			FunctionNode parent = (FunctionNode) callNode.getParent();

			if (parent.getReturnType().equals("String"))
				returnType = "Ljava/lang/String;";
			else
				returnType = "I";
		} else {
			returnType = "V";
		}
		addCode("  invokevirtual " + getProgramName() + "/"
				+ callNode.getName() + "()" + returnType);

	}

	public void visit(CallVarNode callVarNode) {
		VariableNode vNode = ((AbstractScopeNode) callVarNode.getParent())
				.getVariable(callVarNode.getName());

		if (vNode.getType().equals(String.class)) {
			// TODO
			addCode("  aload " + vNode.getStackNumber());
		} else {
			addCode("  iload " + vNode.getStackNumber());
		}
	}

	public void visit(ExpressionNode expressionNode) {
		// Bezoek de current value van de expressie.
		if (expressionNode.getValue() != null) {
			expressionNode.getValue().accept(this);
		}

		// Bezoek rechts van de expressie.
		if (expressionNode.getRight() != null) {
			expressionNode.getRight().accept(this);
		}

		// Verwerk symbols
		if (expressionNode.getType() != null) {
			switch (expressionNode.getType()) {
			case sym.PLUS: {
				addCode("  iadd");
				break;
			}
			case sym.MINUS: {
				addCode("  isub");
				break;
			}
			case sym.ASTERICK: {
				addCode("  imul");
				break;
			}
			case sym.BSLASH: {
				addCode("  idiv");
				break;
			}
			}

			if (expressionNode.getParent() instanceof WhileNode) {
				// Invert de IF's, vanwege de subtract die ik doe:
				switch (expressionNode.getType()) {

				case sym.EQEQ: {
					addCode("  isub");
					addCode("  ifne done"
							+ ((IStackNode) expressionNode.getParent())
									.getStackNumber());
					break;
				}
				case sym.NEQ: {
					addCode("  isub");
					addCode("  ifeq done"
							+ ((IStackNode) expressionNode.getParent())
									.getStackNumber());
					break;
				}
				case sym.LESS: {
					addCode("  isub");
					addCode("  ifgt done"
							+ ((IStackNode) expressionNode.getParent())
									.getStackNumber());
					break;
				}
				case sym.LESSEQ: {
					addCode("  isub");
					addCode("  ifge done"
							+ ((IStackNode) expressionNode.getParent())
									.getStackNumber());
					break;
				}
				case sym.GREATER: {
					addCode("  isub");
					addCode("  iflt done"
							+ ((IStackNode) expressionNode.getParent())
									.getStackNumber());
					break;
				}
				case sym.GREATEREQ: {
					addCode("  isub");
					addCode("  ifle done"
							+ ((IStackNode) expressionNode.getParent())
									.getStackNumber());
					break;
				}
				}
			}
		}
	}

	public void visit(FunctionNode functionNode) {
		programBlock(functionNode);
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
		addCode("  getstatic java/lang/System/out Ljava/io/PrintStream;");
		printNode.getExpression().accept(this);
		addCode("  invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");

	}

	public void visit(ProcedureNode procedureNode) {
		programBlock(procedureNode);
	}

	public void visit(ProgramNode programNode) {
		addCode(".class public " + getProgramName());
		addCode(".super java/lang/Object");
		addCode(".method public <init>()V");
		addCode("  aload_0 ; push this");
		addCode("  invokespecial java/lang/Object/<init>()V ; call super");
		addCode("  return");
		addCode(".end method");
		addCode("");
		addCode(".method public static main([Ljava/lang/String;)V");
		addCode("  .limit stack 2");
		addCode("  new " + getProgramName());
		addCode("  dup");
		addCode("  invokespecial " + getProgramName() + "/<init>()V");
		addCode("  invokevirtual " + getProgramName() + "/main()V");
		addCode("  return");
		addCode(".end method");
		// Bezoek globale vars
		visitVariableNodes(programNode.getVariables());

		// Bezoek procs/funcs
		for (AbstractNode n : programNode.getChilds())
			n.accept(this);
	}
}
