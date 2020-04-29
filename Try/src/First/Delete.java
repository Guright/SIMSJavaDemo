package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import First.Window;

public class Delete extends JFrame {

	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
	String USER = "root";
	String PASS = "l1551abcde0asdwx";

	JLabel jlnumber = new JLabel("学号：");

	JTextField jtnumber = new JTextField("", 20);

	JButton buttondelete = new JButton("删除");
	JButton buttonreturn = new JButton("返回");

	public Delete() {
		JPanel jpnumber = new JPanel();
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);

		jpforbutton.add(buttondelete);
		jpforbutton.add(buttonreturn);

		buttondelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = jtnumber.getText();

				Connection conn = null;
				ResultSet res = null;
				Statement stat = null;
				String sql = "DELETE FROM student WHERE sno='" + number + "'";

				try {
					Class.forName(JDBC_DRIVER);
				} catch (Exception a) {
					a.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					stat = conn.createStatement();
					stat.executeUpdate(sql);
				} catch (SQLException h) {
					h.printStackTrace();

				} finally {
					try {
						conn.close();
						System.out.println("关闭成功!");
					} catch (SQLException j) {
						System.out.println("关闭失败!");
						j.printStackTrace();
					}
				}
			}
		});

		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.setTitle("删除学生信息");
		this.setLayout(new GridLayout(9, 1));
		this.add(jpnumber);
		this.add(jpforbutton);
		this.setLocation(400, 300);
		this.setSize(350, 300);
		this.setVisible(true);
	}
}