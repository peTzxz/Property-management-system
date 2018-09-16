//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Manager_House extends JFrame implements ActionListener {

	JFrame f = new JFrame("房屋资源模块");
	ImageIcon im = new ImageIcon("D:\\3.jpg");
	JLabel a1 = new JLabel(im);
	JButton b1 = new JButton("房屋维护");
	JButton b2 = new JButton("住房级别维护");
	JButton b3 = new JButton("返回");
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(a1);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.setBackground(Color.CYAN);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setBounds(100, 100, 400,400);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {

		if (b3.equals(e.getSource())) {
			Manager_Feature_Selection d = new Manager_Feature_Selection();
			d.create();
			f.dispose();
		}

		if (b1.equals(e.getSource())) {
			Manager_House_HouseMaintenance yg = new Manager_House_HouseMaintenance();
			yg.create();
			f.dispose();
		}
		if (b2.equals(e.getSource())) {

			Manager_House_Class gz = new Manager_House_Class();
			gz.create();
			f.dispose();	
		}
	
	}
}
