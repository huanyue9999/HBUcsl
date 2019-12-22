import java.awt.*;
import java.awt.event.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

class QueryFrame extends JFrame implements ActionListener
{

    JPanel p = new JPanel(new GridLayout(5,4,5,4));    //定义面板，并设置为网格布局，5行4列，组件水平、垂直间距均为3
    JTextField t = new JTextField();            //定义文本框
    JCheckBox checkb_bold;
    JCheckBox checkb_italic;
    String str[]={"sqrt","%","CE","C","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};  //定义字符串数组，为按钮的显示文本赋值
    JButton btn[]=new JButton[str.length];       //声明并创建按钮数组
    double n1,n2,flag_bold = 0 , flag_italic = 0;
    private JMenu[] menus;
    private String colorstr[] = {"黑色","绿色","蓝色","红色"};
    private Color[] colors = {Color.black,Color.GREEN,Color.blue,Color.red};
    private Calcu_Stack exp;   //实例化Calcu_Stack对象进行运算
    public QueryFrame()
    {
        super("Calculator");  

        t.setSize(40,40);
        t.setHorizontalAlignment(JTextField.RIGHT);//设置文字水平对齐方式为右对齐
        t.setFont(new java.awt.Font("黑体",0, 25));
        t.setEditable(false);//文本框不许编辑
        setLayout(new BorderLayout());     //定义窗体布局为边界布局     
        for(int i=0;i<str.length;i++)    //循环定义按钮，并添加到面板中
        {
              btn[i]=new JButton(str[i]);
              p.add(btn[i]);
              btn[i].addActionListener(this);
              if(isNumber(btn[i].getActionCommand()))
              {
                  btn[i].setFont(new java.awt.Font("华文琥珀", 1, 18));
              }
              else
              {
                  btn[i].setFont(new java.awt.Font("行楷", 2, 15));
              }
        }
        this.add(p);
        this.getContentPane().add(t,BorderLayout.NORTH);     //将文本框放置在窗体NORTH位置
        this.getContentPane().add(p,BorderLayout.CENTER);    //将面板放置在窗体CENTER位置
        this.setSize(400,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //实现关闭窗口功能
        this.setLocationRelativeTo(null);               //让窗体居中显示
        this.addMenu();
        this.setVisible(true);
   }

    public void actionPerformed(ActionEvent ev)
    {
        Font font = t.getFont();       //获得文本区的当前字体对象
        int style = font.getStyle();               //获得字形

        //如果输入加减乘除以及数字直接添加
        if(isNumber(ev.getActionCommand()) || ev.getActionCommand() == "+" || ev.getActionCommand() == "-" || ev.getActionCommand() == "*" || ev.getActionCommand() == "/")//如果按下数字键
        {
            if(isNumber(ev.getActionCommand()) && t.getText().equals("0"))
            {
                t.setText(ev.getActionCommand());
            }
            else
            {
                t.setText(t.getText()+ ev.getActionCommand());
            }
        }

        if( ev.getActionCommand() == ".")//如果按下点
        {
            if(t.getText().indexOf(".") != -1)
            {
                Exception e1 = new Exception();
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "操作错误!╮(╯▽╰)╭", "错误",JOptionPane.WARNING_MESSAGE); 
            }
            else
            {
                t.setText(t.getText()+ev.getActionCommand());
            }
        }

        if( ev.getActionCommand() == "=")//如果按下=
        {
            exp = new Calcu_Stack();
            exp.setExp(t.getText());
            t.setText(resultFormat(exp.calcu()));
        }

        if(ev.getActionCommand() == "%" )//如果按下+/-
        {
            double num = Double.parseDouble(t.getText());  //保存原来的值
            if(num != 0)
            {
                double d = num/100;
             
                t.setText(resultFormat(String.valueOf(d)));
            }
        }

        if(ev.getActionCommand() == "sqrt" )//如果按下sqrt
        {
            if((t.getText().indexOf("+") != -1) || (t.getText().indexOf("*") != -1)  || (t.getText().indexOf("/") != -1))   // /后面不能输入0 否则弹出错误信息
            {
                Exception e1 = new Exception();
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "开方系数含有特殊字符！╮(╯▽╰)╭", "错误",JOptionPane.WARNING_MESSAGE);  
            }
            else if((t.getText().indexOf("-") != -1))
            {
                JOptionPane.showMessageDialog(null, "被开方系数不能为负数！╮(╯▽╰)╭", "错误",JOptionPane.WARNING_MESSAGE);  
            }
            else
            {
                double num = Math.sqrt(Double.valueOf(t.getText()));
                t.setText(resultFormat(String.valueOf(num)));
            }
        }

        if(ev.getActionCommand() == "CE" )//如果按下CE
        {
            if(t.getText().length() == 1)
            {
                t.setText("0");
            }
            else
            {
                String s = t.getText().substring(0,t.getText().length()-1);
                t.setText(s);
            }
        }

        if(ev.getActionCommand() == "C" )//如果按下C
        {
            t.setText("0");
        }


        if(ev.getSource() instanceof JMenuItem) //如果选择菜单栏
        {

           if (ev.getActionCommand()=="退出")
           {
                if (JOptionPane.showConfirmDialog(this, "退出计算器？")==0)
                {
                    System.exit(0);                        //单击确认对话框中的“是”按钮，结束程序运行
                }
           }

           if (ev.getActionCommand()=="复制")
               t.copy();                               //将选中文本复制送系统剪贴板
   
           if (ev.getActionCommand()=="黑色")
           {
               Color color = new Color(0,0,0);
               t.setForeground(color);                     //设置文本区颜色
           }
           if (ev.getActionCommand()=="绿色")
           {
               Color color = new Color(0,255,0);
               t.setForeground(color);                     //设置文本区颜色
           }
           if (ev.getActionCommand()=="蓝色")
           {
               Color color = new Color(0,0,255);
               t.setForeground(color);                     //设置文本区颜色
           }
           if (ev.getActionCommand()=="红色")
           {
               Color color = new Color(255,0,0);
               t.setForeground(color);                     //设置文本区颜色
           }
      }

      if (ev.getSource()==checkb_bold)            //粗体
      {
          style = style ^ 1;                     //整数的位运算，异或^
          t.setFont(new Font("宋体", style, 25)); //设置文本区字体
      }

      if (ev.getSource()==checkb_italic)          //斜体
      {
          style = style ^ 2;                     //整数的位运算，异或^
          t.setFont(new Font("宋体", style, 25)); //设置文本区字体
      }

      if(ev.getActionCommand().equals("关于软件"))
      {
          JOptionPane.showMessageDialog(null, "实验6-31 计算器 V 1.2 \n                        ----18计科3班 范少帅", "关于软件",JOptionPane.INFORMATION_MESSAGE);
      }
   }

   public boolean isNumber(String str)  //判断是不是数字
   {
       Pattern pattern = Pattern.compile("[0-9]*");
       Matcher isNum = pattern.matcher(str);
       if(!isNum.matches())
       {
           return false;
       }
       return true; 
   } 

   public String resultFormat(String str) //约束数值格式
   {
        double d = Double.valueOf(str);
        if((int)d != d)
        {
            return String.format("%.14f",Double.valueOf(str)+1e-15);
        }
        else
        {
            return String.format("%.0f",Double.valueOf(str));
        }
   }

   private void addMenu()
   {
       JMenuBar menubar = new JMenuBar();       //菜单栏
       this.setJMenuBar(menubar);               //添加菜单栏
       String menustr[] = {"菜单","编辑","格式","关于"};    //一级菜单
       String menuitemstr[][] = {{"|","退出"},{"复制"},{},{"关于软件"}};//二级菜单
       this.menus = new JMenu[menustr.length];//一级菜单数组
       JMenuItem menuitems[][] = new JMenuItem[menuitemstr.length][];//二级菜单数组
       for(int i=0;i<menuitemstr.length;i++)//添加名称
       {
           this.menus[i] = new JMenu(menustr[i]);
           menubar.add(this.menus[i]);
           menuitems[i] = new JMenuItem[menuitemstr[i].length];
           for(int j=0;j<menuitemstr[i].length;j++)
           {
               if(menuitemstr[i][j].equals("|"))
               {
                   this.menus[i].addSeparator();
               }
               else
               {
                   menuitems[i][j] = new JMenuItem(menuitemstr[i][j]);
                   this.menus[i].add(menuitems[i][j]);
                   menuitems[i][j].addActionListener(this);
               }
           }
       }

       JMenu menu_style = new JMenu("字形");
       menus[2].add(menu_style);
       checkb_bold = new JCheckBox("粗体");               //字形复选框
       menu_style.add(checkb_bold);
       checkb_bold.addActionListener(this);               //复选框注册单击事件监听器
       checkb_italic = new JCheckBox("斜体");
       menu_style.add(checkb_italic);
       checkb_italic.addActionListener(this);

       JMenu menu_color = new JMenu("颜色");
       menus[2].add(menu_color);
       ButtonGroup buttongroup = new ButtonGroup();
       for(int i=0;i<this.colorstr.length;i++)
       {
           JRadioButtonMenuItem rbmi = new JRadioButtonMenuItem(this.colorstr[i]);
           buttongroup.add(rbmi);
           menu_color.add(rbmi);
           rbmi.setForeground(this.colors [i]);
           rbmi.addActionListener(this);
       }

   }



   public static void main(String[] args)//主函数
   {
       new QueryFrame();
   }

} 