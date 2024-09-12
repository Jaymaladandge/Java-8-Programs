package com.functionalPrograms;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatOcuurance {

	public static void main(String[] args) throws Exception {

		String str = "aabbccddefg";
		String[] arr = str.split("");

		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

		for (String s : arr) {
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else
				map.put(s, 1);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("1st non repeat occurance : " + entry.getKey());
				break;
			}
		}

		// ----------
		Map.Entry<String, Integer> entry = map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst()
				.orElseThrow(() -> new Exception("No non repeat value present !!!!"));
		System.out.println("1st non repeat occurance : " + entry.getKey());

	}
}
