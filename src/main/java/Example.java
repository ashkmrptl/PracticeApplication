import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		//long[] array = new long[noOfTestCases];
		
		for (int i = 0; i < noOfTestCases; i++) {
			//array[i] = s.nextLong();
			System.out.println(((2 * s.nextLong()) + 1));
		}
		
		/*for (int i = 0; i < array.length; i++) {
			System.out.println(((2 * array[i]) + 1));
		}*/
		s.close();
	}
}