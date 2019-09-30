import java.util.Stack;

public class FindingElementsForGivenSum {
	private static int[] arr = { 2, 4, 5, 7, 1, 12, 15, 6, 3 };
	private static int SUM = 13;

	private static int sumInStack = 0;

	private static Stack<Integer> stack = new Stack<Integer>();

	private static void populateSubset(int[] arr, int fromIndex, int endIndex) {
		if (sumInStack == SUM) {
			print(stack);
		}

		for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

			if (sumInStack + arr[currentIndex] <= SUM) {
				stack.push(arr[currentIndex]);
				sumInStack += arr[currentIndex];
				populateSubset(arr, currentIndex + 1, endIndex);
				sumInStack -= (Integer) stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		populateSubset(arr, 0, arr.length - 1);
	}

	private static void print(Stack<Integer> stack) {
		StringBuilder sb = new StringBuilder();
		sb.append(SUM).append(" = ");
		for (Integer i : stack) {
			sb.append(i).append("+");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
	}
}
