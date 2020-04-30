package HashMap;

import java.util.Scanner;

public class HashList {

	public Node[] node;

	public HashList() {
		node = new Node[63];

		for (int i = 0; i < 63; i++) {
			node[i] = new Node();
		}
	}

	public int Hash(String s) { // 计算hash值
		int r = 0;
		char[] c = s.toCharArray();

		r = (int) c[0];

		if (c[0] >= 'a' && c[0] <= 'z') { // 如果首字符是a~z，hash值为ASCII码减去97
			r -= 97;
		} else if (c[0] >= 'A' && c[0] <= 'Z') { // 如果首字符是A~Z，hash值为ASCII码减去39
			r -= 39;
		} else if (c[0] >= '0' && c[0] <= '9') { // 如果首字符是0~9，hash值为ASCII码加上4
			r += 4;
		} else if (c[0] == '_') { // 如果首字符是_，hash值为62
			r = 62;
		}
		return r;
	}

	public void Insert(String s) { // 插入hash表
		Node[] p;
		p = node;

		if (p[Hash(s)].key.equals("") == true) { // 如果在第一层该hash值所在位置没有元素，插入该位置
			p[Hash(s)].key = s;
			p[Hash(s)].hash = Hash(s);
			p[Hash(s)].value++;
			p[Hash(s)].next = null;
		} else if (p[Hash(s)].key.equals(s) == true) { // 如果在第一层该hash值所在位置有元素且key值相同，那么value加1
			p[Hash(s)].value++;
		} else if (p[Hash(s)].key.equals("") == false && p[Hash(s)].key.equals(s) == false) { // 如果在第一层该hash值所在位置有元素但key值不相同，那么往该hash值的下一层找
			while (p[Hash(s)].key.equals(s) == false) {
				if (p[Hash(s)].next == null) {
					break;
				}
				p = p[Hash(s)].next;
			}
			if (p[Hash(s)].key.equals(s) == true) {
				p[Hash(s)].value++;
			} else if (p[Hash(s)].next == null) {
				p[Hash(s)].next = new Node[63];
				p = p[Hash(s)].next;
				for (int i = 0; i < 63; i++) {
					p[i] = new Node();
				}
				p[Hash(s)].hash = Hash(s);
				p[Hash(s)].key = s;
				p[Hash(s)].next = null;
				p[Hash(s)].value++;
			}
		}
	}

	public int GetValue(String s) { // 根据key获取value值
		int r = 0;
		Node[] p = node;

		if (p[Hash(s)].key.equals("") == false) { // 寻找hash值相同且key相同的位置
			while (p != null) {
				if (p == null || p[Hash(s)].key.equals(s) == true) {
					break;
				}
				p = p[Hash(s)].next;
			}
			if (p == null) {
				r = 0;
			} else if (p[Hash(s)].key.equals(s) == true) { // 获取value
				r = p[Hash(s)].value;
			}
		} else {
			r = p[Hash(s)].value; // 获取value
		}
		return r;
	}

	public void Reduce(String s) { // 把该key的 value归零
		Node[] p = node;

		if (p[Hash(s)].key.equals("") == false) {
			while (p != null) {
				if (p == null || p[Hash(s)].key.equals(s) == true) {
					break;
				}
				p = p[Hash(s)].next;
			}
			if (p == null) {

			} else if (p[Hash(s)].key.equals(s) == true) {
				p[Hash(s)].value--;
			}
		} else {
			p[Hash(s)].value--;
		}
	}

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s;
		HashList p = new HashList();
		for (int i = 0; i < 4; i++) {
			s = in.next();
			if (0 <= p.Hash(s) && p.Hash(s) < 63) {
				p.Insert(s);
			}
		}
		s = in.next();
		int r = p.GetValue(s);
		System.out.println(r);
		in.close();
	}
}