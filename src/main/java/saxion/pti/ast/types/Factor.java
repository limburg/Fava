package saxion.pti.ast.types;

public class Factor<T> {
	private T value = null;

	public Factor(T value) {
		System.out.println("Factor<" + value.getClass().getSimpleName() + ">: " + value);
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
