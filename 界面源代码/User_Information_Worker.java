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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
public class User_Information_Worker extends Log_In implements ActionListener {

	JFrame f = new JFrame("个人信息查询");
	JButton b2 = new JButton("查询");
	JButton b3 = new JButton("返回");
	String[] cloum = { "职工号", "姓名", "性别","参加工作时间","行政职务","专业技术职务","评上最高行政职务时间","评上最高专业技术服务时间","双职工姓名","现居住房号","档案号","所在部门号","是否为户主"};
	Object[][] row = new Object[50][13];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		table.setPreferredScrollableViewportSize(new Dimension(1000,450));
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
		f.setBounds(100, 100, 1050, 500);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
public void actionPerformed(ActionEvent e) {

		if (b2.equals(e.getSource())) {// 查询个人工资
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDrive");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b2.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 13; j++)
							table.setValueAt("", i, j);
					//System.out.println(t1);
					rs = sql.executeQuery("select  * from  Worker  where   Worker.Dno='"+t1+"'");
					int k = -1;
					while (rs.next()) {
                        for(int i=1;i<=13;i++)
                        {
                        	String get_String=rs.getString(i);
                        	table.setValueAt(get_String, 0, i-1);
                        }
		
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}
		if (b3.equals(e.getSource())) {// 返回
			User_Feature_Selection dl=new User_Feature_Selection();
			dl.create();
			f.dispose();

		}
	}
}