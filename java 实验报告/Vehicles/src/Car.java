public class Car extends Vehicles
{
	String unique;
	public Car(String name,String color,int  seat,String unique){
	super.name=name;
	super.color=color;
	super.seat=seat;
	this.unique=unique;
	}
	public void showDetail(){
	super.showDetail();
	System.out.println(name+"特有的行为有："+unique);
	}


}