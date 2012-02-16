package saxion.pti.ast;

import saxion.pti.ast.nodes.AbstractNode;
import saxion.pti.ast.nodes.AbstractParamNode;
import saxion.pti.ast.nodes.AbstractScopeNode;
import saxion.pti.ast.nodes.AssignmentNode;
import saxion.pti.ast.nodes.CallNode;
import saxion.pti.ast.nodes.CallVarNode;
import saxion.pti.ast.nodes.ElseNode;
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
			addCode("  goto done" + whileNode.getStackNumber());
			addCode(" start" + whileNode.getStackNumber() + ":");
		}

		// Bezoek code
		executeStackCode(whileNode.getCode());
		addCode("  goto while" + whileNode.getStackNumber());
		addCode(" done" + whileNode.getStackNumber() + ":");
	}

	/**
	 * VariableNode
	 */
	public void visit(VariableNode varNode) {
		if (varNode.getParent() instanceof ProgramNode) {
			if (varNode.getType().equals(String.class)) {
				addCode(".field private " + varNode.getName()
						+ " Ljava/lang/String;");
			} else {
				addCode(".field private " + varNode.getName() + " I");
			}
		} else {
			if (varNode.getExpression() != null) {
				if (varNode.getType().equals(String.class)) {
					varNode.getExpression().accept(this);
					addCode("  astore " + varNode.getStackNumber());
				} else {
					varNode.getExpression().accept(this);
					addCode("  istore " + varNode.getStackNumber());
				}
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
		AbstractScopeNode scope = (AbstractScopeNode) assignmentNode
				.getParent();
		// Verkrijg referentie van variabele
		VariableNode varNode = scope.getVariable(assignmentNode.getVariable());

		if (varNode.getParent() instanceof ProgramNode)
			addCode("  aload 0");

		// Bezoek assignment code
		assignmentNode.getExpression().accept(this);

		// Sla resultaten op
		if (varNode.getParent() instanceof ProgramNode) {
			String type = "I";

			if (varNode.getType().equals(String.class))
				type = "Ljava/lang/String;";

			addCode("  putfield " + getProgramName() + "/" + varNode.getName()
					+ " " + type);

		} else {
			if (varNode.getType().equals(String.class)) {
				addCode("  astore " + varNode.getStackNumber());
			} else {
				addCode("  istore " + varNode.getStackNumber());
			}
		}

	}

	public void visit(CallNode callNode) {
		// Push stack
		// addCode("  aload 0");

		// < voer hier values voor de params in >
		String params = "";
		boolean comma = false;
		AbstractParamNode paramNode = tree.getRootNode().getProcOrFunc(
				callNode.getName());

		if (paramNode == null)
			throw new RuntimeException("undeclared function/procedure found: "
					+ callNode.getName());

		for (VariableNode v : paramNode.getParameters()) {
			if (!comma) {
				comma = true;
			} else {
				params += ",";
			}

			if (v.getType().equals("String"))
				params += "Ljava/lang/String;";
			else
				params += "I";
		}

		// determineer teruggeef type
		String returnType = "";
		if (paramNode instanceof FunctionNode) {
			FunctionNode parent = (FunctionNode) paramNode;

			if (parent.getReturnType().equals("String"))
				returnType = "Ljava/lang/String;";
			else
				returnType = "I";
		} else {
			returnType = "V";
		}

		addCode("  aload 0");

		// Bezoek parameters, mits aanwezig.
		for (ExpressionNode e : callNode.getParameters())
			e.accept(this);

		// Voeg de invoke code toe
		addCode("  invokevirtual " + getProgramName() + "/"
				+ callNode.getName() + "(" + params + ")" + returnType);

	}

	public void visit(CallVarNode callVarNode) {
		VariableNode vNode = ((AbstractScopeNode) callVarNode.getParent())
				.getVariable(callVarNode.getName());
		if (vNode.getType().equals(String.class)) {
			if (vNode.getParent() instanceof ProgramNode) {
				addCode("  aload 0");
				addCode("  getfield " + getProgramName() + "/"
						+ vNode.getName() + " Ljava/lang/String;");
			} else {
				addCode("  aload " + vNode.getStackNumber());
			}
		} else {
			if (vNode.getParent() instanceof ProgramNode) {
				addCode("  aload 0");
				addCode("  getfield " + getProgramName() + "/"
						+ vNode.getName() + " I");
			} else
				addCode("  iload " + vNode.getStackNumber());
		}
	}

	public void visit(ExpressionNode expressionNode) {
		// Strings appenden
		boolean appendToString = expressionNode.getSymbol() != null
				&& expressionNode.getType().equals(String.class);

		if (expressionNode.getValue() instanceof ExpressionNode)
			System.out.println("Yep");

		if (appendToString) {
			addCode("  new java/lang/StringBuffer");
			addCode("  dup");
			addCode("  invokespecial java/lang/StringBuffer/<init>()V");
		}

		// Bezoek de current value van de expressie.
		if (expressionNode.getValue() != null) {
			expressionNode.getValue().accept(this);
		}

		// Voor strings, eerst appenden:
		if (appendToString) {
			addCode("  invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;");
		}
		// Bezoek rechts van de expressie.
		if (expressionNode.getRight() != null) {
			expressionNode.getRight().accept(this);
		}

		// Verwerk symbols
		if (expressionNode.getSymbol() != null && !appendToString) {
			switch (expressionNode.getSymbol()) {
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

			if (expressionNode.getParent() instanceof IStackNode) {
				Integer stackNumber = ((IStackNode) expressionNode.getParent())
						.getStackNumber();

				switch (expressionNode.getSymbol()) {

				case sym.EQEQ: {
					addCode("  if_icmpeq start" + stackNumber);
					break;
				}
				case sym.NEQ: {
					addCode("  if_icmpne start" + stackNumber);
					break;
				}
				case sym.LESS: {
					addCode("  if_icmplt start" + stackNumber);
					break;
				}
				case sym.LESSEQ: {
					addCode("  if_icmple start" + stackNumber);
					break;
				}
				case sym.GREATER: {
					addCode("  if_icmpgt start" + stackNumber);
					break;
				}
				case sym.GREATEREQ: {
					addCode("  if_icmpge start" + stackNumber);
					break;
				}

				}
			}
		}

		// Finalize de string
		if (appendToString) {
			addCode("  invokevirtual java/lang/StringBuffer/append(Ljava/lang/String;)Ljava/lang/StringBuffer;");
			addCode("  invokevirtual java/lang/StringBuffer/toString()Ljava/lang/String;");
		}
	}

	public void visit(FunctionNode functionNode) {
		programBlock(functionNode);
	}

	public void visit(IfNode ifNode) {
		if (!(ifNode instanceof ElseNode)) {
			boolean blankElse = false;

			// Bezoek statement
			if (ifNode.getStatement() != null)
				ifNode.getStatement().accept(this);

			// Bezoek else
			for (AbstractScopeNode node : ifNode.getChilds()) {
				if (node instanceof ElseNode) {
					ElseNode eNode = ((ElseNode) node);
					eNode.setStackNumber(getNewLabelNumber());

					if (eNode.getStatement() != null) {
						eNode.getStatement().accept(this);
					} else {
						blankElse = true;
						addCode("  goto start" + eNode.getStackNumber());
					}
				}
			}

			if (!blankElse)
				addCode("  goto done" + ifNode.getStackNumber());
		}

		// Bezoek iedere else child
		for (AbstractScopeNode node : ifNode.getChilds()) {
			if (node instanceof ElseNode)
				node.accept(this);
		}

		// Bezoek code
		addCode(" start" + ifNode.getStackNumber() + ":");
		executeStackCode(ifNode.getCode());

		if (ifNode instanceof ElseNode)
			addCode("  goto done"
					+ ((IfNode) ifNode.getParent()).getStackNumber());
		else {
			// Einde
			addCode(" done" + ifNode.getStackNumber() + ":");
		}
	}

	public void visit(PrintNode printNode) {
		addCode("  getstatic java/lang/System/out Ljava/io/PrintStream;");
		Class<?> type = determineExpressionType(printNode.getExpression());
		printNode.getExpression().accept(this);
		String inputType = "I";

		if (type != null && type.equals(String.class)) {
			inputType = "Ljava/lang/String;";
		}

		addCode("  invokevirtual java/io/PrintStream/print(" + inputType + ")V");

	}

	public void visit(ProcedureNode procedureNode) {
		programBlock(procedureNode);
	}

	public void visit(ProgramNode programNode) {
		// Header
		addCode(".class public " + getProgramName());
		addCode(".super java/lang/Object");
		addCode("");

		// Bezoek globale vars
		visitVariableNodes(programNode.getVariables(), 0);
		addCode("");

		// Main entry
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
		addCode("");

		// Bezoek procs/funcs
		for (AbstractNode n : programNode.getChilds())
			n.accept(this);
	}
}
