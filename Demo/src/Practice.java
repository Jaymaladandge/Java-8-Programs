import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Practice {

	
	// To do rough code
	
	public static void main(String[] args) {
		
		
		Hashtable<Integer, String> map = new Hashtable<Integer, String>();
		map.put(100, "Amit");
		map.put(102, "Ravi");
		map.put(101, "Vijay");
		map.put(103, "Rahul");
		
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry);
		}
		
		System.out.println();
		String[] arr = { "java", "sql", "html", "python" };
		List<String> list = Arrays.asList(arr);

		list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		System.out.println();
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("---------------");

		list.stream().sorted().forEach(System.out::println);
		Arrays.sort(arr,String::compareTo);
		System.out.println(Arrays.toString(arr));
		System.out.println();

		list.stream().sorted((c1, c2) -> c1.length() - c2.length()).forEach(System.out::println);

		
		
		
	}
}
