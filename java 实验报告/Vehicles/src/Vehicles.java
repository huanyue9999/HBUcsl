public class Vehicles
{
	String name;
	String color;
	int  seat;
	public void showDetail(){
	System.out.println("名称："+name+"颜色："+color+"座位数："+seat);
	}
}
//class Train extends Vehicles{
//	String unique;
//	public Train(String name,String color,int seat,String unique)
//	{
//		super.name = name;
//		super.color = color;
//		super.seat = seat;
//		this.unique = unique;
//	}
//	public void showDetail()
//	{
//		super.showDetail();
//		System.out.println(name+"特有的行为有："+unique);
//	}
//}