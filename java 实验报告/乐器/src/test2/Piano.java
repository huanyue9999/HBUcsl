package test2;

public class Piano extends Instrument{
	public Piano(String name){
		this.setName(name);
	}
	public void play(){
		System.out.println(getName()+"是弹得！！！");
	}
}
