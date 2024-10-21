
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static <T extends Comparable<T>> int binarySearch(T[] array, T key) {
		return binarySearch(array, key, 0, array.length-1);
	}
	private static <T extends Comparable<T>> int binarySearch(T[] array, T key, int start, int end) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		int comp = key.compareTo(array[mid]);
		if (comp == 0)
			return mid;
		else if (comp > 0)
			return binarySearch(array, key, mid + 1, end);
		else
			return binarySearch(array, key, start, mid - 1);
	}
	
	public class Hanoi {
		private int discCount;
		
		public Hanoi(int discCount) {
			this.discCount = discCount;
		}
	}
	
}
