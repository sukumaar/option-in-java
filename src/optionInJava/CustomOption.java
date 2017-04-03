package optionInJava;

import java.util.HashMap;

/**
 * @author Sukumaar
 * @since 03-Apr-17
 * */
public class CustomOption {
	public static void main(String[] args) {
		MyOption<Integer> b1 = new MyOption<Integer>(new Integer(1));
		System.out.println(b1.isNull());
		MyOption<Integer> o1 = new MyOption<Integer>(null);
		System.out.println(o1.getOrElse(3));
	}
}

final class MyOption<T> {
	private T t;

	HashMap<T, T> handlingNull = new HashMap<>();

	public MyOption(T t) {
		super();
		this.t = t;
		this.handlingNull.put(t, t);
	}

	public T get() {
		return handlingNull.get(t);
	}

	public boolean isNull() {
		return handlingNull.containsKey(null);
	}

	public T getOrElse(T t) {
		if (handlingNull.containsKey(null)) {
			return t;
		}
		return get();
	}

}