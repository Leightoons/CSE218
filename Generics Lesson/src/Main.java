import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A","B","C"));
		showList(list1, list2);
		//showList2(list1, list2); // gives error

	}
	
	public static void showList(ArrayList<?>... lists) {
		for (ArrayList<?> list: lists)
			list.forEach((e)->System.out.println(e));
	}
	
	public static <E> void showList2(ArrayList<E>... lists) {
		for (ArrayList<E> list: lists)
			list.forEach((e)->System.out.println(e));
	}
	
}
