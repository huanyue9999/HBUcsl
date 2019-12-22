package test2;

public abstract class Instrument {
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public void play(){
		System.out.println(name+"音乐好听！！！");
	}
}
