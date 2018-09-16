//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class Manager_Worker extends JFrame implements ActionListener {
	JFrame f = new JFrame("职工管理");
	JButton b1 = new JButton("添加新员工信息");
	JButton b2 = new JButton("修改员工信息");
	JButton b3 = new JButton("删除员工信息");
	JButton b4 = new JButton("查询某一员工信息");
	JButton b5 = new JButton("查询所有员工信息");
	JButton b6 = new JButton("返回");
	JTextField tf1 = new JTextField(6);
	JTextField tf2 = new JTextField(8);
	JTextField tf3 = new JTextField(8);
	JTextField tf4 = new JTextField(8);
	JTextField tf5 = new JTextField(8);
	JTextField tf6 = new JTextField(10);
	JTextField tf7 = new JTextField(10);
	JTextField tf8 = new JTextField(10);
	JTextField tf9 = new JTextField(10);
	JTextField tf10 = new JTextField(10);
	JTextField tf11 = new JTextField(10);
	JTextField tf12 = new JTextField(10);
	JTextField tf13 = new JTextField(10);
	String[] cloum = { "职工号", "姓名", "性别","参加工作时间","行政职务","专业技术职务","评上最高行政职务时间","评上最高专业技术服务时间","双职工姓名","现居住房号","档案号","所在部门号","是否为户主"};
	Object[][] row = new Object[50][13];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		table.setPreferredScrollableViewportSize(new Dimension(800,400));
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("职工号"));
		p.add(tf1);
		p.add(new JLabel("姓名"));
		p.add(tf2);
		p.add(new JLabel("性别"));
		p.add(tf3);
		p.add(new JLabel("参加工作时间"));
		p.add(tf4);
		p.add(new JLabel("行政职务"));
		p.add(tf5);
		p.add(new JLabel("专业技术职务"));
		p.add(tf6);
		p.add(new JLabel("评上最高行政职务时间"));
		p.add(tf7);
		p.add(new JLabel("评上最高专业技术职务时间"));
		p.add(tf8);
		p.add(new JLabel("双职工姓名"));
		p.add(tf9);
		p.add(new JLabel("档案号"));
		p.add(tf10);
		p.add(new JLabel("房号"));
		p.add(tf11);
		p.add(new JLabel("所在部门号"));
		p.add(tf12);
		p.add(new JLabel("是否为户主"));
		p.add(tf13);
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		f.setBounds(0, 0, 850, 700);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b1.equals(e.getSource())) { // 录入
			Connection con;
			Statement sql,sql1,sql2,sql3;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement();
				sql1 = con.createStatement();
				sql2 = con.createStatement();
				sql3 = con.createStatement();
				String insertStr = "INSERT INTO Worker (Wno,Wname,Wsex,JoinTime,Aposition,PTPosition,MaxAPTime,MaxPTPTime,DWname,Fileno,Hno,Dno,HousingHead) VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"','"+tf8.getText()+"','"+tf9.getText()+"','"+tf10.getText()+"','"+tf11.getText()+"','"+tf12.getText()+"','"+tf13.getText()+"');";
				sql.executeUpdate(insertStr);
				sql1.executeUpdate("insert into Secret (Wno,secret) values('"+tf1.getText()+"','"+tf1.getText()+"');");
				sql2.executeUpdate("update HousingSituation set NowUserID='"+tf1.getText()+"' where Hno='"+tf11.getText()+"';");
				sql3.executeUpdate("update HousingSituation set EarlistUserID='"+tf1.getText()+"' where Hno='"+tf11.getText()+"';");
				con.close();
				JOptionPane.showMessageDialog(this, "入录成功！");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "入录失败！");
			}
		}
		if (b2.equals(e.getSource())) {// 修改
			Connection con;
			Statement sql,sql4;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement();
				sql4 = con.createStatement();
				System.out.println("1");
				String updateStr = "UPDATE  Worker  SET APosition='"+tf5.getText()+"',PTPosition='"+tf6.getText()+"',MaxAPTime='"+tf7.getText()+"',MaxPTPTime='"+tf8.getText()+"',Hno='"+tf11.getText()+"',Dno='"+tf12.getText()+"',HousingHead='"+tf13.getText()+"' where Wno='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr);
				System.out.println("2");
				sql4.executeUpdate("update HousingSituation set NowUserID='"+tf1.getText()+"' where Hno='"+tf11.getText()+"';");
				System.out.println("2");
				JOptionPane.showMessageDialog(this, "修改成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "信息不存在！");
			}
		}

		if (b3.equals(e.getSource())) {
			Connection con;
			Statement sql,sql1;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM Worker  where  Wno='"+tf1.getText()+"';");
				sql1.executeUpdate("DELETE FROM Secret  where  Wno='"+tf1.getText()+"';");
				JOptionPane.showMessageDialog(this, "删除成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "删除失败！");
			}

		}
		if (b4.equals(e.getSource())) {// 查询全部
			Connection con;
			Statement sql;
			ResultSet rs;
			//Vector vector = new Vector();
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "连接数据库失败！");
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b4.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 13; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select * from Worker where Wno='"+tf1.getText()+"';");
					int k = -1;
					while (rs.next()) {

						++k;
					for(int i=1;i<=13;i++)
						{
							String get_String=rs.getString(i);
							table.setValueAt(get_String, k, i-1);
						}
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}

		if (b5.equals(e.getSource())) {// 查询全部
			Connection con;
			Statement sql;
			ResultSet rs;
			//Vector vector = new Vector();
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "连接数据库失败！");
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b5.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 13; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select * from Worker");
					int k = -1;
					while (rs.next()) {

						++k;
					for(int i=1;i<=13;i++)
						{
							String get_String=rs.getString(i);
							table.setValueAt(get_String, k, i-1);
						}
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}

		if (b6.equals(e.getSource())) {// 返回
			Manager_WorkInformation gl=new Manager_WorkInformation();
			gl.create();
			f.dispose();

		}
	}
}