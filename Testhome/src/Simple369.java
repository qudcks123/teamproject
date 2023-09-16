import java.util.Scanner; //import문 선언
public class Simple369 {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in); //scanner 객체 생성
	System.out.print("Enter integer value 1~99 : "); //정수 입력(1~99)
	int number = scanner.nextInt(); //입력된 정수값을 저장
	int a = number/10;
	int b = number%10;
	//10의 자리와 1의 자리 분리
	int clap = 0; //clap 변수 초기화
	if(a%3==0) {
		clap++;
	} //10의자리가 3의 배수일 경우 clap값 1 증가
	if(b%3==0) {
		clap++;
	} //1의 자리가 3의 배수일 경우 clap값 1 증가
	switch(clap) {
	case 2:
		System.out.println("박수짝짝");
		break; //clap값이 2일 경우 "박수짝짝" 출력
	case 1:
		System.out.println("박수짝");
		break; //clap값이 1일 경우 "박수짝" 출력
	case 0:
		System.out.println("No 3, 6, or 9");
		break; //clap값이 0일 경우 "No 3, 6, or 9" 출력
	} //clap 값에 따라 다른 문자 출력하기
scanner.close(); //scanner 객체 종료
	}

}
