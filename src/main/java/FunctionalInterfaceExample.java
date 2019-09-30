import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		System.out.println("Predicate example : ");
		predicateExample();

		System.out.println("\nConsumer example : ");
		consumerExample();
		
		System.out.println("\nsupplier example : ");
		supplierExample();
	}

	/**
	 * 1) Predicate : A Predicate is a statement that may be 'true' or 'false'
	 * depending on the values of its variables. It can be thought of as a function
	 * that returns a value that is either 'true' or 'false'. Predicate functional
	 * interface can be used anywhere we want to evaluate a boolean condition.
	 */
	private static void predicateExample() {
		// Using Conventional way
		Predicate<String> isLongWord = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() > 10;
			}

		};

		String s = "My Name is Ashish Kumar patel";
		System.out.println("Is the string a long word : " + isLongWord.test(s));

		// Using Lambda Expression
		Predicate<String> isShortWord = string -> string.length() < 10;
		System.out.println("Is the string a short word : " + isShortWord.test(s));

		// Using Predicate to filter collection
		List<String> list = new ArrayList<String>();
		list.add("ashish");
		list.add("kumar");
		list.add("patel");

		System.out.println("All names : " + list);

		List<String> namesStartingWithA = list.stream().filter(str -> str.startsWith("a")).collect(Collectors.toList());
		System.out.println("Names starting with 'a' : " + namesStartingWithA);
	}

	/**
	 * 2) Consumer : This functional interface represents an operation that accepts
	 * a single input and returns nothing.
	 */
	private static void consumerExample() {
		class Product {
			private double price = 0.0;

			public void setPrice(double price) {
				this.price = price;
			}

			public void printPrice() {
				System.out.println(this.price);
			}
		}

		// Using conventional way
		Consumer<Product> updatePrice = new Consumer<Product>() {

			@Override
			public void accept(Product t) {
				t.setPrice(10.0);
			}
		};
		Product p = new Product();
		updatePrice.accept(p);

		p.printPrice();

		// Using Lambda expression
		Consumer<Product> changePrice = product -> product.setPrice(11.0);
		changePrice.accept(p);
		p.printPrice();
	}

	/**
	 * 3) Supplier :  This functional interface takes no argument but return a value exactly opposite of Consumer functional interface.
	 */
	private static void supplierExample() {
		Supplier<String> print = new Supplier<String>() {

			@Override
			public String get() {
				return "test string";
			}
		};
		
		System.out.println(print.get());
		
		Supplier<String> printf = () -> "test string one";
		System.out.println(printf.get());
	}
}
