package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashTableTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>(4);
		Map<String, String> newMap = new HashMap<>(4);
		map.put("adc", "物理英雄");
		map.put("apc", "魔法英雄");
		map.put("t", "坦克");
		System.out.println(map);
		Set<String> set = map.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			String value = map.get(key);
			map.put(value, key);
		}
		System.out.println(newMap);
	}

}
