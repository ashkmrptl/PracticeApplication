import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortingMapByValue {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "z");
		map.put("b", "y");
		map.put("c", "x");
		map.put("d", "l");
		map.put("e", "k");
		map.put("f", "j");
		map.put("g", "f");
		map.put("h", "e");

		System.out.println("Unsorted map : ");

		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}

		Map<String, String> sortedMap = sortMapByValueUsingStream(map);// sortMapByValue(map);

		System.out.println("\nSorted map by value : ");

		for (Entry<String, String> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}

		Map<String, String> sortedMapByKey = sortMapByKey(map);

		System.out.println("\nSorted map by key : ");

		for (Entry<String, String> entry : sortedMapByKey.entrySet()) {
			System.out.println(entry.getKey() + "----" + entry.getValue());
		}
	}

	/**
	 * We will get the list of Entry and then sort the entry list and then put the
	 * element back to a LinkedHashMmap
	 * 
	 * @param inputMmap
	 * @return
	 */
	private static Map<String, String> sortMapByValue(Map<String, String> inputMmap) {
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(inputMmap.entrySet());

		// Sorting the list
		Collections.sort(list, new Comparator<Entry<String, String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});

		// Putting data from sorted list to linked hash map
		Map<String, String> sortedMap = new LinkedHashMap<>();
		for (Entry<String, String> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Map<String, String> sortMapByValueUsingStream(Map<String, String> inputMmap) {
		Map sortedMap = null;
		sortedMap = inputMmap.entrySet().stream().sorted(Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;
	}

	private static Map<String, String> sortMapByKey(Map<String, String> inputMap) {
		List<String> keyList = new ArrayList<>(inputMap.keySet());

		Collections.sort(keyList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		// Putting data from sorted list to linked hash map
		Map<String, String> sortedMap = new LinkedHashMap<>();
		for (String key : keyList) {
			sortedMap.put(key, inputMap.get(key));
		}

		return sortedMap;
	}
}
