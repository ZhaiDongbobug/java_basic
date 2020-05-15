package basicExample3;

import java.util.ArrayList;

public class NewArrayList {

	public static void main(String[] args) {
		ArrayList<job> value = new ArrayList<>();
		value.add(new hero());
		value.add(new item());
	}

	interface job {

	}

	static class hero implements job {

	}

	static class item implements job {

	}

}
