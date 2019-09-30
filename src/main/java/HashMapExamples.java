import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.akp.comparator.Employee;

public class HashMapExamples {

	public static void main(String[] args) {
		// System.out.println("Identity Hash map ----- > ");
		// testIdentityHashMap();

		// System.out.println("Normal Hash map ----- > ");
		// testNormalHashMap();

		// System.out.println("Concurrent Hash map ----- > ");
		// testConcurrentHashMap();

		System.out.println("Synchronized Hash map ----- > ");
		testSynchronizedHashMap();
	}

	// Identity Hash Map
	/**
	 * Identity hash map uses double equals operator (==) to compare keys unlike
	 * normal Hash Map where equals method is called
	 */
	private static void testIdentityHashMap() {
		Map<Employee, String> map = new IdentityHashMap<>();
		List<Employee> list = createEmployeeList();
		for (Employee employee : list) {
			map.put(employee, employee.getName());
		}
		map.entrySet().stream().forEach(System.out::println);
	}

	// Normal Hash Map
	private static void testNormalHashMap() {
		Map<Employee, String> map = new HashMap<>();
		List<Employee> list = createEmployeeList();
		for (Employee employee : list) {
			map.put(employee, employee.getName());
		}
		map.entrySet().stream().forEach(System.out::println);
	}

	/**
	 * Fail-fast vs Fail-safe : A system is called fails-fast if it is shutdown
	 * immediately when exception occurred. But in case of fail-safe the program
	 * keeps on running even after the exception occurred. For example -
	 * ConcurrentHashMap is fail-safe where as SynchronizedHashMap is fail-fast.
	 */

	// Concurrent Hash Map
	/**
	 * Concurrent Hash Map is synchronized i.e. thread safe, where the lock is not
	 * applied at object level. Locking is at much granularity at Hash Map bucket
	 * level. Read is done with out any locking, but write is done with a lock. It
	 * doesn't throw ConcurrentModificationException if one thread tries to modify
	 * it while another one is iterating over it. As read is happen without any
	 * lock, it is much faster than write operation. Iterator returned by this is
	 * fail-safe in nature.
	 */
	private static void testConcurrentHashMap() {
		// Thread operation with normal hash map
		Map<Employee, String> normalMap = new HashMap<>();
		List<Employee> list = createEmployeeList();
		for (Employee employee : list) {
			normalMap.put(employee, employee.getName());
		}
		Thread readerThread = new Thread(() -> {
			Iterator<Map.Entry<Employee, String>> iterator = normalMap.entrySet().iterator();
			while (iterator.hasNext()) {
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(iterator.next());
			}
		});
		readerThread.setName("Normal_map_reader");

		Thread writerThread = new Thread(() -> {
			normalMap.put(new Employee(29, "rupak", null), "deepak");
		});
		readerThread.setName("Normal_map_reader");
		writerThread.setName("Normal_map_writer");

		readerThread.start();
		writerThread.start();

		Map<Employee, String> map = new ConcurrentHashMap<>();
		List<Employee> list1 = createEmployeeList();
		for (Employee employee : list1) {
			map.put(employee, employee.getName());
		}
		Thread readerThread1 = new Thread(() -> {
			Iterator<Map.Entry<Employee, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(iterator.next());
			}
		});

		Thread writerThread1 = new Thread(() -> {
			map.put(new Employee(29, "deepak", null), "deepak");
		});

		readerThread1.start();
		writerThread1.start();
	}

	// Synchronized Hash Map
	/**
	 * As this map applies lock on the map it self only one thread can have access
	 * at a given time. Every read/write operation acquire lock on map object. It
	 * returns iterator which is fail-fast in nature.
	 */
	private static void testSynchronizedHashMap() {
		Map<Employee, String> map = Collections.synchronizedMap(new HashMap<>());
		List<Employee> list = createEmployeeList();
		for (Employee employee : list) {
			map.put(employee, employee.getName());
		}

		Thread readerThread = new Thread(() -> {
			Iterator<Map.Entry<Employee, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(iterator.next());
			}
		});

		Thread writerThread = new Thread(() -> {
			map.put(new Employee(29, "deepak", null), "deepak");
		});

		readerThread.start();
		writerThread.start();

	}

	private static List<Employee> createEmployeeList() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = new Employee(29, "ashish", null);
		Employee emp1 = new Employee(28, "kumar", null);
		Employee emp2 = new Employee(27, "patel", null);
		Employee emp3 = new Employee(29, "ashish", null);
		Employee emp4 = emp3;

		list.add(emp);
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);

		return list;
	}
}
