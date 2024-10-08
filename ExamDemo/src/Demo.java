import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		QuickStack<Integer> stack = new QuickStack<>();
		stack.pushAll(new Integer[]{1,2,3,4});
		
		Object[] array = stack.popAll();
		System.out.println(Arrays.toString(array));
	}

}
