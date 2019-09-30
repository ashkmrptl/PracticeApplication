/**
 * We fix this by taking a Integer array to store the character count. So, we
 * need O(n) time. And we need to traverse the two arrays.
 * 
 * @author Ashish_Patel3
 *
 */
public class CountingIndividualCharactersInAWord {
	private static final int NO_OF_CHARS = 256;

	public static void main(String[] args) {
		String string = "ashish";
		printDistinct(string);
	}

	static void printDistinct(String str) {
		int[] count = new int[NO_OF_CHARS];

		int i;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				System.out.println();
				count[(int) str.charAt(i)]++;
			}
		}
		int n = i;

		for (i = 0; i < n; i++) {
			if (count[(int) str.charAt(i)] == 1) {
				System.out.print(str.charAt(i));
			}
		}
	}
}
