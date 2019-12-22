import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;


public  class Complex1 implements ActionListener {
    protected JComboBox<String> combox_size;
    protected JComboBox<String> combox_size1;
    String[] s= {"+","-","*","/"};

    String s1,s2,s3,s4,s5,s6;      //s、s0为运算符号，s1,s3,s5为两个虚数的实部，s2,s4,s6为两个虚数的虚部

    private JFrame JComplex;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JButton button;
    JPanel j1=new JPanel();
    JPanel j2=new JPanel();
    JPanel j3=new JPanel();
    JPanel j4=new JPanel();
    

    public Complex1() {

        JComplex = new JFrame();
        JComplex.setLayout(new FlowLayout());
        JComplex.setTitle("复数运算器");
        JComplex.setBounds(220, 100, 500, 300);



        JPanel Jcomplex = new JPanel();
        Jcomplex.setBorder(new EmptyBorder(20, 20, 20, 20));//边界距上下左右的距离
        Jcomplex.setLayout(new GridLayout(4, 6, 2, 3));


        
        JLabel label = new JLabel(" 请输入复数：");
        label.setFont(new Font("宋体",Font.BOLD,19));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        j1.add(label);

        textField_1 = new JTextField(10);//设置文本行
        textField_1.setFont(new Font("宋体", Font.BOLD, 18));
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        j1.add(textField_1);//在面板上增加文本行

        JLabel label_1 = new JLabel("+");
        label_1.setFont(new Font("宋体", Font.BOLD, 19));
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        j1.add(label_1);

        textField_2 = new JTextField(10);
        textField_2.setFont(new Font("宋体", Font.BOLD, 18));
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        j1.add(textField_2);

        JLabel label_2 = new JLabel("i");
        label_2.setFont(new Font("宋体", Font.BOLD, 19));
        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        j1.add(label_2);
        j1.setLayout(new FlowLayout(FlowLayout.LEFT));
        Jcomplex.add(j1);
        
        
        
        //----------------------------2
        
        
        this.combox_size1=new JComboBox<>(s);
        this.combox_size1.setEditable(true);
        j2.add(this.combox_size1);

        textField_3 = new JTextField(10);
        textField_3.setFont(new Font("宋体", Font.BOLD, 18));
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        j2.add(textField_3);

        JLabel label_8 = new JLabel("+");
        label_8.setFont(new Font("宋体", Font.BOLD, 19));
        label_8.setHorizontalAlignment(SwingConstants.CENTER);
        j2.add(label_8);

        textField_4 = new JTextField(10);
        textField_4.setFont(new Font("宋体", Font.BOLD, 18));
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        j2.add(textField_4);

        JLabel label_9 = new JLabel("i");
        label_9.setFont(new Font("宋体", Font.BOLD, 18));
        label_9.setHorizontalAlignment(SwingConstants.CENTER);
        j2.add(label_9);

        
        Jcomplex.add(j2);
//3--------------------------------------------------
        combox_size=new JComboBox<String>(s);
        this.combox_size.setEditable(true);
        j3.add(this.combox_size);

        textField_7 = new JTextField(10);
        textField_7.setFont(new Font("宋体", Font.BOLD, 18));
        textField_7.setHorizontalAlignment(SwingConstants.CENTER);
        j3.add(textField_7);

        JLabel label_18 = new JLabel("+");
        label_18.setFont(new Font("宋体", Font.BOLD, 19));
        label_18.setHorizontalAlignment(SwingConstants.CENTER);
        j3.add(label_18);

        textField_8 = new JTextField(10);
        textField_8.setFont(new Font("宋体", Font.BOLD, 18));
        textField_8.setHorizontalAlignment(SwingConstants.CENTER);
        j3.add(textField_8);

        JLabel label_19 = new JLabel("i");
        label_19.setFont(new Font("宋体", Font.BOLD, 18));
        label_19.setHorizontalAlignment(SwingConstants.CENTER);
        j3.add(label_19);

        
        //this.JComplex.setLayout(new FlowLayout());
        combox_size.setVisible(true);
        Jcomplex.add(j3);
//4-----------------------------
        button = new JButton("=");//=按钮
        button.setFont(new Font("宋体", Font.BOLD, 20));
        button.addActionListener(this);//按钮监听
        j4.add(button);//在面板上增加按钮

        textField_5 = new JTextField(10);
        textField_5.setFont(new Font("宋体", Font.BOLD, 18));
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        j4.add(textField_5);

        JLabel label_11 = new JLabel("+");
        label_11.setFont(new Font("宋体", Font.BOLD, 19));
        label_11.setHorizontalAlignment(SwingConstants.CENTER);
        j4.add(label_11);

        textField_6 = new JTextField(10);
        textField_6.setFont(new Font("宋体", Font.BOLD, 18));
        textField_6.setHorizontalAlignment(SwingConstants.CENTER);
        j4.add(textField_6);

        JLabel label_12 = new JLabel("i");
        label_12.setFont(new Font("宋体", Font.BOLD, 19));
        label_12.setHorizontalAlignment(SwingConstants.CENTER);
        j4.add(label_12);
        Jcomplex.add(j4);

        JComplex.getContentPane().add(Jcomplex);//在这个容器上增加新控件
        JComplex.setVisible(true);
        JComplex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭
    }


public Complex operate (Complex c1,String s,Complex c2){
        
    if(s=="+"){
        return c1.add(c2);
    }
    else if(s=="-"){
        return c1.minus(c2);
    }
    else if(s=="*"){
        return c1.mult(c2);
    }
    else{
        return c1.dev(c2);
    }

}
    /*点击按钮事件*/
    //动作事件处理方法
    public void actionPerformed(ActionEvent e) {
        Complex c1,c2,c3,c4;
            try
            {
               
                String S1=combox_size1.getSelectedItem().toString();
                String S2=combox_size.getSelectedItem().toString();
                s1 = textField_1.getText();
                s2 = textField_2.getText();
                s3 = textField_3.getText();
                s4 = textField_4.getText();
                s5 = textField_7.getText();
                s6 = textField_8.getText();
                c1 = new Complex(s1,s2);
                c2 = new Complex(s3,s4);
                c3 = new Complex(s5,s6);
                Complex c = operate(c1,S1,c2);
                c= operate(c,S2,c3);
                textField_5.setText(String.valueOf(c.x));
                textField_6.setText(String.valueOf(c.y));
            }
            catch(NumberFormatException e1)
            {

                textField_5.setText("ERROR");
                textField_6.setText("ERROR");
            }

    }
    public static void main(String[] args) {
        new Complex1();
    }
}
