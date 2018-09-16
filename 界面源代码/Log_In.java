//登陆界面
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
class Log_In extends JFrame implements ActionListener 
{
	ImageIcon im = new ImageIcon("D:\\2.png");
	JLabel a2 = new JLabel(im);
	JFrame frame = new JFrame("职工/管理员登陆");
	JLabel label1 = new JLabel("用户名");
	JLabel label2 = new JLabel("密码");
	JButton logonButton1 = new JButton("管理员登录");
	JButton logonButton2 = new JButton("职工登录");
	JButton cancelButton = new JButton("退出");
	JTextField username = new JTextField(10);
	JPasswordField password = new JPasswordField(20);
	static String t1;
	static String t2;
	void create() 
	{
		JPanel p = (JPanel) frame.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(a2);
		p.add(label1);
		p.setSize(5, 5);
		p.setLocation(4, 8);
		p.add(username);
		p.setSize(100, 200);
		p.setLocation(800,800);
		p.add(label2);
		p.setSize(50, 20);
		p.setLocation(40, 80);
		p.add(password);
		p.setSize(100, 20);
		p.setLocation(80,120);
		p.add(logonButton1);
		p.add(logonButton2);
		p.add(cancelButton);
		p.setBackground(Color.cyan);
		p.setVisible(true);
		logonButton1.addActionListener(this);
		logonButton2.addActionListener(this);
		cancelButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(200, 100, 600, 300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		t1 = username.getText();
		t2 = password.getText();
		if(e.getSource()==logonButton1)
		{  try{ Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统",t1,t2);
				JOptionPane.showMessageDialog(this, "登录成功！");
				Manager_Feature_Selection gz = new Manager_Feature_Selection ();
				gz.create();
				frame.dispose();
			  } 
			catch(Exception e1){
				JOptionPane.showMessageDialog(null, "输入用户名或密码错误！");
			                }

		}
		if (e.getSource()==logonButton2)
		{
			try {
				Connection con;
				Statement ps;
				ResultSet rs;
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=单位房产管理系统","sa","zhj15717333380"); 
				ps = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs = ps.executeQuery("select Wno,secret from Secret where Wno='"+t1+"';");
				if(rs.next())
				{   
				
					if(rs.getString("secret").trim().equals(t2) && rs.getString("Wno").trim().equals(t1))
					{
						
						User_Feature_Selection yg= new User_Feature_Selection();
						yg.create();
						frame.dispose();
						JOptionPane.showMessageDialog(this, "登录成功！");
						this.dispose();
					}
					else JOptionPane.showMessageDialog(this, "密码错误！");
				
				}
				else {

					JOptionPane.showMessageDialog(this, "用户名不存在！");
				      }
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cancelButton.equals(e.getSource())) // 退出

		{
			System.exit(0);
		}
	}
}
