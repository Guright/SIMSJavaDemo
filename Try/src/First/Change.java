package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import First.Window;

public class Change extends JFrame {

	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
	String USER = "root";
	String PASS = "l1551abcde0asdwx";

	JLabel jlnumber = new JLabel("学号：");
	JLabel jlname = new JLabel("姓名：");
	JLabel jlage = new JLabel("\u51FA\u751F\u65F6\u95F4\uFF1A");
	JLabel jlsex = new JLabel("性别：");
	JLabel jlmath = new JLabel("数学成绩：");
	JLabel jlenglish = new JLabel("\u82F1\u8BED\u6210\u7EE9\uFF1A");
	JLabel jldata = new JLabel("\u6570\u636E\u7ED3\u6784\u6210\u7EE9\uFF1A");

	JTextField jtnumber = new JTextField("", 20);
	JTextField jtname = new JTextField("", 20);
	JTextField jtage = new JTextField("", 20);
	JTextField jtsex = new JTextField("", 20);
	JTextField jtmath = new JTextField("", 20);
	JTextField jtenglish = new JTextField();
	JTextField jtdata = new JTextField();

	JButton buttonchange = new JButton("修改");
	JButton buttonreturn = new JButton("返回");
	JPanel jpenglish = new JPanel();
	JPanel jpdata = new JPanel();

	public Change() {
		jtdata.setBounds(169, 7, 113, 21);
		jtdata.setColumns(10);
		jtenglish.setBounds(174, 7, 115, 21);
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

		jpenglish.add(jlenglish);
		jpenglish.add(jtenglish);

		jpdata.add(jldata);
		jpdata.add(jtdata);

		this.setTitle("修改学生信息");
		getContentPane().setLayout(null);
		getContentPane().add(jpnumber);
		getContentPane().add(jpname);
		getContentPane().add(jpage);
		getContentPane().add(jpsex);
		getContentPane().add(jpmath);
		buttonchange.setBounds(0, 224, 168, 29);
		getContentPane().add(buttonchange);
		buttonreturn.setBounds(168, 224, 168, 29);
		getContentPane().add(buttonreturn);
		jpenglish.setBounds(0, 146, 336, 29);

		getContentPane().add(jpenglish);
		jpenglish.setLayout(null);
		jlenglish.setBounds(73, 10, 67, 15);

		jpenglish.add(jlenglish);

		jpenglish.add(jtenglish);
		jpdata.setBounds(0, 173, 336, 29);

		getContentPane().add(jpdata);
		jpdata.setLayout(null);
		jldata.setBounds(68, 10, 91, 15);

		jpdata.add(jldata);

		jpdata.add(jtdata);

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		buttonchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = jtnumber.getText();
				String name = jtname.getText();
				String age = jtage.getText();
				String sex = jtsex.getText();
				String math = jtmath.getText();
				String english = jtenglish.getText();
				String data = jtdata.getText();

				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;

				String sql = "SELECT sno,name,age,sex,math,english,data FROM student;";
				try {
					Class.forName(JDBC_DRIVER);

				} catch (Exception d) {
					System.out.println("连接失败");
					d.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stat = conn.createStatement();
					res = stat.executeQuery(sql);
					while (res.next()) {
						// change
						if (res.getString(1).equals(jtnumber.getText())) {
							try {
								Class.forName(JDBC_DRIVER);
							} catch (Exception d) {
								System.out.println("连接失败");
								d.printStackTrace();
							}

							String sql2 = "UPDATE student SET name='" + name + "'  WHERE sno='" + jtnumber.getText()
									+ "'";
							String sql3 = "UPDATE student SET age='" + age + "'  WHERE sno='" + jtnumber.getText()
									+ "'";
							String sql4 = "UPDATE student SET sex='" + sex + "'  WHERE sno='" + jtnumber.getText()
									+ "'";
							String sql5 = "UPDATE student SET math='" + math + "'  WHERE sno='" + jtnumber.getText()
									+ "'";
							String sql6 = "UPDATE student SET english='" + english + "'  WHERE sno='"
									+ jtnumber.getText() + "'";
							String sql7 = "UPDATE student SET data='" + data + "'  WHERE sno='" + jtnumber.getText()
									+ "'";
							try {
								conn = DriverManager.getConnection(DB_URL, USER, PASS);
								stat = conn.createStatement();
								stat.executeUpdate(sql2);
								stat.executeUpdate(sql3);
								stat.executeUpdate(sql4);
								stat.executeUpdate(sql5);
								stat.executeUpdate(sql6);
								stat.executeUpdate(sql7);
							} catch (SQLException g) {
								// TODO Auto-generated catch block
								g.printStackTrace();
							}
							try {
								stat.close();
								conn.close();
							} catch (SQLException ar) {
								ar.printStackTrace();
							}
							break;
						}
						// change end
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException ar) {
						ar.printStackTrace();
					}
				}
			}
		});
		this.setLocation(400, 300);
		this.setSize(350, 300);
		this.setVisible(true);

	}

}