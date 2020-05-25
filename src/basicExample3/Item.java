package basicExample3;

public class Item implements Comparable<Item> {

	int price;
	String name;

	public Item(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public String toString() {
		String str = "Item[name: " + name + ", price: " + price + "]\r\n";
		return str;
	}

	public int compareTo(Item item) {
		if (price >= item.price) {
			return -1;
		} else {
			return 1;
		}
	}
}
