import java.util.Stack;
import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickStack<T extends Object> extends Stack<T> {
	private static final long serialVersionUID = 1L;
	
	public void pushAll(T[] elements) {
		for (T e : elements) {
			push(e);
		}
	}
	
	public T[] popAll() {
		int initialSize = elementCount;
		Class<?> clazz = this.elementData.getClass().getComponentType();
		T[] array = (T[]) Array.newInstance(clazz, initialSize);
		for (int i = 0; i < initialSize; i++) {
			array[i] = pop();
		}
		return array;
	}
	
	
}
