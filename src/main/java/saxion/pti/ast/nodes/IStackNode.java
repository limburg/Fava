package saxion.pti.ast.nodes;

public interface IStackNode {
	public Integer getStackNumber();
	
	public boolean isGlobal();
	
	public void setStackNumber(Integer stackNumber);
}
