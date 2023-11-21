package AdvancedMaterial;
import java.util.Scanner;

public class caculate {
private int a;
private int b;

public int add(int a, int b, String c) {
	return a + b;
}

public int sub(int a, int b, String c) {
	return a - b;
}

public int mul(int a, int b, String c) {
	return a * b;
}

public int div(int a, int b, String c) {
	return a / b;
}

static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner scanner = new Scanner(System.in);
System.out.println("Input two operands and operator >>");
int a = scanner.nextInt();
int b = scanner.nextInt();
String c = scanner.next();

	}
}
