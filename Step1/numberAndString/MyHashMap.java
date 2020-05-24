package numberAndString;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyHashMap implements IHashMap{

	Object[] objArry = new Object[2000]; 
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
		int hashCode = hashcode(key);
		Entry entry = new Entry(key,object);
		if(objArry[hashCode] == null) {
			List<Entry> list = new LinkedList<>();
			list.add(entry);
			objArry[hashCode] = list;
		}else {
			List<Entry> list = (List<Entry>) objArry[hashCode];
			list.add(entry);
		}	
	}

	@Override
	public Object get(String key) {
		int hashCode = hashcode(key);
		List<Entry> list = (List<Entry>) objArry[hashCode];
		for(int i=0;i<list.size();i++) {
			Entry entry = (Entry) list.get(i);
			if(entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
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
		//取绝对值
		hash = hash<0 ? 0-hash:hash;
		//落在0-1999之间
		hash = hash % 2000;
		
		return hash;
	}
}
