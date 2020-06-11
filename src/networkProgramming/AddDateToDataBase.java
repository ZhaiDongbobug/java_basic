package networkProgramming;

public class AddDateToDataBase {

	public static void main(String[] args) {
		DictionaryDAO dao = new DictionaryDAO();
		dao.add(new Dictionary("你好","好你妹"));
		dao.add(new Dictionary("你叫什么","老子在忙，一边玩儿去"));
		dao.add(new Dictionary("你叫什么","同志，不约"));
		dao.add(new Dictionary("我靠","说人话"));
	}

}
