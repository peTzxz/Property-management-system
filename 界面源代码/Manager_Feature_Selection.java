//管理员功能主界面
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Manager_Feature_Selection extends JFrame implements ActionListener {

	JFrame f = new JFrame("功能选择");
	JButton b1 = new JButton("物业费用模块");
	JButton b2 = new JButton("房屋资源模块");
	JButton b3 = new JButton("职工信息模块");
	JButton b6 = new JButton("返回");
	ImageIcon im = new ImageIcon("D:\\3.jpg");
	JLabel a1 = new JLabel(im);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b6);
		p.add(a1);
		p.setBackground(Color.cyan);
		p.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b6.addActionListener(this);
		f.setBounds(200, 100, 400,400);
		f.setVisible(true);
	}
public void actionPerformed(ActionEvent e) {

		if (b6.equals(e.getSource())) {
			Log_In d = new Log_In();
			d.create();
			f.dispose();
		}

		if (b3.equals(e.getSource())) {
			Manager_WorkInformation yg = new Manager_WorkInformation ();
			yg.create();
			f.dispose();
		}
		if (b1.equals(e.getSource())) {

			Manager_Property gz = new Manager_Property();
			gz.create();
			f.dispose();
		}
		if (b2.equals(e.getSource())) {

			Manager_House gz = new Manager_House();
			gz.create();
			f.dispose();
		}
	}
}