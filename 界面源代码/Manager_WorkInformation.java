//
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Manager_WorkInformation extends JFrame implements ActionListener {

	JFrame f = new JFrame("职工信息管理模块");
	ImageIcon im = new ImageIcon("D:\\3.jpg");
	JLabel a1 = new JLabel(im);
	JButton b1 = new JButton("职工维护");
	JButton b2 = new JButton("部门维护");
	JButton b3 = new JButton("职务维护");
	JButton b4 = new JButton("返回");
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(a1);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		f.setBounds(100, 100, 400, 400);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {

		if (b4.equals(e.getSource())) {
			Manager_Feature_Selection d = new Manager_Feature_Selection();
			d.create();
			f.dispose();
		}

		if (b1.equals(e.getSource())) {
			Manager_Worker yg = new Manager_Worker();
			yg.create();
			f.dispose();
		}
		if (b2.equals(e.getSource())) {

			Manager_Maintenance_Department gz = new Manager_Maintenance_Department();
			gz.create();
			f.dispose();	
		}
		if (b3.equals(e.getSource())) {

			Manager_Position gz1 = new Manager_Position();
			gz1.create();
			f.dispose();	
		}
	
	}
}
