import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfStringToUpperCase {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "b", "c", "a", "e", "f");

		// Converting all Strings in list to upper case before Java 8
		List<String> upperCaseList = new ArrayList<String>();
		for (String string : list) {
			upperCaseList.add(string.toUpperCase());
		}

		System.out.println("list : " + list);
		System.out.println("upperCaseList : " + upperCaseList);

		// Converting all Strings in list to upper case after Java 8
		Set<String> upperCaseList1 = list.stream().map(String::toUpperCase).collect(Collectors.toSet());
		System.out.println("upperCaseList1 : " + upperCaseList1);
	}
}
