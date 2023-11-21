import java.util.Scanner;
 class Mypoint {
	 protected int x, y;
public void set(int x, int y) {
	this.x =x;
	this.y =y;
}

public void showPoint() {
	System.out.println("Point(" + x + "," + y + ")");
}
}