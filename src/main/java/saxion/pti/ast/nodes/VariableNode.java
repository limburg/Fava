package saxion.pti.ast.nodes;

import saxion.pti.ast.types.Type;

/**
 * Local or Formal Declaration. varType name
 */
public class VariableNode extends Node implements INamedNode{
  private String name;
  private Type<?> varType;

  public VariableNode(Type<?> varType, String name) {
    super(null);
    this.name = name;
    this.varType = varType;
  }

  public String getName() { return name; }
  public Type<?> getVarType() { return varType; }

  public String toString()
  {
     return " Declaration "+varType + " named " + name;
  }
}