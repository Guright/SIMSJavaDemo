package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import First.Window;

public class Ask extends JFrame {

	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
	String USER = "root";
	String PASS = "l1551abcde0asdwx";

	JLabel jlnumber = new JLabel("学号：");
	JLabel jlname = new JLabel("姓名：");
	JLabel jlage = new JLabel("\u51FA\u751F\u65F6\u95F4\uFF1A");
	JLabel jlsex = new JLabel("性别：");
	JLabel jlmath = new JLabel("\u6570\u5B66\uFF1A");
	JLabel jlenglish = new JLabel("\u82F1\u8BED\uFF1A");
	JLabel jldata = new JLabel("\u6570\u636E\u7ED3\u6784\uFF1A");

	JTextField jtnumber = new JTextField("", 20);
	JLabel jname = new JLabel();
	JLabel jage = new JLabel();
	JLabel jsex = new JLabel();
	JLabel jmath = new JLabel();
	JLabel jenglish = new JLabel();
	JLabel jdata = new JLabel();

	JButton buttonask = new JButton("查询");
	JButton buttonreturn = new JButton("返回");
	private final JPanel jpenglish = new JPanel();
	private final JPanel jpdata = new JPanel();

	public Ask() {
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
		jpname.add(jname);

		jpage.add(jlage);
		jpage.add(jage);

		jpsex.add(jlsex);
		jpsex.add(jsex);

		jpmath.add(jlmath);
		jpmath.add(jmath);

		jpenglish.add(jlenglish);
		jpenglish.add(jenglish);
		jpenglish.setBounds(0, 146, 336, 22);

		jpdata.setBounds(0, 166, 336, 22);
		jpdata.add(jldata);
		jpdata.add(jdata);

		this.setTitle("查询学生信息");
		getContentPane().setLayout(null);
		getContentPane().add(jpnumber);
		getContentPane().add(jpname);
		getContentPane().add(jpage);
		getContentPane().add(jpsex);
		getContentPane().add(jpmath);
		buttonask.setBounds(0, 224, 168, 29);
		getContentPane().add(buttonask);
		buttonreturn.setBounds(168, 224, 168, 29);
		getContentPane().add(buttonreturn);

		getContentPane().add(jpenglish);

		getContentPane().add(jpdata);

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		buttonask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;

				String sql = "SELECT sno,name,age,sex,math,english,data FROM student;";
				try {
					Class.forName(JDBC_DRIVER);

				} catch (Exception d) {
					System.out.println("载入失败");
					d.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stat = conn.createStatement();
					res = stat.executeQuery(sql);
					while (res.next()) {
						if (res.getString(1).equals(jtnumber.getText())) {
							jname.setText(res.getString(2));
							jage.setText(res.getString(3));
							jsex.setText(res.getString(4));
							jmath.setText(res.getString(5));
							jenglish.setText(res.getString(6));
							jdata.setText(res.getString(7));

							break;
						}
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