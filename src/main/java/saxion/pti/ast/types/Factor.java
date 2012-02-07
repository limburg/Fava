package saxion.pti.ast.types;

/**
 * Een factor in een expressie
 * 
 * @author Joost Limburg
 * 
 * @param <T>
 *            Subtype van de factor, <3 generics.
 */
public class Factor<T> {
	private T value = null;

	public Factor(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}
