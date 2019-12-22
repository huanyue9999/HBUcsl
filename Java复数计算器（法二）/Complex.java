package calculator;


public class Complex {
	protected double real,image;
	public Complex()
	{
		this(0,0);
	}
	public Complex(double real,double image)
	{
		this.real = real;
		this.image = image;
	}
	public Complex(String s) throws NumberFormatException
	{
		try
		{
			int i=0,j=0,flag=0;
			int q = 0;
			for(i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='+'&&i!=0)
				{
					flag=1;break;
				}
				else if(s.charAt(i)=='-'&&i!=0)
				{
					flag = 2;
					q=i;
					break;
				}
			}
			if(flag == 1)
			{
				real=Double.parseDouble(s.substring(0, s.indexOf('+')));
				image=Double.parseDouble(s.substring(s.indexOf('+'),s.indexOf('i')));
			}
			else if(flag == 2)
			{
				real=Double.parseDouble(s.substring(0, q));
				
				image=Double.parseDouble(s.substring(q,s.indexOf('i')));
			}
			
		
		}

		
		catch(NumberFormatException numb)
		{
			System.out.println("字符串不能转化,数值格式异常");
		}
		catch(Exception ex)
		{
			System.out.println("字符串不能转化,数值格式异常");
		}
	}
	public static Complex parseComplex(String s) throws NumberFormatException	
	{
		Complex c=new Complex(s);
		return c;		
	}
	
	public void add(Complex c1)
	{
		this.real = this.real+c1.real;
		this.image = this.image +c1.image;
		
	}
	
	
}