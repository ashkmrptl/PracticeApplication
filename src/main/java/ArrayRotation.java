public class ArrayRotation {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int noOfPlacesToRotate = 2;

		rotateUsingTempArray(array, noOfPlacesToRotate);

		rotateByOneElement(array, noOfPlacesToRotate, array.length);
	}

	/**
	 * This algorithm rotates the elements of the array using a temporary array So,
	 * the time and space complexity here is O(n) and O(d) respectively.	
	 * 
	 * @param array
	 * @param noOfPlacesToRotate
	 */
	private static void rotateUsingTempArray(int[] array, int noOfPlacesToRotate) {
		int[] tempArr = new int[2];
		System.out.println("Before swapping : ");
		printArray(array);

		// Copying the elements into temp array for copying
		for (int i = 0; i < tempArr.length; i++) {
			tempArr[i] = array[i];
		}
		// swapping rest elements
		for (int i = 0; i < array.length - noOfPlacesToRotate; i++) {
			array[i] = array[i + noOfPlacesToRotate];
		}

		// replacing elements from temp array
		int temp = tempArr.length - 1;
		for (int i = array.length - 1; i >= 0 && temp >= 0; i--) {
			array[i] = tempArr[temp--];
		}

		System.out.println("\nAFter swapping : ");
		printArray(array);

	}

	/**
	 * This algorithm rotates the elements of the array by one index at a time. So,
	 * the time and space complexity for this algorithm is O(n * d) and O(1)
	 * respectively.
	 * 
	 * @param array
	 * @param noOfPlacesToRotate
	 * @param n
	 */
	private static void rotateByOneElement(int[] array, int noOfPlacesToRotate, int n) {
		System.out.println("Before swapping : ");
		printArray(array);
		for (int i = 0; i < noOfPlacesToRotate; i++) {
			rotateByOneIndex(array, noOfPlacesToRotate, n);
		}
		System.out.println("\nAFter swapping : ");
		printArray(array);
	}

	private static void rotateByOneIndex(int[] array, int d, int n) {
		int i, temp;
		temp = array[0];
		for (i = 0; i < n - 1; i++)
			array[i] = array[i + 1];
		array[i] = temp;

	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}
