import java.util.Scanner; //import문 선언
class Phone{ //Phone 클래스 생성
	String name,number; //이름과 전화번호 변수 생성
	public Phone(String name,String number) { //Phone Constructor 생성
		this.name = name; //setName
		this.number = number; //setNumber
	}
}
public class PhoneBook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); //scanner 객체 생성
System.out.print("Number of Person>>"); //사람 수를 물어보는 문자 출력
int person = scanner.nextInt(); //입력값 저장
Phone [] c;//Phone 클래스의 객체를 저장할 수 있는 배열 c를 선언
c = new Phone[person]; 
// 배열 c의 크기를 person값으로 초기화
for(int i = 0; i< c.length ;i++) {//c의 길이만큼 for문 반복
	System.out.print("Name and Phonenumber (ex. 홍길동 010-1234-5678) >> ");
	//이름과 전화번호를 묻는 문자 출력
	String name = scanner.next(); //처음오는 문자를 이름으로 저장
	String number = scanner.next(); //두 번째 오는 문자를 전화번호로 저장
	c[i] = new Phone(name, number);
	// 입력값을 받아 Phone 클래스에 정의되어 있는 이름과 전화번호를 c배열에 저장
}
System.out.println("Store Done"); //이름과 전화번호를 모두 입력 받으면 문자 출력
	for(int j = 0;  ; j++) { //계속해서 검색하는 이름을 받기 때문에 for(j)문 무한 반복
		System.out.print("Name to search >> "); //이름을 물어보는 문자 출력
		String search = scanner.next(); //찾는 이름 저장
		int answer = 0; //answer 변수 생성 및 초기화
		for(int i = 0; i<c.length ;i++) { //배열 c의 길이만큼 for(i)문 반복
			if(search.equals(c[i].name)) { //찾는 이름과 배열 c에 저장된 이름이 일치할 경우 실행
				System.out.println(c[i].name + "'s number is " + c[i].number);
				answer = 1; //for(i)문을 실행한 흔적을 남기기 위해 answer 값을 1로 변경
				break;
				}
			//c배열에 같이 저장되어있는 이름과 전화번호 출력하고 for(i)문 탈출, 즉 다시 이름을 물어봄
		}
		if((answer == 0) && (search.equals("Stop"))) { 
			//for(i)문을 실행하지 않고 (answer = 0), Stop을 입력할 경우 if문 실행
			System.out.println(); 
			break;
		}//한 줄 띄우고 for(j)문 탈출, 즉 이름을 더이상 묻지 않음
		else if (answer ==0){ //for(i)문을 거치지않고(answer = 0), Stop을 입력하지 않았다면
				System.out.println(search + " not found");
			
		}
			//없으면 검색한 내용과 문자를 출력하고 for(j)문으로 시작으로 이동, 즉 다시 이름을 물어봄
		}
			
		}
}


