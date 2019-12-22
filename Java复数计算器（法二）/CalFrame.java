package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalFrame extends JFrame implements ActionListener{
	JLabel label1 = new JLabel("第一个复数");
	JLabel label2 = new JLabel("第二个复数");
	JLabel label3 = new JLabel("计算结果");
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	JTextField textField = new JTextField();
	JRadioButton radioButton1 = new JRadioButton("+");
	JRadioButton radioButton2 = new JRadioButton("-");
	JRadioButton radioButton3 = new JRadioButton("*");
	JRadioButton radioButton4 = new JRadioButton("/");
	ButtonGroup buttonGroup1 = new ButtonGroup();
	ButtonGroup buttonGroup2 = new ButtonGroup();
	JButton button = new JButton("计算");
	public CalFrame() {
		try {
			Init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void Init() throws Exception{
		// TODO Auto-generated method stub
		getContentPane().setLayout(null);
		label1.setBounds(new Rectangle(78, 60, 105, 31));
		label2.setBounds(new Rectangle(80, 146, 87, 32));
		textField1.setBounds(new Rectangle(185, 59, 152, 28));
		textField2.setBounds(new Rectangle(187, 143, 151, 30));
		button.addActionListener(this);
		textField.setEnabled(false);
		textField.setBounds(new Rectangle(189, 196, 150, 30));
		label3.setBounds(new Rectangle(81, 196, 10745, 26));
		radioButton1.setBounds(new Rectangle(113, 111, 44, 23));
		radioButton2.setBounds(new Rectangle(176, 112, 48, 23));
		radioButton3.setBounds(new Rectangle(235, 112, 43, 23));
		radioButton4.setBounds(new Rectangle(295, 110, 38, 24));
		button.setBounds(new Rectangle(154, 248, 129, 34));
		this.getContentPane().add(label1);
		this.getContentPane().add(label3);
		this.getContentPane().add(textField);
		this.getContentPane().add(label2);
		this.getContentPane().add(textField2);
		this.getContentPane().add(textField1);
		this.getContentPane().add(radioButton3);
		this.getContentPane().add(radioButton2);
		this.getContentPane().add(radioButton1);
		this.getContentPane().add(radioButton4);
		this.getContentPane().add(button);
		radioButton1.setSelected(true);
		buttonGroup1.add(radioButton1);
		buttonGroup1.add(radioButton2);
		buttonGroup1.add(radioButton3);
		buttonGroup1.add(radioButton4);
		this.setTitle("简易计算器");
		this.setVisible(true);
		this.setSize(450, 350);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//获取数据

		String op="" ;  //运算符号
		if (radioButton1.isSelected()) {
			op = radioButton1.getActionCommand();
		} else if (radioButton2.isSelected()) {
			op = radioButton2.getActionCommand();
		} else if (radioButton3.isSelected()) {
			op = radioButton3.getActionCommand();
		} else if (radioButton4.isSelected()) {
			op = radioButton4.getActionCommand();
		}
		//验证数据
		String d1 = textField1.getText();  //第一位数
		String d2 = textField2.getText();  //第二位数
		Complex a1 = new Complex(d1);
		Complex a2 = new Complex(d2);
		
		//将数据转换为double类型进行计算
		Calculate c = new Calculate();
		c.cal(a1.real, a1.image, a2.real, a2.image,op);
        if(c.getimage()<0&&c.getreal()!=0)
        {
        	textField.setText(String.valueOf(c.getreal())+String.valueOf(c.getimage())+'i');
        }
        else if(c.getimage()>0&&c.getreal()!=0)
        {
        	textField.setText(String.valueOf(c.getreal())+'+'+String.valueOf(c.getimage())+'i');
        }
        else if(c.getreal()==0&&c.getimage()!=0)
        {
        	textField.setText(String.valueOf(c.getimage())+'i');
        }
        else if(c.getimage()==0)
        {
        	textField.setText(String.valueOf(c.getreal()));
        }
	}
	
	public static void main(String[] args) {
		CalFrame calFrame = new CalFrame();
	}
}
