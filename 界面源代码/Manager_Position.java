//
import java.awt.Color;
import java.awt.FlowLayout;
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
public class Manager_Position extends JFrame implements ActionListener {

	JFrame f = new JFrame("职务");
	JButton b1 = new JButton("删除某一职务");
	JButton b2 = new JButton("增添某一职务");
	JButton b3 = new JButton("查询某一职务");
	JButton b4 = new JButton("查询所有职务");
	JButton b5 = new JButton("返回");
	JTextField tf1 = new JTextField(30);
	JTextField tf2 = new JTextField(30);
	JTextField tf3 = new JTextField(10);
	String[] cloum = { "行政职务", "专业技术职务", "住房级别"};
	Object[][] row = new Object[50][3];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		JPanel p3 = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("行政职务"));
		p.add(tf1);
		p.add(new JLabel("专业技术职务"));
		p.add(tf2);
		p.add(new JLabel("住房级别"));
		p.add(tf3);
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(55);
		p.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(200, 100, 500, 600);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b2.equals(e.getSource())) { // 录入
			Connection con;
			Statement sql;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement();
				String insertStr = "INSERT INTO HousingLevel (APosition,PTPosition,Class) VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"');";
				sql.executeUpdate(insertStr);
				con.close();
				JOptionPane.showMessageDialog(this, "入录成功！");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "入录失败！");
			}
		}
		

		if (b1.equals(e.getSource())) {// 删除
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM HousingLevel  where  APosition='"+tf1.getText()+"' and  PTPosition='"+tf2.getText()+"';");
				JOptionPane.showMessageDialog(this, "删除成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "删除失败！");
			}

		}
		if (b3.equals(e.getSource())) {// 查询全部
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
				if (b3.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 3; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select HousingLevel.APosition,HousingLevel.PTPosition,Class from HousingLevel  where HousingLevel.APosition='"+tf1.getText()+"'and HousingLevel.PTPosition='"+tf2.getText()+"';");
					int k = -1;
					while (rs.next()) {

						++k;
					for(int i=1;i<=3;i++)
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
						for (int j = 0; j < 3; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select APosition,PTPosition,Class from HousingLevel ;");
					int k = -1;
					while (rs.next()) {

						++k;
					for(int i=1;i<=3;i++)
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

		if (b5.equals(e.getSource())) {// 返回
			Manager_WorkInformation gl=new Manager_WorkInformation();
			gl.create();
			f.dispose();

		}
	}
}