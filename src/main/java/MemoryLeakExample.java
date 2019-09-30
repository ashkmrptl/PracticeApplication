/**
 * 
 * @author Ashish_Patel3
 *
 *         An object in java is eligible for garbage collection when it is
 *         unreachable and no living threads can reach it. So if an object is
 *         not used anywhere in application and unintentionally has references,
 *         it is not eligible for garbage collection and is a potential memory
 *         leak;
 */
public class MemoryLeakExample {
	public static void main(String[] args) {
		memoryLeakUsingWrapperClass();
	}

	private static void memoryLeakUsingWrapperClass() {
		for (long i = 0; i < 1000; i++) {
			addIncremental(i);
		}
	}
	
	private static long addIncremental(long l) {
		Long sum = 0L;
		sum = sum + l;
		return sum;
	}
}
