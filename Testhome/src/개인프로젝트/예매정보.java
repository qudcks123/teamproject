package 개인프로젝트;
import java.util.*;

public class 예매정보 {
	static String v [] = new String[30];
	static String s [] = new String[30];
	static String a [] = new String[30];
	static String b [] = new String[30];
	
	Scanner scanner = new Scanner(System.in);
	
public int 예약번호 = 0;
public int 좌석가격 = 0;
public void 예약자() {
}//Initialization & Overloading
	public void 예약자(int 좌석유형, int 예약좌석, String 예약자명){
		switch(좌석유형)
		{
		case 1:
			예약번호 ++;
			v[예약좌석] = "(" + 예약자명 + "예약번호 : " + 예약번호 + "번) ";
			좌석가격+=180000;
			break;
		case 2:
			예약번호 ++;
			s[예약좌석] = "(" + 예약자명 + "예약번호 : " + 예약번호 + "번) ";
			좌석가격+=150000;
			break;
		case 3:
			예약번호 ++;
			a[예약좌석] = "(" + 예약자명 + "예약번호 : " + 예약번호 + "번) ";
			좌석가격+=120000;
			break;
		case 4:
			예약번호 ++;
			b[예약좌석] = "(" + 예약자명 + "예약번호 : " + 예약번호 + "번) ";
			좌석가격+=100000;
			break;
		}
	}

	
	 public String 정보입력(){
		System.out.println("예약자명을 입력해주세요.");
		String 이름 = scanner.next();
		System.out.println("전화번호를 입력해주세요.");
		String 전화번호 = scanner.next();
		return 이름;
	}
		 public int 숫자(){
			System.out.println("좌석 번호를 입력해주세요.");
			try {
			int 번호 = scanner.nextInt();
			return 번호;
			}
			catch (InputMismatchException e) {			
				System.out.println("(오류) 숫자를 입력해주세요.");				
				return 숫자();
			}

			
		}
}
		
	

