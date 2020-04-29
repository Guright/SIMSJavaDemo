package First;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import First.Window;

public class Look extends JFrame {

	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";
	String USER = "root";
	String PASS = "l1551abcde0asdwx";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet res = null;

	JButton buttonlook = new JButton("浏览");
	JButton buttonreturn = new JButton("返回");

	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();

	Vector columnNames = null;
	Vector rowData = null;

	public Look() {
		JPanel jpforbutton = new JPanel(new GridLayout(1, 1));

		columnNames = new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("出生时间");
		columnNames.add("性别");
		columnNames.add("数学成绩");
		columnNames.add("英语成绩");
		columnNames.add("数据结构成绩");
		rowData = new Vector();
		buttonlook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		jpforbutton.add(buttonlook);
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		jpforbutton.add(buttonreturn);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			ps = conn.prepareStatement("SELECT * FROM student");
			res = ps.executeQuery();
			while (res.next()) {
				Vector hang = new Vector();
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				hang.add(res.getString(3));
				hang.add(res.getString(4));
				hang.add(res.getString(5));
				hang.add(res.getString(6));
				hang.add(res.getString(7));
				rowData.add(hang);

			}
			System.out.println("成功载入");
		} catch (Exception q) {
			q.printStackTrace();
			System.out.println("失败");
		} finally {
			try {
				res.close();
				ps.close();
				conn.close();
				System.out.println("成功关闭");
			} catch (SQLException o) {
				o.printStackTrace();
				System.out.println("关闭失败");
			}
		}

		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);

		getContentPane().add(jscrollpane);
		this.setTitle("浏览学生信息");
		getContentPane().setLayout(new GridLayout(2, 5));
		getContentPane().add(jpforbutton);
		this.setLocation(300, 300);
		this.setSize(500, 300);
		this.setVisible(true);
		this.setResizable(false);

	}

}