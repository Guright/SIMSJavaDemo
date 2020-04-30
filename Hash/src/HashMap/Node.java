package HashMap;

public class Node {
	public String key; // key值
	public int hash; // hash值
	public Node[] next; // 用来存相同hash值的数组吗，作为下一层
	public int value; // 个数

	public Node() {
		key = "";
		hash = 0;
		value = 0;
		next = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
