
public class Main {
	public static void main(String[] args) {
		GenericBag<Integer> bag = new GenericBag<Integer>(6);
		bag.add(4);
		bag.add(3);
		bag.add(28);
		bag.add(7);
		bag.add(2);
		Object[] results = bag.findAll(t -> t % 2 == 0);
		for (Object i : results) {
			System.out.print(i+", ");
		}
		System.out.println();
		
		bag.displayContents();
	}

}
