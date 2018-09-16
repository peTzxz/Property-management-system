//系统模块
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class System_In extends JFrame implements ActionListener {
		JFrame frame = new JFrame("欢迎进入单位房产管理系统");
		JLabel label = new JLabel("", JLabel.CENTER);
		JButton button1 = new JButton("进入系统");
		JButton button2 = new JButton("退出系统");
		ImageIcon im = new ImageIcon("D:\\1.png");
		JLabel a1 = new JLabel(im);
		void Create() {
			JPanel pcontentPane = (JPanel) frame.getContentPane();
			pcontentPane.add(a1);
			pcontentPane.add(label);
			pcontentPane.setLayout(new FlowLayout());
			pcontentPane.add(button1);
			pcontentPane.add(button2);	
			pcontentPane.setVisible(true);
			button1.addActionListener(this);
			button2.addActionListener(this);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setBounds(200, 100, 550,188);
			frame.setVisible(true);
		}
	public static void main(String[] args) {
		System_In dome = new System_In();
		dome.Create();
	}

	public void actionPerformed(ActionEvent e) {
		if (button1.equals(e.getSource())) {
			Log_In dl = new Log_In();
			dl.create();
			frame.dispose();
		}
		if (button2.equals(e.getSource())) {// 退出
			System.exit(0);

		}
	}
}