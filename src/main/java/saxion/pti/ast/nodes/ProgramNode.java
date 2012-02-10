package saxion.pti.ast.nodes;

import java.util.LinkedList;

import saxion.pti.ast.VisitTree;

public class ProgramNode extends AbstractScopeNode {
	private LinkedList<ProcedureNode> procedures = new LinkedList<ProcedureNode>();
	
	private LinkedList<FunctionNode> functions = new LinkedList<FunctionNode>();
	
	public ProgramNode() {
		super();
	}

	public void addProcedure(ProcedureNode proc) throws Exception
	{
		if (!hasProcOrFunc(proc.getName()))
			procedures.add(proc);
		else
			throw new Exception("procedure "+ proc.getName() + " already defined by a procedure/function.");
	}
	
	public void addFunction(FunctionNode func) throws Exception
	{
		if (!hasProcOrFunc(func.getName()))
			functions.add(func);
		else
			throw new Exception("function "+ func.getName() + " already defined by a procedure/function.");
	}
	
	private boolean hasProcOrFunc(String name) {
		for (ProcedureNode proc : procedures)
		{
			if (proc.getName().equalsIgnoreCase(name))
				return true;
		}

		return false;
	}

	@Override
	public void accept(VisitTree tree) {
		tree.visit(this);
	}
	
}
