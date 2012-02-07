package saxion.pti.ast.types;

public class Type<T> {
	public Type() {

	};

	public static Type<String> newStringType() {
		return new Type<String>();
	}

	public static Type<Integer> newIntType() {
		return new Type<Integer>();
	}

	public static Type<Boolean> newBooleanType() {
		return new Type<Boolean>();
	}
}