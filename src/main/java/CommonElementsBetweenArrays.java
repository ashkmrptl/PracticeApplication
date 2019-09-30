import java.util.HashSet;
import java.util.Set;

public class CommonElementsBetweenArrays {
	public static void main(String[] args) {
		int[] arr = {1,2,3,7,6,5};
		int[] arr1 = {3,4,5,6,7,2,5,1,7,5,2,7,3,5,6,9};
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		for(int i = 0; i < arr1.length; i++) {
			if(!set.add(arr1[i])) {
				System.out.println(arr1[i]);
			} else {
				set.remove(arr1[i]);
			}
		}
		System.out.println(set);
	}
}
