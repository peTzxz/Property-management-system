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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
public class User_NowProperty extends Log_In implements ActionListener {
	float A,B,C;
	JFrame f = new JFrame("物业查询");
	JButton b2 = new JButton("查询");
	JButton b3 = new JButton("返回");
	JTextField tf1 = new JTextField(6);
	JTextField tf2 = new JTextField(8);
	String[] cloum = { "房号", "水基数", "水现在值","电基数","电现在值", "燃气基数", "燃气现在值", "年份", "月份","电费","水费","燃气费","物业总费用"};
	Object[][] row = new Object[50][13];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		table.setPreferredScrollableViewportSize(new Dimension(1000,300));
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b2);
		p1.add(b3);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		p.setLayout(new FlowLayout());
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.CYAN);
		p.add(new JLabel("年份"));
		p.add(tf1);
		p.add(new JLabel("月份"));
		p.add(tf2);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setBounds(100, 100, 1050,500);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
public void actionPerformed(ActionEvent e) {
		if (b2.equals(e.getSource())) {
			Connection con;
			Statement sql,sql1;
			ResultSet rs,rs1;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDrive");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b2.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j <13; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select  * from  Property  where NowYears='"+tf1.getText()+"'and NowMonths='"+tf2.getText()+"' and Hno=( select Hno  from Worker where Worker.Dno='"+t1+"');");
					while (rs.next()) 
					{
                        for(int i=1;i<=9;i++)
                        {   
                        	String get_String=rs.getString(i);
                        	table.setValueAt(get_String, 0, i-1);
                        }
                        A=rs.getFloat(3)-rs.getFloat(2);
                        B=rs.getFloat(5)-rs.getFloat(4);
                        C=rs.getFloat(7)-rs.getFloat(6);
					   }
					rs1 = sql1.executeQuery("select  * from  PriceStandard  where  PriceStandard.StartTime= (select MAX(PriceStandard.StartTime) from PriceStandard);");
					while (rs1.next()) 
					{
					 float D=rs1.getFloat(2);
					 float E=rs1.getFloat(3);
					 float F=rs1.getFloat(4);
					 D=A*D;
					 E=B*E;
					 F=C*F;
					 table.setValueAt(String.valueOf(D), 0, 9);
					 table.setValueAt(String.valueOf(E), 0, 10);
					 table.setValueAt(String.valueOf(F), 0, 11);
					 D=D+E+F;
					 table.setValueAt(String.valueOf(D), 0, 12);
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