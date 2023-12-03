
public class ArrayParameterEx {
	static void replaceSpace(char a[]) {
		for(int i = 0; i<a.length; i++) {
			if(a[i] == ' ' )
					a[i] = ',';
		}
		System.out.println("");
	}
static void printCharArray(char a[]) {
	System.out.print(a);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
char c[] = {'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.'};

printCharArray(c);
replaceSpace(c);
printCharArray(c);
	}

}
