package HashMap;

import java.lang.Math;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField; // 关键字输入框
	private JTextField textField_1; // 源码1输入框
	private JTextField textField_2; // 源码2输入框
	private JTextField textField_3; // 结果输出框
	private JTextField textField_u;

	public String[] Change(String s) { // 消除字符串中所有的标点符号和多余的空格
		int point = 0;
		String[] r = new String[s.length()];
		String buf = new String();
		StringBuffer buffer = new StringBuffer();

		r = s.split("\\s+");
		for (int i = 0; i < r.length; i++) {
			buffer.append(r[i]);
			buffer.append("  ");
		}
		buf = buffer.toString();
		char[] c = buf.toCharArray();
		for (int i = 0; i < c.length; i++) { // 把所有标点符号变为空格
			if (c[i] == '`' || c[i] == '~' || c[i] == '!' || c[i] == '@' || c[i] == '#' || c[i] == '$' || c[i] == '%'
					|| c[i] == '^' || c[i] == '&' || c[i] == '*' || c[i] == '(' || c[i] == ')' || c[i] == '-'
					|| c[i] == '=' || c[i] == '+' || c[i] == '[' || c[i] == ']' || c[i] == '{' || c[i] == '}'
					|| c[i] == '\\' || c[i] == '|' || c[i] == ';' || c[i] == ':' || c[i] == '\'' || c[i] == '"'
					|| c[i] == ',' || c[i] == '<' || c[i] == '.' || c[i] == '>' || c[i] == '/' || c[i] == '?') {
				c[i] = ' ';
			}
		}
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				continue;
			} else {
				point = i;
				break;
			}
		}
		char[] c1 = new char[c.length - point]; // 把第一个非空格字符前的所有空格去掉
		for (int i = 0; i < c1.length; i++) {
			c1[i] = c[i + point];
		}
		buffer = new StringBuffer();
		for (int i = 0; i < c1.length; i++) {
			buffer.append(c1[i]);
		}
		buf = buffer.toString();
		r = buf.split("\\s+"); // 去掉多余的空格，确保每个字符间只有一个空格
		return r;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window(); // 创建主窗口
					frame.setLocationRelativeTo(null); // 让主窗口在屏幕中间
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); // 在命令行打印异常信息在程序中出错的位置及原因
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setTitle("源码相似性检验");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1315, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(603, 489, 97, 23);
		contentPane.add(btnNewButton);

		JTextArea textArea = new JTextArea(); // 关键字输入窗口
		JScrollPane pane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setBounds(10, 40, 618, 115);
		contentPane.add(pane);

		JTextArea textArea_u = new JTextArea(); // 用户表示符输入窗口
		JScrollPane pane_u = new JScrollPane(textArea_u, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane_u.setBounds(673, 40, 618, 115);
		contentPane.add(pane_u);

		JTextArea textArea_1 = new JTextArea(); // 源码1输入窗口
		JScrollPane pane1 = new JScrollPane(textArea_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane1.setBounds(10, 189, 618, 290);
		contentPane.add(pane1);

		JTextArea textArea_2 = new JTextArea(); // 源码2输入窗口
		JScrollPane pane2 = new JScrollPane(textArea_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane2.setBounds(673, 189, 618, 290);
		contentPane.add(pane2);

		JTextArea textArea_3 = new JTextArea(); // 结果输出窗口
		textArea_3.setEditable(false);
		JScrollPane pane3 = new JScrollPane(textArea_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane3.setBounds(10, 522, 1281, 104);
		contentPane.add(pane3);

		textField = new JTextField();
		textField.setBackground(Color.PINK);
		textField.setEditable(false);
		textField.setFont(new Font("宋体", Font.PLAIN, 22));
		textField.setText("关键字输入");
		textField.setBounds(10, 2, 123, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_u = new JTextField();
		textField_u.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_u.setText("用户标识符输入");
		textField_u.setEditable(false);
		textField_u.setBackground(Color.PINK);
		textField_u.setBounds(1127, 2, 164, 28);
		contentPane.add(textField_u);
		textField_u.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.ORANGE);
		textField_1.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_1.setText("源码1输入");
		textField_1.setEditable(false);
		textField_1.setBounds(10, 158, 123, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_2.setBackground(Color.ORANGE);
		textField_2.setText("源码2输入");
		textField_2.setBounds(1175, 158, 116, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBackground(Color.YELLOW);
		textField_3.setFont(new Font("宋体", Font.PLAIN, 22));
		textField_3.setText("源码关键字频度及相似性");
		textField_3.setBounds(10, 489, 256, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					double distance = 0, distance_u = 0; // 源码1和源码2的“相对距离” 关键字和用户标识符的
					double[] data1, data2, data1_u, data2_u; // 存源码1和源码2基于关键字的value值和基于用户标识符的value值
					String in = new String(), in_u = new String(), buf = new String(), input1 = new String(),
							input2 = new String();// 关键字输入in、用户标识符输入in_u、临时用的缓存、源码1输入input1,源码2输入input2
					String[] library = null, library_u = null, library1 = null, library2 = null; // 存关键字，用户标识符，源码1，源码2的string数组
					StringBuffer buffer = new StringBuffer(); // string的中介
					HashList list = new HashList(), list_u = new HashList(), list1 = new HashList(),
							list2 = new HashList(), list1_u = new HashList(), list2_u = new HashList(); // 关键字、用户标识符、源码1和源码2分别关于关键字和用户标识符的hash表
					int num = 0, num_u = 0; // 关键字和用户标识符的个数

					try {
						in = textArea.getText(); // 关键字的输入
						library = Change(in);
						for (int i = 0; i < library.length; i++) { // 创建关键字的hash表
							buffer = new StringBuffer();
							buffer.append(library[i]);
							buf = buffer.toString();
							if (list.Hash(buf) >= 0 && list.Hash(buf) < 63) {
								list.Insert(buf);
								list1.Insert(buf);
								list1.Reduce(buf);
								list2.Insert(buf);
								list2.Reduce(buf);
								num++;
							}
						}
					} catch (Exception e2) { // 关键码输入异常
						// TODO: handle exception
						Warning warn = new Warning();
						warn.setTitle("关键码输入错误");
						warn.setLocationRelativeTo(null);
						warn.setVisible(true);
					}

					try {
						in_u = textArea_u.getText(); // 用户标识符的输入
						library_u = Change(in_u);
						for (int i = 0; i < library_u.length; i++) { // 创建用户标识符的hash表
							buffer = new StringBuffer();
							buffer.append(library_u[i]);
							buf = buffer.toString();
							if (list_u.Hash(buf) >= 0 && list_u.Hash(buf) < 63) {
								list_u.Insert(buf);
								list1_u.Insert(buf);
								list1_u.Reduce(buf);
								list2_u.Insert(buf);
								list2_u.Reduce(buf);
								num_u++;
							}
						}
					} catch (Exception e2) { // 用户标识符输入异常
						// TODO: handle exception
						Warning warn_u = new Warning();
						warn_u.setTitle("用户标识符输入错误");
						warn_u.setLocationRelativeTo(null);
						warn_u.setVisible(true);
					}

					data1 = new double[num];
					data1_u = new double[num_u];
					try {
						input1 = textArea_1.getText(); // 源码1的输入
						library1 = Change(input1);

						for (int i = 0; i < library1.length; i++) { // 创建源码1基于关键字的hash表
							for (int j = 0; j < num; j++) {
								if (library[j].equals(library1[i]) == true) {
									list1.Insert(library1[i]);
									break;
								}
							}
						}

						for (int i = 0; i < library1.length; i++) { // 创建源码1基于用户标识符的hash表
							for (int j = 0; j < num_u; j++) {
								if (library_u[j].equals(library1[i]) == true) {
									list1_u.Insert(library1[i]);
									break;
								}
							}
						}

						for (int i = 0; i < num; i++) { // 获取源码1基于关键字hash表中所有的value
							data1[i] = list1.GetValue(library[i]);
						}

						for (int i = 0; i < num_u; i++) { // 获取源码1基于用户标识符hash表中所有的value
							data1_u[i] = list1_u.GetValue(library_u[i]);
						}
					} catch (Exception e2) { // 源码一输入异常
						// TODO: handle exception
						Warning warn1 = new Warning();
						warn1.setTitle("源码1输入错误");
						warn1.setLocationRelativeTo(null);
						warn1.setVisible(true);
					}

					data2 = new double[num];
					data2_u = new double[num_u];
					try {
						input2 = textArea_2.getText(); // 源码2的输入
						library2 = Change(input2);

						for (int i = 0; i < library2.length; i++) { // 创建源码2基于关键字的hash表
							for (int j = 0; j < num; j++) {
								if (library[j].equals(library2[i]) == true) {
									list2.Insert(library2[i]);
									break;
								}
							}
						}

						for (int i = 0; i < library2.length; i++) { // 创建源码2基于用户标识符的hash表
							for (int j = 0; j < num_u; j++) {
								if (library_u[j].equals(library2[i]) == true) {
									list2_u.Insert(library2[i]);
									break;
								}
							}
						}

						for (int i = 0; i < num; i++) { // 获取源码2基于关键字hash表中所有的value
							data2[i] = list2.GetValue(library[i]);
						}

						for (int i = 0; i < num_u; i++) { // 获取源码2基于用户标识符hash表中所有的value
							data2_u[i] = list2_u.GetValue(library_u[i]);
						}
					} catch (Exception e2) { // 源码二输入异常
						// TODO: handle exception
						Warning warn2 = new Warning();
						warn2.setTitle("源码2输入错误");
						warn2.setLocationRelativeTo(null);
						warn2.setVisible(true);
					}

					for (int i = 0; i < num; i++) { // 计算源码1和源码2基于关键字的“相对距离”
						distance += Math.pow(data1[i] - data2[i], 2);
					}
					distance = Math.sqrt(distance);

					for (int i = 0; i < num_u; i++) { // 计算源码1和源码2基于用户标识符的“相对距离”
						distance_u += Math.pow(data1_u[i] - data2_u[i], 2);
					}
					distance_u = Math.sqrt(distance_u);

					textArea_3.setText("");

					buffer = new StringBuffer(); // 输出关键字列表
					buffer.append("关键字 :	");
					for (int i = 0; i < num; i++) {
						buffer.append("	");
						buffer.append(library[i]);
					}
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出源码1的关键字的频度
					buffer.append("源码1关键字频度");
					for (int i = 0; i < num; i++) {
						buffer.append("	");
						buffer.append(list1.GetValue(library[i]));
					}
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出源码2的关键字频度
					buffer.append("源码2关键字频度");
					for (int i = 0; i < num; i++) {
						buffer.append(" 	");
						buffer.append(list2.GetValue(library[i]));
					}
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出源码1和源码2基于关键字的“相对距离”
					buffer.append("源码1和源码2基于关键字的“相对距离” ：   ");
					buffer.append(distance);
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出用户标识符列表
					buffer.append("用户标识符 :	");
					for (int i = 0; i < num_u; i++) {
						buffer.append("	");
						buffer.append(library_u[i]);
					}
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出源码1的用户标识符的频度
					buffer.append("源码1用户标识符频度");
					for (int i = 0; i < num_u; i++) {
						buffer.append("	");
						buffer.append(list1_u.GetValue(library_u[i]));
					}
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出源码2的用户标识符频度
					buffer.append("源码2用户标识符频度");
					for (int i = 0; i < num_u; i++) {
						buffer.append(" 	");
						buffer.append(list2_u.GetValue(library_u[i]));
					}
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");

					buffer = new StringBuffer(); // 输出源码1和源码2基于用户标识符的“相对距离”
					buffer.append("源码1和源码2基于用户标识符的“相对距离” ：   ");
					buffer.append(distance_u);
					buf = buffer.toString();
					textArea_3.replaceSelection(buf);
					textArea_3.replaceSelection("\n");
				} catch (Exception e2) {
					// TODO: handle exception
					Warning warn3 = new Warning();
					warn3.setTitle("输入错误");
					warn3.setLocationRelativeTo(null);
					warn3.setVisible(true);
					e2.printStackTrace();
				}
			}
		});
	}
}