package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import com.mysql.jdbc.Driver;

public class Add extends JFrame {

	JLabel jlnumber = new JLabel("学号：");
	JLabel jlname = new JLabel("姓名：");
	JLabel jlage = new JLabel("\u51FA\u751F\u65F6\u95F4\uFF1A");
	JLabel jlsex = new JLabel("\u6027\u522B\uFF1A");
	JLabel jlmath = new JLabel("\u6570\u5B66\u6210\u7EE9\uFF1A");

	JTextField jtnumber = new JTextField("", 20);
	JTextField jtname = new JTextField("", 20);
	JTextField jtage = new JTextField("", 20);
	JTextField jtsex = new JTextField("", 20);
	JTextField jtmath = new JTextField("", 20);

	JButton buttonadd = new JButton("添加");
	JButton buttonreturn = new JButton("返回");
	private final JTextField jtenglish = new JTextField();
	private final JLabel jlenglish = new JLabel("     \u82F1\u8BED\u6210\u7EE9\uFF1A");
	private final JLabel jldata = new JLabel("\u6570\u636E\u7ED3\u6784\u6210\u7EE9:");
	private final JTextField jtdata = new JTextField();

	public Add() {
		jtdata.setBounds(178, 176, 130, 21);
		jtdata.setColumns(10);
		jtenglish.setBounds(137, 153, 125, 21);
		jtenglish.setColumns(10);
		JPanel jpnumber = new JPanel();
		jpnumber.setBounds(0, 1, 336, 29);
		JPanel jpname = new JPanel();
		jpname.setBounds(0, 30, 336, 29);
		JPanel jpage = new JPanel();
		jpage.setBounds(0, 59, 336, 29);
		JPanel jpsex = new JPanel();
		jpsex.setBounds(0, 88, 336, 29);
		JPanel jpmath = new JPanel();
		jpmath.setBounds(0, 117, 336, 29);

		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);

		jpname.add(jlname);
		jpname.add(jtname);

		jpage.add(jlage);
		jpage.add(jtage);

		jpsex.add(jlsex);
		jpsex.add(jtsex);

		jpmath.add(jlmath);
		jpmath.add(jtmath);

		this.setTitle("添加学生信息");
		getContentPane().setLayout(null);
		getContentPane().add(jpnumber);
		getContentPane().add(jpname);
		getContentPane().add(jpage);
		getContentPane().add(jpsex);
		getContentPane().add(jpmath);

		buttonadd.setBounds(0, 224, 168, 29);
		getContentPane().add(buttonadd);
		buttonreturn.setBounds(168, 224, 168, 29);
		getContentPane().add(buttonreturn);

		getContentPane().add(jtenglish);
		jlenglish.setBounds(41, 156, 98, 15);

		getContentPane().add(jlenglish);
		jldata.setBounds(51, 179, 117, 15);

		getContentPane().add(jldata);

		getContentPane().add(jtdata);

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		buttonadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
				String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
				String USER = "root";
				String PASS = "l1551abcde0asdwx";

				// Add
				Connection conn = null;
				Statement stat = null;
				PreparedStatement ps = null;
				try {
					Class.forName(JDBC_DRIVER);

					// 打开链接
					System.out.println("连接数据库...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					// 执行查询
					stat = conn.createStatement();
					String sql = "INSERT INTO student(sno,name,age,sex,math,english,data) " + "values(?,?,?,?,?,?,?)";
					ps = conn.prepareStatement(sql);

					ps.setString(1, jtnumber.getText());
					ps.setString(2, jtname.getText());
					ps.setString(3, jtage.getText());
					ps.setString(4, jtsex.getText());
					ps.setString(5, jtmath.getText());
					ps.setString(6, jtenglish.getText());
					ps.setString(7, jtdata.getText());

					ps.executeUpdate();

					System.out.println("MySQL 连接成功!");
					stat = conn.createStatement();
					stat.executeUpdate(sql);
					System.out.println("插入数据成功!");

				} catch (SQLException b) {
					b.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conn.close();
						System.out.println("MySQL 关闭成功");
					} catch (SQLException c) {
						System.out.println("MySQL 关闭失败 ");
						c.printStackTrace();
					}
				}
			}
		});
		this.setLocation(400, 300);
		this.setSize(350, 300);
		this.setVisible(true);
	}
}