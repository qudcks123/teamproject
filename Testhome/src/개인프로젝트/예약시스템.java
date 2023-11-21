package 개인프로젝트;

import java.util.*;

public class 예약시스템 extends 좌석타입 {

	public static void main(String[] args) {
		예매정보 res = new 예매정보();
		좌석타입 seat = new 좌석타입();
		for(int i = 0; i<30 ; i++){ 
			v[i] = i + 1 + " ";
			s[i] = i + 1 + " ";
			a[i] = i + 1 + " ";
			b[i] = i + 1 + " ";
		}
		int menu = 0;
		while(menu != 4) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("예약은 1번, 조회는 2번, 취소는 3번, 종료는 4번, 예약된 좌석들의 총 금액을 알고싶다면 0번을 입력하세요. ");
		menu = scanner.nextInt();

		switch(menu)
		{
		case 1:
			seat.예약(v,s,a,b);
			break;
		case 2:
			seat.조회();
			break;
		case 3:
			seat.취소(v,s,a,b);
			break;
		case 4:
			seat.종료();
			break;
		case 0:
			좌석총가격 총금액 = new 좌석총가격();
			System.out.println("현재 총 금액은 " + 총금액.숫자() + "원입니다.");
			break;
		default:
				System.out.println("(오류)없는 메뉴를 조회하였습니다. 처음으로 돌아갑니다.");
				break;
			
		}
			}
	
			}
		}


