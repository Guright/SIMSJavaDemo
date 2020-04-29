package First;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Window extends JFrame {

	/**
		 * 
		 */
	private static final long serialVersionUID = 4084829285679680408L;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/student?useSSL=false&serverTimezone=UTC";

//	数据库的用户名与密码，需要根据自己的设置
	static final String USER = "root";
	static final String PASS = "l1551abcde0asdwx";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection conn = null;
					Statement stmt = null;
					// 注册 JDBC 驱动
					Class.forName(JDBC_DRIVER);

					// 打开链接
					System.out.println("连接数据库...");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 600, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("\u4FE1\u606F\u5F55\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add f = new Add();
				f.setSize(400, 300);
//				JLabel label = new JLabel("我是新窗口");
//				f.add(label);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton.setBounds(90, 129, 120, 28);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u4FE1\u606F\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete f = new Delete();
				f.setSize(400, 300);
//				JLabel label = new JLabel("我是新窗口");
//				f.add(label);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(382, 129, 120, 28);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u67E5\u627E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ask f = new Ask();
				f.setSize(400, 300);
//				JLabel label = new JLabel("我是新窗口");
//				f.add(label);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(90, 181, 120, 28);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u6D4F\u89C8");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Look f = new Look();
//				f.setSize(400, 300);
//				JLabel label = new JLabel("我是新窗口");
//				f.add(label);
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(382, 183, 120, 25);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u4FE1\u606F\u4FEE\u6539");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change f = new Change();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(90, 237, 120, 23);
		contentPane.add(btnNewButton_4);

		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(198, 37, 197, 43);
		contentPane.add(lblNewLabel);
	}
}
