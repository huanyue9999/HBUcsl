package calculator;

public class Calculate {
	private double real,image;
	public Calculate() {
		real = 0;
		image = 0;
	}
	public void cal(double real1,double image1,double real2,double image2,String op)
	{
		switch(op) {
		case "+":
		{
			real = real1+real2;
			image = image1+image2;
			break;
		}
		case "-":
		{
			real = real1-real2;
			image = image1-image2;
			break;
		}
		case "*":
		{
			this.real = real1*real2-image1*image2;
			this.image = real1*image2+image1*real2;
			break;
		}
		case "/":
		{
			this.real = (real1*real2+image1*image2)/(real2*real2+image2*image2);
			this.image = (image1*real2-real1*image2)/(real2*real2+image2*image2);
			break;
		}
		default:
			break;
		}
		
	}
	public double getreal()
	{
		return this.real;
	}
	public double getimage()
	{
		return this.image;
	}
	public void show()
	{
		System.out.println(this.real);
	}

}
