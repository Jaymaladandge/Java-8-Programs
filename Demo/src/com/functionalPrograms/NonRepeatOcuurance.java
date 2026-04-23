package com.functionalPrograms;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatOcuurance {

	public static void main(String[] args) throws Exception {

		String str = "aabbccddefg";
		boolean flag = false;
		String[] arr = str.split("");
		
		for(int i=0;i<arr.length;i++) {
			
			String s1 = arr[i];
			for(int j=0;j<arr.length;j++) {
				
				if(i==j) {
					continue;
				}
				if(s1.equals(arr[j])) {
					flag=true;
					break;
				}else {
					flag=false;
				}
			}
			if(!flag) {
				System.out.println("Firast non repeat charecter : "+s1);
				break;
			}
		}
		
		System.out.println("------------------------------------");
		
		
		String str1 = "aabbccddefg";
		String[] arr1 = str1.split("");

		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

		for (String s : arr1) {
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
