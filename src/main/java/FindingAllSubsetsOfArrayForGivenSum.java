import java.util.Stack;

public class FindingAllSubsetsOfArrayForGivenSum {
	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 7, 1, 12, 15, 6, 3 };
		int sum = 13;
		
		printSubSets(arr, sum);
	}
	
	private static void printSubSets(int[] arr, int sum) {
		int tempSum = 0;
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			tempSum = arr[i];
			stack = new Stack<>();
			stack.push(arr[i]);
			for(int j = i + 1; j < arr.length; j++) {
				tempSum = tempSum + arr[j];
				stack.push(arr[j]);
				if(tempSum > sum) {
					tempSum = tempSum - arr[j];
					stack.pop();
				} else if (tempSum == sum){
					print(stack);
				} 
			}
		}
	}
	
	private static void print(Stack<Integer> stack) {
		for (Integer integer : stack) {
			System.out.print(integer+" ");
		}
		System.out.println();
	}
}
