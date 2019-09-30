
public class ReversingString {
	public static void main(String[] args) {
		String str = "Ashish Kumar Patel";
		reverseByusingByteArray(str);
		reverseUsingCharArray(str);
		reverseStringRecursively(str);
	}

	private static void reverseByusingByteArray(String string) {
		byte[] arr = string.getBytes();
		byte[] revArr = new byte[arr.length];

		for (int i = 0; i < arr.length; i++) {
			revArr[i] = arr[arr.length - i - 1];
		}

		System.out.println("result : " + new String(revArr));
	}

	private static void reverseUsingCharArray(String str) {
		char[] arr = str.toCharArray();
		char temp = 'a';
		for (int i = 0; i < arr.length/2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}

		System.out.println("Result using char array : " + new String(arr));
	}
	
	private static void reverseStringRecursively(String str) {
		revString(str);
	}
	
	private static void revString(String str) {
		if(str == null || str.length() <= 1) {
			System.out.print(str);
		} else {
			System.out.print(str.charAt(str.length() - 1));
			revString(str.substring(0, str.length() - 1));
		}
	}
}
