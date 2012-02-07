package saxion.pti.ast.types;

import saxion.pti.generated.sym;

public class Operator {
	private boolean multiply = false;

	private boolean mod = false;

	private boolean divide = false;

	public Operator(int type) {
		if (type == sym.ASTERICK)
			multiply = true;
		else if (type == sym.MOD) {
			mod = true;
		} else if (type == sym.FSLASH)
			divide = true;
	}

	/**
	 * @return the multiply
	 */
	public boolean isMultiply() {
		return multiply;
	}

	/**
	 * @return the mod
	 */
	public boolean isMod() {
		return mod;
	}

	/**
	 * @return the divide
	 */
	public boolean isDivide() {
		return divide;
	}

	@Override
	public String toString() {
		if (isMultiply())
			return "multiply";
		if (isDivide())
			return "divide";
		if (isMod())
			return "mod";
		else
			return "unknown";
	}
}
