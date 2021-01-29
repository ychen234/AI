
public class Point {
	public int a;
	public int b;
	public String c;
	
	public Point(int a, int b) {
		this.a = a;
		this.b = b;
		
		if (b==1) {
			c = "a";
		}else if (b==2) {
			c = "b";
		}else if (b==3) {
			c = "c";
		}else if (b==4) {
			c = "d";
		}else if (b==5) {
			c = "e";
		}else if (b==6) {
			c = "f";
		}else if (b==7) {
			c = "g";
		}else if (b==8) {
			c = "h";
		}
		
	}
	
	public Point(int a, String c) {
		this.a = a;
		if (c.equals("a")) {
			this.b = 1;
			this.c = "a";
		}else if(c.equals("b")) {
			this.b = 2;
			this.c = "b";
		}else if(c.equals("c")) {
			this.b = 3;
			this.c = "c";
		}else if(c.equals("d")) {
			this.b = 4;
			this.c = "d";
		}else if(c.equals("e")) {
			this.b = 5;
			this.c = "e";
		}else if(c.equals("f")) {
			this.b = 6;
			this.c = "f";
		}else if(c.equals("g")) {
			this.b = 7;
			this.c = "g";
		}else if(c.equals("h")) {
			this.b = 8;
			this.c = "h";
		}
	}



	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public String getC() {
		return c;
	}
	
	public String toString() {
		return "(" + a +" , " + c + ")";
	}
}
