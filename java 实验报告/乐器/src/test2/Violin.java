package test2;

public class Violin extends Instrument{
	public Violin(String name){
		this.setName(name);
	}
	public void play(){
		System.out.println(getName()+"是拉的！！！");
	}
}
