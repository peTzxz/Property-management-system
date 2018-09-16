//
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.SwingConstants;
public class Manager_Property_Price extends JFrame implements ActionListener {
	JPanel jp,jp1,jp2,jp3;
	Container ct;
	JFrame f = new JFrame("单价设置");
	JButton b1 = new JButton("确定");
	JButton b2 = new JButton("返回");  
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	JTextField tf4 = new JTextField(20);
	JTextField tf5 = new JTextField(20);
	void create() {
		ct=f.getContentPane();
		jp=new JPanel();
		jp1=new JPanel(new GridLayout(5,1));
		jp2=new JPanel(new GridLayout(5,1));
		jp3=new JPanel();
		jp.add(new JLabel("物业费用设置"));
		ct.add(jp,"North");
		jp1.add(new JLabel("编号",SwingConstants.CENTER));
		jp2.add(tf1);
		jp1.add(new JLabel("水价",SwingConstants.CENTER));
		jp2.add(tf2);
		jp1.add(new JLabel("电价",SwingConstants.CENTER));
		jp2.add(tf3);
		jp1.add(new JLabel("燃气费用",SwingConstants.CENTER));
		jp2.add(tf4);
		jp1.add(new JLabel("开始时间",SwingConstants.CENTER));
		jp2.add(tf5);
		jp3.add(b1);
		jp3.add(b2);
		ct.add(jp1,"West");
		ct.add(jp2,"East");
		ct.add(jp3,"South");
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setSize(350,300);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		
		
		if (b1.equals(e.getSource())) { 
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
				String insertStr = "INSERT INTO PriceStandard (PSno,WaterPrice,ElectricityPrice,NaturalGasPrice,StartTime) VALUES('"+tf1.getText()+"',"+tf2.getText()+","+tf3.getText()+","+tf4.getText()+",'"+tf5.getText()+"');";
				sql.executeUpdate(insertStr);
				con.close();
				JOptionPane.showMessageDialog(this, "入录成功！");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "入录失败！");
			}
		}
		
		if (b2.equals(e.getSource())) {
			Manager_Property gl=new Manager_Property();
			gl.create();
			f.dispose();

		}
	}
}

 