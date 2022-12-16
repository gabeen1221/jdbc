package project1;

public class Box {

	private int bno;
	private int uno;
	private int wno;
	public Box(int bno, int uno, int wno) {
	
		this.bno = bno;
		this.uno = uno;
		this.wno = wno;
	}
	@Override
	public String toString() {
		return "Box [bno=" + bno + ", uno=" + uno + ", wno=" + wno + "]";
	}
	public int getBno() {
		return bno;
	}
	public int getUno() {
		return uno;
	}
	public int getWno() {
		return wno;
	}
	
	
	
}
