package saxion.pti.ast.nodes;

import saxion.pti.ast.AbstractVisitTree;

/**
 * Programma (root) node, it all starts here!
 * 
 * @author Joost Limburg
 * 
 */
public class ProgramNode extends AbstractScopeNode {
	/**
	 * Constructor.
	 */
	public ProgramNode() {
		super(null);
	}

	/**
	 * Geeft de procedure/functienode terug aan de hand van de meegegeven naam.
	 * 
	 * @param name
	 *            De naam van de functie/procedure die gevraagt wordt
	 * @return de node van de procedure/functie die overeenkomt
	 */
	public AbstractParamNode getProcOrFunc(String name) {
		for (AbstractNode procFunc : getChilds()) {
			if (procFunc instanceof AbstractParamNode
					&& ((AbstractParamNode) procFunc).getName().equals(name)) {
				return (AbstractParamNode) procFunc;
			}

		}

		return null;
	}

	/**
	 * Bestaat de procedure of functie, bepaalt door de meegegeven naam.
	 * 
	 * @param name
	 *            Functie/procedure naam
	 * @return Bestaat wel/niet
	 */
	public boolean hasProcOrFunc(String name) {
		return getProcOrFunc(name) != null;
	}

	@Override
	public void accept(AbstractVisitTree abstractVisitTree) {
		abstractVisitTree.visit(this);
	}

}
