
class ColorPoint extends Mypoint {
private String color;
	public void setColor(String color){
		this.color = color;
	}
public void showColorPoint() {
	System.out.println(color);
	System.out.println("Point(" + x + "," + y + ")");
}
}