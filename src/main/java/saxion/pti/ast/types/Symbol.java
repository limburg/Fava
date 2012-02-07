package saxion.pti.ast.types;

import saxion.pti.generated.sym;

public class Symbol {
	private sym symbol;

	public Symbol(sym symbol) {
		this.symbol = symbol;
	}

	public sym getSymbol() {
		return symbol;
	}
}
