package prac;

class Point {
	private int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

public String toString() {
	return "Point(" + x + "," + y + ")";
}
public boolean equals(Object obj) {
	Point p = (Point)obj;
	if (x == p.x && y == p.y) return true;
	else return false;
}
}
public class ObjectPropertyEx {
	public static void print(Object obj) {
		System.out.println(obj.getClass().getName());
		System.out.println(obj.hashCode());
		System.out.println(obj.toString());
		System.out.println(obj);
	}
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		print(p);

		System.out.println(p.toString());
		System.out.println(p);
		System.out.println(p + "입니다.");
		
		Point a = new Point(2,3);
		Point b = new Point(2,3);
		Point c = new Point(3,4);
		
		if(a == b) {
			System.out.println("a == b");
		}
		if (a.equals(b)) {
			System.out.println("a is equal to b");
		}
		if (a.equals(c)) {
			System.out.println("a is equal to c");
		}
	}

}
