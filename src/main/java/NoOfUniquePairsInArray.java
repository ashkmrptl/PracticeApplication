import java.util.HashSet;
import java.util.Set;

/**
 * If an array contains 'n' no of unique elements than the total no of unique
 * pairs would be 'n*n' So, we can first store all the elements of the array
 * into a HashSet and then we can simply find out the square of the size of the
 * set to get the total no of unique pairs.
 * 
 * Time complexity here would be O(n)
 * 
 * @author Ashish_Patel3
 *
 */
public class NoOfUniquePairsInArray {
	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 4, 2, 5, 3, 5 };

		System.out.println("Total no of unique pairs : " + countPairs(array));
	}

	private static int countPairs(int[] array) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}

		return (int) Math.pow(set.size(), 2);
	}
}
