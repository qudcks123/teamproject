package 개인프로젝트;
import java.util.*;

public class 좌석타입 extends 예매정보{
	int 좌석유형;
	int v잔여좌석 = 30, s잔여좌석 = 30, a잔여좌석 = 30, b잔여좌석 = 30;

	Scanner ch = new Scanner(System.in);
	
public void 예약 (String v [] , String s [], String a [], String b []) {
	
	System.out.println("1. V석(" + v잔여좌석 + "석) 180000원");
	System.out.println("2. S석(" + s잔여좌석 + "석) 150000원");
	System.out.println("3. A석(" + a잔여좌석 + "석) 120000원");
	System.out.println("4. B석(" + b잔여좌석 + "석) 100000원");
	System.out.println("예약하고자 하는 좌석 타입을 선택해주세요.");
	System.out.println("(예약자가 없는 좌석번호는 숫자로 표시됩니다.)");
	try{
		좌석유형 = ch.nextInt();
		if(좌석유형 < 1 || 좌석유형 > 4) {
			System.out.println("(오류)잘못된 좌석 타입을 입력하셨습니다.");
			예약(v,s,a,b);
	}
	}
	catch (InputMismatchException e) {
		System.out.println("(오류) 1~4까지의 숫자를 입력하였는지 확인바랍니다.");
		예약(v,s,a,b);
	}

	switch(좌석유형) {
	case 1:
		while(true) {
		System.out.println("동반 예약을 하시겠습니까? Y? N?");
		String answer = ch.next();
		if(answer.equals("Y")) {
		for(int count = 0; count < 2 ; count++) {
			System.out.println("V 좌석을 선택하셨습니다. >>");
			for(int i = 0 ; i<30 ; i++)
				System.out.print(v[i]);
			System.out.println();
			String 예약자명 = 정보입력() + " ";
			int 예약좌석 = 숫자() - 1;
			try {
				예약자(좌석유형, 예약좌석, 예약자명);
				}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
				if(count == 1) {
				System.out.println("(오류)동반자 예약이 잘못되었습니다.");
				예약번호--;
				좌석가격 = 0;
				continue;
				}
				break;
				}
			System.out.println("(성공) 예약이 완료되었습니다.");
			v잔여좌석--;
			System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
			
		}
		if(좌석가격 !=0)
		System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
		좌석가격 = 0;
			break;
		}
		else if(answer.equals("N")) {
				System.out.println("V 좌석을 선택하셨습니다. >>");
				for(int i = 0 ; i<30 ; i++)
					System.out.print(v[i]);
				System.out.println();
				String 예약자명 = 정보입력() + " ";
				int 예약좌석 = 숫자() - 1;
				try {
					예약자(좌석유형, 예약좌석, 예약자명);
					}
				catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
					예약번호--;
					좌석가격 = 0;
					break;
					}
				System.out.println("(성공) 예약이 완료되었습니다.");
				v잔여좌석--;
				System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
				System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
				좌석가격 = 0;
				break;
			}
		else System.out.println("(오류) Y와 N 중 하나의 값만 입력하시오.");
		}
				break;
		
	case 2:
		while(true) {
		System.out.println("동반 예약을 하시겠습니까? Y? N?");
		String answer = ch.next();
		if(answer.equals("Y")) {
		for(int count = 0; count < 2 ; count++) {
			System.out.println("S 좌석을 선택하셨습니다. >>");
			for(int i = 0 ; i<30 ; i++)
				System.out.print(s[i]);
			System.out.println();
			String 예약자명 = 정보입력() + " ";
			int 예약좌석 = 숫자() - 1;
			try {
				예약자(좌석유형, 예약좌석, 예약자명);
				}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
				예약번호--;
				좌석가격 = 0;
				if(count == 1) {
				System.out.println("(오류)동반자 예약이 잘못되었습니다.");
				예약번호--;
				continue;
				}
				break;
				}
			System.out.println("(성공) 예약이 완료되었습니다.");
			s잔여좌석--;
			System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
			
		}
		if(좌석가격 !=0)
		System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
		좌석가격 = 0;
			break;
		}
		else if(answer.equals("N")) {
				System.out.println("S 좌석을 선택하셨습니다. >>");
				for(int i = 0 ; i<30 ; i++)
					System.out.print(s[i]);
				System.out.println();
				String 예약자명 = 정보입력() + " ";
				int 예약좌석 = 숫자() - 1;
				try {
					예약자(좌석유형, 예약좌석, 예약자명);
					}
				catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
					예약번호--;
					좌석가격 = 0;
					break;
					}
				System.out.println("(성공) 예약이 완료되었습니다.");
				s잔여좌석--;
				System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
				System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
				좌석가격 = 0;
				break;
			}
		else System.out.println("(오류) Y와 N 중 하나의 값만 입력하시오.");
		}
				break;
		
	case 3:
		
		while(true) {
		System.out.println("동반 예약을 하시겠습니까? Y? N?");
		String answer = ch.next();
		if(answer.equals("Y")) {
		for(int count = 0; count < 2 ; count++) {
			System.out.println("A 좌석을 선택하셨습니다. >>");
			for(int i = 0 ; i<30 ; i++)
				System.out.print(a[i]);
			System.out.println();
			String 예약자명 = 정보입력() + " ";
			int 예약좌석 = 숫자() - 1;
			try {
				예약자(좌석유형, 예약좌석, 예약자명);
				}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
				if(count == 1) {
				System.out.println("(오류)동반자 예약이 잘못되었습니다.");
				예약번호--;
				좌석가격 = 0;
				continue;
				}
				break;
				}
			System.out.println("(성공) 예약이 완료되었습니다.");
			a잔여좌석--;
			System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
		}
		if(좌석가격 !=0)
		System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
		좌석가격 = 0;
			break;
		}
		else if(answer.equals("N")) {
				System.out.println("A 좌석을 선택하셨습니다. >>");
				for(int i = 0 ; i<30 ; i++)
					System.out.print(a[i]);
				System.out.println();
				String 예약자명 = 정보입력() + " ";
				int 예약좌석 = 숫자() - 1;
				try {
					예약자(좌석유형, 예약좌석, 예약자명);
					}
				catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
					예약번호--;
					좌석가격 = 0;
					break;
					}
				System.out.println("(성공) 예약이 완료되었습니다.");
				a잔여좌석--;
				System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
				System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
				좌석가격 = 0;
				break;
			}
		else System.out.println("(오류) Y와 N 중 하나의 값만 입력하시오.");
		}
				break;
		
		
	case 4:
		while(true) {
		System.out.println("동반 예약을 하시겠습니까? Y? N?");
		String answer = ch.next();
		if(answer.equals("Y")) {
		for(int count = 0; count < 2 ; count++) {
			System.out.println("B 좌석을 선택하셨습니다. >>");
			for(int i = 0 ; i<30 ; i++)
				System.out.print(b[i]);
			System.out.println();
			String 예약자명 = 정보입력() + " ";
			int 예약좌석 = 숫자() - 1;
			try {
				예약자(좌석유형, 예약좌석, 예약자명);
				}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
				if(count == 1) {
				System.out.println("(오류)동반자 예약이 잘못되었습니다.");
				예약번호--;
				continue;
				}
				break;
				}
			System.out.println("(성공) 예약이 완료되었습니다.");
			b잔여좌석--;
			System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
		}
		if(좌석가격 !=0)
		System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
		좌석가격 = 0;
			break;
		}
		else if(answer.equals("N")) {
				System.out.println("B 좌석을 선택하셨습니다. >>");
				for(int i = 0 ; i<30 ; i++)
					System.out.print(b[i]);
				System.out.println();
				String 예약자명 = 정보입력() + " ";
				int 예약좌석 = 숫자() - 1;
				try {
					예약자(좌석유형, 예약좌석, 예약자명);
					}
				catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("(오류)잘못된 좌석번호를 입력하셨습니다.");
					break;
					}
				System.out.println("(성공) 예약이 완료되었습니다.");
				b잔여좌석--;
				System.out.println("당신의 예약번호는 " + 예약번호 + "번 입니다.");
				System.out.println("최종 결제 금액은 " + 좌석가격 + "원 입니다.");
				좌석가격 = 0;
				break;
			}
		else System.out.println("(오류) Y와 N 중 하나의 값만 입력하시오.");
		}
				break;
		
	}
}//예약 기능 종료


	public void 조회() {
		System.out.print("V좌석: ");
		for(int i=0; i<30; i++) {
			System.out.print(v[i]);
		}
		System.out.println();
		
		
		System.out.print("S좌석: ");
		for(int i=0; i<30; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
		
		System.out.print("A좌석: ");
		for(int i=0; i<30; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
		
		System.out.print("B좌석: ");
		for(int i=0; i<30; i++) {
			System.out.print(b[i]);
		}
		System.out.println();
		System.out.println("조회를 완료했습니다.");
	}//조회 기능 종료
	
	public void 취소(String v [], String s [], String a [], String b []){
		while(true) {
		System.out.print("취소할 예약번호를 입력해주세요.");
		Scanner 입력 = new Scanner(System.in);
		try {
		int 입력번호 = 입력.nextInt();
		String 입력된번호 = Integer.toString(입력번호);
		for(int i = 0; i<30 ; i++) {

			if(v[i].contains("예약번호 : " + 입력된번호 + "번")) {
				v[i] = i + 1 + " ";
				System.out.println("해당되는 예약번호가 취소되었습니다. 180000원을 환불합니다.");
				v잔여좌석++;
				break;
			}
			else if(s[i].contains("예약번호 : " + 입력된번호 + "번")) {
				s[i] = i + 1 + " ";
				System.out.println("해당되는 예약번호가 취소되었습니다. 150000원을 환불합니다.");
				s잔여좌석++;
				break;
			}
			else if(a[i].contains("예약번호 : " + 입력된번호 + "번")) {
				a[i] = i + 1 + " ";
				System.out.println("해당되는 예약번호가 취소되었습니다. 120000원을 환불합니다.");
				a잔여좌석++;
				break;
			}
			else if(b[i].contains("예약번호 : " + 입력된번호 + "번")) {
				b[i] = i + 1 + " ";
				System.out.println("해당되는 예약번호가 취소되었습니다. 100000원을 환불합니다.");
				b잔여좌석++;
				break;
			}
			}	
		if(입력번호 > 예약번호 || 입력번호 < 0)
		System.out.println("(오류) 잘못된 예약번호를 입력하였습니다.");
			break;

		}
		
		catch (InputMismatchException e) {
			System.out.println("(오류) 숫자를 입력해주시기 바랍니다.");
			break;
		}
		}
	}//취소 기능 종료
	public void 종료 (){
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
	}//종료 기능 종료
		
}

