package test2;

public class InstrumentTest {
	public String testPlay(Instrument a){
		System.out.println("test Play:");
		a.play();
		return a.getName();
	}
	public static void main(String[]args){
		Piano piano = new Piano("钢琴");
		Violin violin = new Violin("小提琴");
		InstrumentTest b= new InstrumentTest();
		b.testPlay(violin);
		System.out.println("测试2：");
		b.testPlay(piano);
	}
}
