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
public class Manager_Property_Selection extends JFrame implements ActionListener {
    float A,B,C,D,E,F;
	JFrame f = new JFrame("历史物业查询");
	JButton b1 = new JButton("确定");
	JButton b2 = new JButton("返回");  
	JTextField tf1 = new JTextField(6);
	JTextField tf2 = new JTextField(8);
	JTextField tf3 = new JTextField(8);
	String[] cloum = { "房号", "水基数", "水现在值", "电基数", "电现在值", "燃气基数", "燃气现在值", "年份", "月份", "本月水费用", "本月电费用", "本月燃气费用", "总物业费用"};
	Object[][] row = new Object[50][13];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("房号"));
		p.add(tf1);
		p.add(new JLabel("年份"));
		p.add(tf2);
		p.add(new JLabel("月份"));
		p.add(tf3);
		p1.add(b1);
		p1.add(b2);
		
		splitpane.add(p1, splitpane.TOP);
		splitpane.add(p2, splitpane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setBounds(100, 100, 500, 600);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		if (b1.equals(e.getSource())) {
			Connection con;
			Statement sql,sql1;
			ResultSet rs,rs1;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e1) {
				System.out.println("数据库连接失败"+e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b1.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j <13; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select  * from  Property  where Hno='"+tf1.getText()+"'and NowYears='"+tf2.getText()+"' and NowMonths='"+tf3.getText()+"';");
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
					rs1=sql1.executeQuery("select * from  PriceStandard  where  PriceStandard.StartTime=(select MAX(PriceStandard.StartTime) from PriceStandard);");
					while (rs1.next()) 
					{
					 D=rs1.getFloat("WaterPrice");
					 E=rs1.getFloat(3);
					 F=rs1.getFloat(4);
					 A=A*D;
					 B=B*E;
					 C=C*F;
					 table.setValueAt(String.valueOf(A),0,9);
					 table.setValueAt(String.valueOf(B),0,10);
					 table.setValueAt(String.valueOf(C),0,11);
					 C=A+B+C;
					 table.setValueAt(String.valueOf(C),0,12);
					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}
		
		if (b2.equals(e.getSource())) {// 返回
			Manager_Property gl=new Manager_Property();
			gl.create();
			f.dispose();

		}
	}
}

 