import java.util.Arrays;

/*
 * Here we will use Dutch national flag algorithm. We will choose pivot element
 * (i.e. the element which will remain in the middle)
 *  as 1, the while scanning we'll move zeros to the right and Ones to the left
 */
public class SortingArraysWithZerosOnesAndTwos {
	public static void main(String[] args) {
		int[] array = { 1, 2, 1, 1, 0, 0, 1, 2, 0, 0, 2, 1, 2, 1, 0, 1, 2, 0, 1, 0, 2, 0, 1, 2 };
		sort(array);
		Arrays.stream(array).forEach(e -> System.out.print(e + " "));
	}

	private static void sort(int[] array) {
		int low = 0;
		int mid = 0;
		int high = array.length - 1;

		while (mid <= high) {
			switch (array[mid]) {
			case 0:
				// When Zero is found we have to move it to the left and increment mid and low
				swap(array, low, mid);
				low++;
				mid++;
				break;

			case 1:
				// As 1 is pivot, we don't need to do anything but to increment mid
				mid++;
				break;

			case 2:
				// When One is found we have to move it to the right and decrement high and
				// increment mid
				swap(array, mid, high);
				high--;
				break;
			}
		}
	}

	private static void swap(int[] array, int a, int b) {
		array[a] = array[a] + array[b];
		array[b] = array[a] - array[b];
		array[a] = array[a] - array[b];
	}
}
