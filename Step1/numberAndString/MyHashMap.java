package numberAndString;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyHashMap implements IHashMap {

	LinkedList<Entry>[] values = new LinkedList[2000];

	public static void main(String[] args) {
		System.out.println("请输入键值：");
		Scanner scanner = new Scanner(System.in);
		String key = scanner.next();
		Integer value = scanner.nextInt();
		MyHashMap map = new MyHashMap();
		map.put(key, value);
		int number = (int) map.get(key);
		System.out.println("结果是：");
		System.out.println(number);
		scanner.close();
	}

	@Override
	public void put(String key, Object object) {
		// 拿到hashCode
		int hashCode = hashcode(key);
		// 找到对应的LinkedList
		LinkedList<Entry> list = values[hashCode];
		// 如果LinkedList是null,则创建一个LinkedList
		if (list == null) {
			list = new LinkedList<>();
			values[hashCode] = list;
		}

		boolean found = false;
		for (Entry entry : list) {
			// 如果已经有了，则替换掉
			if (key.equals(entry.key)) {
				entry.value = object;
				found = true;
				break;
			}
		}

		// 如果没有已经存在的键值对，则创建新的键值对
		if (!found) {
			Entry entry = new Entry(key, object);
			list.add(entry);
		}
	}

	@Override
	public Object get(String key) {
		// 获取hashCode
		int hashCode = hashcode(key);
		// 找到hashCode对应的LinkedList
		List<Entry> list = values[hashCode];
		if (null == list) {
			return null;
		}
		Object result = null;
		// 挨个比较每个键值对的key,找到匹配的，返回其value
		for (Entry entry : list) {
			if (entry.key.equals(key)) {
				result = entry.value;
				break;
			}
		}
		return result;
	}

	public static int hashcode(String str) {
		if (str == null) {
			return 0;
		}
		char[] ch = str.toCharArray();
		int hash = 0;
		for (char c : ch) {
			hash += c;
		}
		hash *= 23;
		// 取绝对值
		hash = hash < 0 ? 0 - hash : hash;
		// 落在0-1999之间
		hash = hash % 2000;

		return hash;
	}
}
