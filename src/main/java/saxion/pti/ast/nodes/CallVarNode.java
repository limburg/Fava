package saxion.pti.ast.nodes;

public class CallVarNode extends AbstractNode {
	private String name;
	
	public CallVarNode(String name)
	{
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}