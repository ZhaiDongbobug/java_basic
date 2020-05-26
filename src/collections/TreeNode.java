package collections;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

	public TreeNode leftTree;
	public TreeNode rightTree;
	public Integer value;

	public void add(Integer v) {
		if (null == value)
			value = v;
		else {
			if (v < value) {
				if (null == leftTree)
					leftTree = new TreeNode();
				leftTree.add(v);
			}

			else {
				if (null == rightTree)
					rightTree = new TreeNode();
				rightTree.add(v);
			}
		}

	}

	public List<Object> values() {
		List<Object> values = new ArrayList<>();

		if (null != leftTree)
			values.addAll(leftTree.values());

		values.add(value);

		if (null != rightTree)

			values.addAll(rightTree.values());

		return values;
	}
}
