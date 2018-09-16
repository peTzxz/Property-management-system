//
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
public class User_PriceStandard  extends Log_In implements ActionListener {

	JFrame f = new JFrame("当月物业单价查询");
	JButton b2 = new JButton("查询");
	JButton b3 = new JButton("返回");
	String[] cloum = { "编号", "水单价", "电单价","燃气单价","开始时间"};
	Object[][] row = new Object[50][5];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		table.setPreferredScrollableViewportSize(new Dimension(400,300));
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b2);
		p1.add(b3);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		JPanel p3 = new JPanel();
		p.setLayout(new FlowLayout());
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.CYAN);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setBounds(100, 100, 550, 550);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
public void actionPerformed(ActionEvent e) {

		if (b2.equals(e.getSource())) {// 查询个人工资
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("数据库连接失败" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b2.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j <5; j++)
							table.setValueAt("", i, j);
					rs =sql.executeQuery("select  * from  PriceStandard;");
					int k = -1;
					while (rs.next()) {
                            ++k;
                        	String get_String=rs.getString(1);
                        	table.setValueAt(get_String, k,0);
                        	float get_Float=rs.getFloat(2);
                        	table.setValueAt(String.valueOf(get_Float), k,1);
                        	get_Float=rs.getFloat(3);
                        	table.setValueAt(String.valueOf(get_Float), k,2);
                        	get_Float=rs.getFloat(4);
                        	table.setValueAt(String.valueOf(get_Float), k,3);
                        	get_String=rs.getString(5);
                        	table.setValueAt(get_String, k,4);
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}
		if (b3.equals(e.getSource())) {
			User_Feature_Selection dl=new User_Feature_Selection();
			dl.create();
			f.dispose();

		}
	}
}